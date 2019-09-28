<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--图片防盗措施--%>
    <meta name="referrer" content="no-referrer"/>
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <link href="../css/nav.css" rel="stylesheet" />
    <link href="../css/videolist.css" rel="stylesheet" />
</head>
<body>
    <!--页面头部-->
    <jsp:include page="header.jsp"></jsp:include>
    <!--页面头部-->

    <!--撑开部分-->
    <jsp:include page="block.jsp"></jsp:include>
    <!--撑开部分-->

    <!--内容-->
    <c:if test="${sort eq 'tv'}">
        <jsp:include page="tvSort.jsp"></jsp:include>
    </c:if>
    <c:if test="${sort eq 'movie'}">
        <jsp:include page="movieSort.jsp"></jsp:include>
    </c:if>
    <!--内容-->


</body>
</html>
