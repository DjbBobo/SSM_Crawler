# SSM_Crawler
SSM框架练习。功能：爬取爱奇艺电影入库以及实时爬取爱奇艺电影并展示到页面。<br/>
页面使用的是Bootstrap框架。
### 效果图
![image](https://github.com/DjbBobo/SSM_Crawler/blob/master/1.jpg)
![image](https://github.com/DjbBobo/SSM_Crawler/blob/master/2.jpg)
![image](https://github.com/DjbBobo/SSM_Crawler/blob/master/3.jpg)
### 爬虫使用说明：
1. utils包下的CrawlerMovie<br/>
<pre>     Crawler():
             解析爱奇艺返回的Json数据，获取相关的电影信息并存储进mysql数据库。
     List<Movie> Crawler(String name):
             使用Jsoup请求爱奇艺电影链接，select出对应的电影信息。通过带有“评分”
           标签来判断搜索结果是否为电影（网页代码自行分析）。
          
</pre>
### MySql表创建说明
使用的数据库名为movie<br/>
有两个表：movie、parseurl，分别存储电影信息以及解析接口url<br/>
