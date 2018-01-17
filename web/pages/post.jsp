<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="col-md-3">
        <a class="navbar-brand float-right" href="#">小部落</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="col-md-9">
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">话题</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">用户中心</a>
                </li>
            </ul>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>
    </div>
</nav>

<div class="container content-main" style="padding: 0 20px;">
    <div class="row">
        <div class="col-9">
            <div class="box">
                <div class="post-header">
                    <div class="float-right"><a href="/member/zjsxwc"><img
                            src="//v2ex.assets.uxengine.net/avatar/d9d0/91e2/46437_large.png?m=1500725463"
                            class="avatar" border="0" align="default"></a></div>
                    <a href="/">V2EX</a> <span class="chevron">&nbsp;›&nbsp;</span> <a href="/go/programmer">程序员</a>
                    <div class="sep10"></div>
                    <h1>C 语言为什么没有发展出类似依赖管理的框架？</h1>
                    <small class="gray"><a href="/member/zjsxwc">zjsxwc</a> · 1 小时 57 分钟前 · 1043 次点击 &nbsp;</small>
                </div>
                <div class="cell">
                    <div class="topic_content">
                        <div class="markdown_body">
                            <p>就算浏览器上 es5 这种没有依赖注入容器，但也有 requirejs 这种管理依赖的东西，</p>
                            <p>C 语言是怎么管理代码执行时依赖关系？</p>
                            <p>这里我指的不是 makefile 这种只能算是文件层面的依赖管理。</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sep20"></div>
            <div class="box">
                <div class="cell">
                    <div class="reply-cell">
                        <div class="avatar">
                            <img src="//v2ex.assets.uxengine.net/gravatar/d99fb9ac42d23b2f3567a945c7576c08?s=48&amp;d=retro" class="avatar" border="0" align="default">
                        </div>
                        <strong><a href="/member/neoblackcap" class="dark replyer-name">neoblackcap</a></strong>
                        <span class="ago">1 小时 55 分钟前</span>
                        <div class="sep5"></div>
                        <div class="reply-content">
                            asdfasdf <br>
                            asdf
                        </div>
                    </div>
                </div>
                <div class="cell">
                    <div class="reply-cell">
                        <div class="avatar">
                            <img src="//v2ex.assets.uxengine.net/gravatar/d99fb9ac42d23b2f3567a945c7576c08?s=48&amp;d=retro" class="avatar" border="0" align="default">
                        </div>
                        <strong><a href="/member/neoblackcap" class="dark replyer-name">neoblackcap</a></strong>
                        <div class="reply-content">
                            asdfasdf <br>
                            asdf
                        </div>
                    </div>
                </div>
                <div class="cell">
                    <div class="reply-cell">
                        <div class="avatar">
                            <img src="//v2ex.assets.uxengine.net/gravatar/d99fb9ac42d23b2f3567a945c7576c08?s=48&amp;d=retro" class="avatar" border="0" align="default">
                        </div>
                        <strong><a href="/member/neoblackcap" class="dark replyer-name">neoblackcap</a></strong>
                        <div class="reply-content">
                            asdfasdf <br>
                            asdf
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="head col-3">

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
