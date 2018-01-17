<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新的主题</title>
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
            <div class="box" style="padding: 20px;">
                <form action="/post.jhtml" method="post">
                    <h1>创建新主题</h1>
                    <div class="form-group">
                        <label>标题</label>
                        <input type="text" class="form-control" placeholder="请在这里输入你的标题" name="title">
                        <small class="form-text text-muted">您的标题必须能够展示文章的主题</small>
                    </div>
                    <div class="form-group">
                        <label>内容</label>
                        <textarea class="form-control" placeholder="请在这里输入文章的内容" rows="10" name="body"></textarea>
                    </div>
                    <div class="form-group">
                        <label style="line-height: 5px;">选择您要发表的板块</label>
                        <select class="custom-select custom-select-lg mb-3">
                            <option selected>Open this select menu</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-success"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;创建新的主题</button>
                </form>
            </div>
        </div>
        <div class="col-3">
            <div class="head">
                <img src="../storage/avatar/avatar.png" alt="" class="avatar">
                <h4 class="text-center" >小超人</h4>
                <div class="sep20"></div>
                <p class="last-login">上次登陆时间：2018年1月17日21:31:09</p>
                <button type="button" class="btn btn-primary btn-block" style="width: 80%;margin:0 auto;"><i class="fa fa-user-circle" aria-hidden="true"></i>&nbsp;&nbsp;用户中心</button>

            </div>
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
