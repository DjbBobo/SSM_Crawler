<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>

    <link href="../css/tvplay.css" rel="stylesheet"/>
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
    <%--播放器和接口--%>
    <jsp:include page="playTemplate.jsp"></jsp:include>
    <%--播放器和接口--%>

    <%--内容--%>
    <hr/>
    <div class="content-header container">
        <span>${name}</span>
    </div>
    <div class="content container">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:forEach items="${urlList}" var="url" varStatus="num">
                    <li <c:if test="${playUrl eq url}">class="active" </c:if>>
                        <a href="${pageContext.request.contextPath}/tv/addToSession.do?url=${url}">${num.count}</a>
                    </li>
                </c:forEach>

            </ul>
        </nav>
    </div>
    <%--内容--%>
</body>
</html>
