package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.edu.domain.Movie;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrawlerMovie {
    //爬取不入库
    public static List<Movie> Crawler(String name){
        //根据name值(即电影名)拼接电影网址
        String url = String.format("https://xxxxx %s", name);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到搜索结果电影的列表
        Elements elements = doc.select("li.list_item");
        List<Movie> movies = new ArrayList<Movie>();
        Movie movie;
        //遍历列表
        for (Element e : elements){
            //设置实体类的信息
            movie = new Movie();
            //电影名称
            movie.setName(e.attr("data-widget-searchlist-tvname"));
            //播放地址
            movie.setPlayUrl(e.select("a").attr("href"));
            //图片地址
            movie.setImageUrl(e.select("a").select("img").attr("src"));
            //评分
            Element eScore = e.select("div").select("p.result-info-score").first();
            //因为搜索的结果不一定是电影，所有我是判断当前列表有无 评分 这一标签，若有，则为电影，反之则不是
            if (eScore != null){
                movie.setScore(eScore.text().replace(" ",""));
                movies.add(movie);
            }else {
                break;
            }
        }
        return movies;
    }

    //爬取入库
    public static void Crawler() {
        String url = "xxxxxx";
        //创建浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //爬取次数
        for (int i = 1; i < 31; i++) {
            //设置url请求
            HttpGet httpGet = new HttpGet(String.format(url, i));
            httpGet.addHeader("user-agent", "Mozilla/5.0");
            String entity = "";

            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
                //请求成功
                if (response.getStatusLine().getStatusCode() == 200) {
                    entity = EntityUtils.toString(response.getEntity(), "utf-8");
                }
                System.out.println(entity);
                Map map = JSON.parseObject(entity, Map.class);
                //获取Json电影列表
                JSONArray jsonArray = ((JSONObject) map.get("data")).getJSONArray("list");
                //遍历列表
                for (int j = 0; j < jsonArray.size(); j++) {
                    String name = (String) jsonArray.getJSONObject(j).get("name");
                    String playUrl = (String) jsonArray.getJSONObject(j).get("playUrl");
                    String imageUrl = (String) jsonArray.getJSONObject(j).get("imageUrl");
                    String score = String.valueOf(jsonArray.getJSONObject(j).get("score"));
                    String mainActor = ((String) jsonArray.getJSONObject(j).get("secondInfo")).substring(3);

                    System.out.println("=================================================");
                    //请求Controller 将数据存储到数据库
                    String requestUrl = "http://localhost:8080/SSM_Crawler_war/movie/add.do";
                    HttpPost httpPost = new HttpPost(requestUrl);
                    Movie movie = new Movie();
                    movie.setName(name);
                    movie.setPlayUrl(playUrl);
                    movie.setImageUrl(imageUrl);
                    movie.setScore(score);
                    movie.setMainActor(mainActor);
                    System.out.println(movie);
                    //转化为JSON
                    JSONObject jsonObject = new JSONObject();
                    String jsonStr = jsonObject.toJSONString(movie);
                    System.out.println("jsonStr= " + jsonStr);
                    StringEntity stringEntity = new StringEntity(jsonStr, "utf-8");
                    stringEntity.setContentEncoding("utf-8");
                    stringEntity.setContentType("application/json");
                    httpPost.setEntity(stringEntity);
                    CloseableHttpResponse response1 = httpClient.execute(httpPost);
                    response1.getEntity().getContent().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       Crawler();
//        Crawler("复仇者联盟3");
    }
}
