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
    function selectOnChange(obj) {
        var text = obj.innerText;
        var btn = document.getElementById("dropdownMenu2");
        $(btn).text(text);
    }
</script>
<body>
        <%--播放器以及接口--%>
        <jsp:include page="playTemplate.jsp"></jsp:include>
        <%--播放器以及接口--%>

</body>
</html>
