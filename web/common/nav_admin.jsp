<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand float-right" href="#">小部落</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">用户管理</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">版块管理</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">返回至小部落&nbsp;<i class="fa fa-mail-reply"></i></a>
                </li>
            </ul>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <c:choose>
                    <c:when test="${empty user}">

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath }/pages/login.jsp">登录</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath }/pages/register.jsp">注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${not empty user.name }">
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath }/pages/login.jsp">${user.name}</a>
                                </li>
                            </c:when>
                        </c:choose>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout.jhtml">注销</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

</nav>