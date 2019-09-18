# SSM_Crawler
SSM框架练习。功能：爬取爱奇艺电影入库以及实时爬取爱奇艺电影并展示到页面。<br/>
页面使用的是Bootstrap框架。
### 爬虫使用说明：
1. utils包下的CrawlerMovie<br/>
<pre>     Crawler():
             解析爱奇艺返回的Json数据，获取相关的电影信息并存储进mysql数据库。
     List<Movie> Crawler(String name):
             使用Jsoup请求爱奇艺电影链接，select出对应的电影信息。通过带有“评分”
           标签来判断搜索结果是否为电影（网页代码自行分析）。
          
</pre>
  
