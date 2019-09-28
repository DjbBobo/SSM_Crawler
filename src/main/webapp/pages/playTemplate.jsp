<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--播放器-->
<div class="container" style="height: 700px;">
    <c:if test="${parseUrl eq null}">
        <iframe src="${pageContext.request.contextPath}/pages/warm.html" frameborder="0" allowfullscreen="true" width="100%" height="100%"></iframe>
    </c:if>
    <c:if test="${not empty parseUrl}">
        <iframe src="${parseUrl.url}${playUrl}" frameborder="0" allowfullscreen="true" width="100%"
                height="100%"></iframe>
    </c:if>
</div>
<!--播放器-->

<!--解析接口-->
<div class="dropup container">
    <button class="btn btn-default dropdown-toggle pull-right" type="button" id="dropdownMenu2" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        ${parseUrl eq null?"选择播放接口":parseUrl.name}
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu pull-right" aria-labelledby="dropdownMenu2">
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=1&sort=${sort}" onclick="selectOnChange(this)">①号通用vip引擎系统【稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=2&sort=${sort}" onclick="selectOnChange(this)">②号通用vip引擎系统【稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=3&sort=${sort}" onclick="selectOnChange(this)">③号通用vip引擎系统【稳定通用】</a>
        </li>
        <li role="separator" class="divider"></li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=4&sort=${sort}" onclick="selectOnChange(this)">④号通用vip引擎系统【超级稳定通用】</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/parse/findById.do?id=5&sort=${sort}" onclick="selectOnChange(this)">⑤号通用vip引擎系统【稳定通用】</a>
        </li>
    </ul>
</div>
<!--解析接口-->