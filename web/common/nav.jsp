<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand float-right" href="#">小部落</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath }/post.jhtml?type=showAllPosts">首页</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">话题</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">用户中心</a>
                </li>

            <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${empty user}">

                    <li class="nav-item active">
                        <a href="${pageContext.request.contextPath }/pages/login.jsp">请登录</a>
                    </li>
                    <li class="nav-item active">
                        <a
                                href="${pageContext.request.contextPath }/register.jhtml">免费注册</a>
                    </li>
                </c:when>
                <c:otherwise>
                <c:choose>
                    <c:when test="${not empty user.name }">${user.name}</c:when>
                </c:choose>
                    <a href="${pageContext.request.contextPath }/<%=response.encodeURL("logout.jhtml")%>">注销</a>
                </c:otherwise>
            </c:choose>
            </ul>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>
    </div>
</nav>
