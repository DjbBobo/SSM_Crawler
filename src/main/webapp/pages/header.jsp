<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--导航栏-->
<div class="nav-div container-fluid">
    <ul class="nav nav-pills">
        <li role="presentation" <c:if test="${sort eq 'movie'}">class="active" </c:if>>
            <a href="${pageContext.request.contextPath}/movie/findAll.do">电影</a>
        </li>
        <li role="presentation" <c:if test="${sort eq 'tv'}">class="active" </c:if>>
            <a href="${pageContext.request.contextPath}/tv/findAll.do">电视剧</a>
        </li>
        <li role="presentation">
            <a href="#">Messages</a>
        </li>
        <li role="presentation">
            <a href="#">Messages</a>
        </li>
        <!--搜索框-->
        <li role="presentation" class=" search-input">
            <form action="${pageContext.request.contextPath}/${sort}/search.do" method="post">
                <div class="row">
                    <div class="col-lg-8"></div>
                    <div class="col-lg-3">
                        <div style="height: 2px;"></div>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for..." name="name">
                            <span class="input-group-btn">
                            <button class="btn btn-info" type="submit">Go!</button>
                        </span>
                        </div>
                        <!-- /input-group -->
                    </div>
                </div>
            </form>
        </li>
    </ul>
</div>
<!--导航栏-->
