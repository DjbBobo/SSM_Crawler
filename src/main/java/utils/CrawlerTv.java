package utils;

import cn.edu.domain.Tv;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class CrawlerTv {
    public static void main(String[] args) {
        Crawler();
    }
    public static void Crawler(){
        //请求url
        String url = "https://pcw-api.iqiyi.com/search/video/videolists?access_play_control_platform=14&channel_id=2&data_type=1&from=pcw_list&is_album_finished=&is_purchase=&key=&market_release_date_level=&mode=24&pageNum=%s&pageSize=48&site=iqiyi&source_type=&three_category_id=&without_qipu=1";
        //创建浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //遍历页数
        for (int i = 1; i < 30; i++) {
            //设置URL请求
            HttpGet httpGet = new HttpGet(String.format(url,i));
            httpGet.addHeader("user-agent", "Mozilla/5.0");
            String entity = "";
            try {
                //执行
                CloseableHttpResponse response = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == 200)
                    entity = EntityUtils.toString(response.getEntity(), "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Json转为Map结构
            Map map = JSON.parseObject(entity,Map.class);
            //获取key=data
            JSONObject data = (JSONObject) map.get("data");
            //获取数组key = list
            JSONArray list = data.getJSONArray("list");
            //遍历电视剧列表list
            for (int j = 0; j < list.size(); j++) {
                //电视剧名
                String name = (String) list.getJSONObject(j).get("name");
                //对应电视剧的详细页面URL(如剧情，讨论等等)
                String playUrl = (String) list.getJSONObject(j).get("playUrl");
                //电视剧的img
                String imageUrl = (String) list.getJSONObject(j).get("imageUrl");
                //获取评分
                String score = String.valueOf(list.getJSONObject(j).get("score"));
                //获取主演
                String mainActor = ((String)list.getJSONObject(j).get("secondInfo")).substring(3);
                //更新至第几集
                String latestOrder = String.valueOf(list.getJSONObject(j).get("latestOrder"));
                //总共几集
                String videoCount = String.valueOf( list.getJSONObject(j).get("videoCount"));

                Tv tv = new Tv();
                tv.setName(name);
                tv.setImageUrl(imageUrl);
                tv.setLatestOrder(latestOrder);
                tv.setVideoCount(videoCount);
                tv.setMainActor(mainActor);
                tv.setPlayUrl(playUrl);
                tv.setScore(score);
                System.out.println(tv);

                //插入TV数据库
                String requestUrl = "http://localhost:8080/SSM_Crawler_war/tv/addTv.do";
                HttpPost httpPost = new HttpPost(requestUrl);
                JSONObject jsonObject = new JSONObject();
                String jsonStr = jsonObject.toJSONString(tv);
                StringEntity stringEntity = new StringEntity(jsonStr,"utf-8");
                stringEntity.setContentEncoding("utf-8");
                stringEntity.setContentType("application/json");
                httpPost.setEntity(stringEntity);
                try {
                    CloseableHttpResponse execute = httpClient.execute(httpPost);
                    execute.getEntity().getContent().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //调用Tvs
                CrawlerTvs.Crawler(playUrl);

                //插入TV数据库



            }

        }
    }
}
