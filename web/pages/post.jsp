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
                <div class="post-header">
                    <div class="float-right"><a href="/member/zjsxwc"><img
                            src="//v2ex.assets.uxengine.net/avatar/d9d0/91e2/46437_large.png?m=1500725463"
                            class="avatar" border="0" align="default"></a></div>
                    <%--<a href="/">V2EX</a> <span class="chevron">&nbsp;›&nbsp;</span> <a href="/go/programmer">程序员</a>--%>
                    <div class="sep10"></div>
                    <h1>${post.title}</h1>
                    <small class="gray"><a href="/member/zjsxwc">${post.user.name}</a> · ${post.time_interval}前&nbsp;</small>
                </div>
                <div class="cell">
                    <div class="topic_content">
                        <div class="markdown_body">
                            ${post.body}
                        </div>
                    </div>
                </div>
                <div class="cell bg-light" style="padding: 5px;">
                    <div class="text-right text-dark">
                        <a href="/post.jhtml?type=deletePost&id=${post.id}">编辑</a>&nbsp;&nbsp;
                        <a href="/post.jhtml?type=deletePost&id=${post.id}">删除</a>
                    </div>
                </div>
            </div>
            <div class="sep20"></div>
            <div class="box">
                <c:forEach items="${post.comments}" var="comment">
                    <div class="cell">
                        <div class="reply-cell">
                            <div class="avatar">
                                <img src="//v2ex.assets.uxengine.net/gravatar/d99fb9ac42d23b2f3567a945c7576c08?s=48&amp;d=retro" class="avatar" border="0" align="default">
                            </div>
                            <strong><a href="/member/neoblackcap" class="dark replyer-name">${comment.user.name}</a></strong>
                            <span class="ago">${comment.time_interval}前</span>
                            <div class="sep5"></div>
                            <div class="reply-content">
                                ${comment.body}
                            </div>
                            <div class="text-right text-dark">
                                <a href="/post.jhtml?type=deletePost&id=${comment.id}">删除</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="sep20"></div>
            <div class="box" style="padding: 10px;">
                <form action="/comment.jhtml?type=submitComment&postId=${post.id}" method="post">
                    <h4>添加新评论</h4>
                    <div class="form-group">

                        <textarea class="form-control" placeholder="请在这里输入评论的内容" rows="3" name="comment_body"></textarea>
                    </div>
                    <button type="submit" class="btn btn-info"><i class="fa fa-commenting-o"></i>&nbsp;&nbsp;评论</button>
                </form>
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
