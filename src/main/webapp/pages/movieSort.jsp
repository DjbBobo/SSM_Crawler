<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--内容-->
<div class=" nav container">
    <ul>
        <c:forEach items="${pageInfo.list}" var="movie">
            <li>
                <div class="content">
                    <div class="content-img">
                        <a href="${pageContext.request.contextPath}/movie/findById.do?id=${movie.id}" target="_blank">
                            <img src="${movie.imageUrl}" />
                        </a>
                    </div>
                    <div class="title">
                        <p class="main">
                            <a href="#">
                                <span class="movieName">${movie.name}</span>
                                <span class="score">${movie.score}</span>
                            </a>
                        </p>
                        <p class="sub">
                            主演:
                            <a href="#">
                                <span class="actor">${movie.mainActor}</span>
                            </a>
                        </p>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<!--内容-->


<!--分页-->
<div class="container-fluid page" style="text-align: center">
    <nav aria-label="Page">
        <ul class="pagination pagination-lg">
            <li>
                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=1&size=${pageInfo.pageSize}"
                   aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:if test="${pageInfo.pages <= 10}">
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                    <c:if test="${pageInfo.pageNum == pageNum}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != pageNum}">
                        <li>
                            <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${pageInfo.pages > 10}">
                <c:if test="${pageInfo.pageNum < 6}">
                    <c:forEach begin="1" end="6" var="pageNum">
                        <c:if test="${pageInfo.pageNum == pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != pageNum}">
                            <li>
                                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li><a href="#">...</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNum > pageInfo.pages-3}">
                    <li><a href="#">...</a></li>
                    <c:forEach begin="${pageInfo.pages-3}" end="${pageInfo.pages}" var="pageNum">
                        <c:if test="${pageInfo.pageNum == pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != pageNum}">
                            <li>
                                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${pageInfo.pageNum >= 6 && pageInfo.pageNum <= pageInfo.pages-3}">
                    <li><a href="#">...</a></li>
                    <c:forEach begin="${pageInfo.pageNum-1}" end="${pageInfo.pageNum+1}" var="pageNum">
                        <c:if test="${pageInfo.pageNum == pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != pageNum}">
                            <li>
                                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <li><a href="#">...</a></li>
                </c:if>

            </c:if>


            <li>
                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/movie/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                   aria-label="Next">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<!--分页-->