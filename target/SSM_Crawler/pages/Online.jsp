<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<script>
    $(function () {
       var info =  ${success};
       if (info != "")
           alert(info)
    });
</script>
<style type="text/css">
    button a{
        text-decoration: none;
        color: white;
    }
</style>
<body>
<button id="movie" type="button" class="btn btn-primary"><a href="${pageContext.request.contextPath}/movie/addNewMovie.do">更新电影</a></button>

<button id="tv" type="button" class="btn btn-info"><a href="${pageContext.request.contextPath}/tv/addNewTv.do">更新电视剧</a></button>
</body>
</html>
