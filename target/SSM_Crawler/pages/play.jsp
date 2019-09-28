<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>仅供学习测试,暂不支持手机播放</title>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
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
<script>
    function selectOnChange(obj) {
        var text = obj.innerText;
        var btn = document.getElementById("dropdownMenu2");
        $(btn).text(text);
    }
</script>
<body>
<div class="container" style="height: 700px;">
    <c:if test="${parseUrl eq null}">
        <iframe src="${pageContext.request.contextPath}/pages/warm.html" frameborder="0" allowfullscreen="true" width="100%" height="100%"></iframe>
    </c:if>
    <c:if test="${not empty parseUrl}">
        <iframe src="${parseUrl.url}${playUrl}" frameborder="0" allowfullscreen="true" width="100%"
                height="100%"></iframe>
    </c:if>
</div>
<div class="dropup container">
    <button class="btn btn-default dropdown-toggle pull-right" type="button" id="dropdownMenu2" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        ${parseUrl eq null?"选择播放接口":parseUrl.name}
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu pull-right" aria-labelledby="dropdownMenu2">
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=1" onclick="selectOnChange(this)">①号通用vip引擎系统【稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=2" onclick="selectOnChange(this)">②号通用vip引擎系统【稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=3" onclick="selectOnChange(this)">③号通用vip引擎系统【稳定通用】</a>
        </li>
        <li role="separator" class="divider"></li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=4" onclick="selectOnChange(this)">④号通用vip引擎系统【超级稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=5" onclick="selectOnChange(this)">⑤号通用vip引擎系统【稳定通用】</a>
        </li>
    </ul>
</div>
</body>
</html>
