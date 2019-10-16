<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title dir="rtl">Title</title>
</head>
<style type="text/css">
    body,html{
        width: 100%;
        height: 100%;
    }
</style>
<body style="background-color: black;">
<c:if test="${sort eq 'movie'}">
    <div style="position:absolute; top: 50%;left: 48%;">
        <p style="color: yellow;">选择接口播放</p>
    </div>
</c:if>
<c:if test="${sort eq 'tv'}">
    <div style="position:absolute; top: 50%;left: 48%;">
        <p style="color: yellow;">步骤:1.选择剧集。2.选择播放接口</p>
    </div>
</c:if>

</body>
</html>