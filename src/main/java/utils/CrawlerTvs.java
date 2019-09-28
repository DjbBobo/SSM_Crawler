package utils;

import cn.edu.domain.Tv;
import cn.edu.domain.Tvs;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerTvs {
    public static void main(String[] args) {
        Crawler("https://www.iqiyi.com/a_19rrhzyl2l.html");
    }



    //爬取入库
    public static void Crawler(String url){
        //将playUrl请求页面，获取每集的url
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //1.获取每一集的a标签
        Elements lis = doc.select("li[data-albumlist-elem=playItem]");
        for (int k = 0; k < lis.size(); k++) {
            //2.获取a标签的播放地址
            String playUrl = lis.get(k).select("div.site-piclist_pic").select("a.site-piclist_pic_link").attr("href");

            //3.存储进Tvs表
            //创建Tvs对象
            Tvs tvs = new Tvs();
            tvs.setPlayUrl(playUrl);
            //获取Tv的id
            String requestUrl = "http://localhost:8080/SSM_Crawler_war/tv/addTvs.do";
            HttpPost httpPost = new HttpPost(requestUrl);
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("url",url);
                jsonObject.put("playUrl",playUrl);
                StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
                stringEntity.setContentEncoding("utf-8");
                stringEntity.setContentType("application/json");
                httpPost.setEntity(stringEntity);
                HttpClient httpClient = HttpClients.createDefault();
                HttpResponse res = httpClient.execute(httpPost);
                res.getEntity().getContent().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
