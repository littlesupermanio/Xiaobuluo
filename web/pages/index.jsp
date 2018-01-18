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
</head>
<body>

<%@ include file="/common/nav.jsp"%>

<div class="container content-main" style="padding: 0 20px;">
    <div class="row">
        <div class="col-9">
            <div class="box">
                <div class="inner-box">
                    <a href="/?tab=tech" class="tab-active">校园生活</a>
                    <a href="/?tab=tech" class="tab">职场先锋</a>
                    <a href="/?tab=tech" class="tab">商务综合</a>
                    <a href="/?tab=tech" class="tab">音乐专区</a>
                    <a href="/?tab=tech" class="tab">陈独秀同志请你坐下</a>
                </div>
                <div class="cell" style="background-color: #f9f9f9; padding: 10px 10px 10px 20px;">
                    <a href="/go/programmer" class="tab-vice">程序员</a>
                    <a href="/go/python" class="tab-vice">Python</a>
                    <a href="/go/idev" class="tab-vice">iDev</a>
                    <a href="/go/android" class="tab-vice">Android</a>
                    <a href="/go/linux" class="tab-vice">Linux</a>
                    <a href="/go/nodejs" class="tab-vice">node.js</a>
                    <a href="/go/cloud" class="tab-vice">云计算</a>
                    <a href="/go/bb" class="tab-vice">宽带症候群</a>
                </div>
                <c:forEach items="${posts}" var="post">
                    <div class="post-cell item">
                        <img src="//v2ex.assets.uxengine.net/gravatar/96138df0c0df1532649982ae69c38c89?s=48&amp;d=retro" class="avatar" border="0" align="default">
                        <div class="post-cell-content">
                            <h6>
                                <a href="/post.jhtml?type=showPost&id=${post.id}">${post.title}</a>
                            </h6>
                            <p class="post-cell-about">
                                <a class="topic_tag" href="#">程序</a>
                                • 													<a href="http://wenda.wecenter.com/people/kuaiweb" class="aw-user-name">快网 </a>				<span class="text-color-999">发起了问题 • 1 人关注 • 0 个回复 • 20 次浏览 • 4 小时前				</span>
                                <span class="text-color-999 related-topic collapse"> • 来自相关话题</span>
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
