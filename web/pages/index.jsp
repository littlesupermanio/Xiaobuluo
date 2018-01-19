<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>论坛首页</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/styles.css" rel="stylesheet"/>
    <link href="../css/font-awesome.min.css" rel="stylesheet"/>
</head>
<body>

<%@ include file="/common/nav.jsp"%>

<div class="container content-main" style="padding: 0 20px;">
    <div class="row">
        <div class="col-9">
            <div class="box">
                <div class="inner-box">
                    <c:forEach items="${main_sections}" var="section">
                        <c:choose>
                            <c:when test="${ param.sectionId == section.id }">
                                <a href="/section.jhtml?sectionId=${section.id}" class="tab-active">${section.name}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/section.jhtml?sectionId=${section.id}" class="tab">${section.name}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${requestScope['javax.servlet.forward.request_uri'].equals('/index.jhtml')}">
                        <h1 class="text-primary" style="margin-left: 10px;">最新文章</h1>
                    </c:if>
                </div>
                <c:forEach items="${main_sections}" var="section">
                    <c:if test="${section.subSections!=null&&param.sectionId == section.id}">
                        <div class="cell" style="background-color: #f9f9f9; padding: 10px 10px 10px 20px;">
                            <c:forEach items="${section.subSections}" var="subSection">
                                <a href="/section.jhtml?sectionId=${subSection.id}" class="tab-vice">${subSection.name}</a>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:forEach>
                <c:forEach items="${posts}" var="post">
                    <div class="post-cell item">
                        <img src="//v2ex.assets.uxengine.net/gravatar/96138df0c0df1532649982ae69c38c89?s=48&amp;d=retro" class="avatar" border="0" align="default">
                        <div class="post-cell-content">
                            <h6>
                                <a href="/post.jhtml?type=showPost&id=${post.id}">${post.title}</a>
                            </h6>
                            <p class="post-cell-about">
                                <a class="topic_tag" href="/section.jhtml?sectionId=${post.section.id}">${post.section.name}</a>
                                • 													<a href="#">${post.user.name} </a><span class="text-color-999">发表了主题 • ${post.time_interval}前				</span>
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="sep20"></div>
        </div>
        <div class="col-3">
            <%@ include file="/common/sidebar.jsp"%>
        </div>
    </div>
</div>
</body>


<script src="../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="../js/bootstrap.min.js"></script>

</html>
