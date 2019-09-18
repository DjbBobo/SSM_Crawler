<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="referrer" content="no-referrer" />
    <title>仅供学习测试,暂不支持手机播放</title>
    <link type="text/css" rel="stylesheet" href="../css/index.css">
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?ac11ed16666e46805f44a35516c8f14a";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

</head>
<body>
<div style="height: 20px;"></div>
<form action="${pageContext.request.contextPath}/movie/search.do" method="post">
    <div class="row">
        <div class="col-lg-8"></div>
        <div class="col-lg-3">
            <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." name="movieName">
                    <span class="input-group-btn">
                        <button class="btn btn-info" type="submit">Go!</button>
                    </span>
            </div><!-- /input-group -->
        </div>
    </div>
</form>

<div style="height: 20px;"></div>
<form action="${pageContext.request.contextPath}/movie/searchCrawler.do" method="post">
    <div class="row">
        <div class="col-lg-8"></div>
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="抓取全网，搜索内容需绝对匹配" name="movieName">
                <span class="input-group-btn">
                        <button class="btn btn-warning" type="submit">Go!</button>
                    </span>
            </div><!-- /input-group -->
        </div>
    </div>
</form>
<hr/>
<div id="content" class="container">
    <c:forEach items="${movies}" var="movie">
        <div class="movie-content">
            <div class="movie-img">
                <a  href="#" onclick="forward('${movie.playUrl}')">
                    <img src="${movie.imageUrl}" style="width: 180px;height: 180px;">
                </a>
            </div>
            <div class="movie-name" style="position:relative;">
                ${movie.name}
            </div>
            <div class="moive-score" style="position:relative;">
                评分:${movie.score}
            </div>
        </div>
    </c:forEach>

</div>
</body>
<script>
    function forward(playUrl) {
        window.location.href = '${pageContext.request.contextPath}/movie/setAttr.do?playUrl='+playUrl;
    }
</script>
</html>
