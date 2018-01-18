<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示信息</title>
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

<div class="container content-main" style="padding: 100px 20px;">
    <div class="box" style="width: 80%; margin: 0 auto;padding: 20px;">
        <h2 class="text-center"><i class="fa fa-${message.icon} fa-4x text-${message.type}"></i></h2>
        <div class="sep20"></div>
        <h4 class="text-center">${message.content}！</h4>
        <div class="sep10"></div>
        <h6 class="text-dark text-center"><span id="jumpTo">5</span>秒后跳转至<a href="${message.jumpUrl}">网页</a></h6>
    </div>
</div>
<script type="text/javascript">
    function countDown(secs,surl){
        //alert(surl);
        var jumpTo = document.getElementById('jumpTo');
        jumpTo.innerHTML=secs;
        if(--secs>0){
            setTimeout("countDown("+secs+",'"+surl+"')",1000);
        }
        else
        {
            location.href=surl;
        }
    }
</script>
<script type="text/javascript">
    countDown(5,'${message.jumpUrl}');
</script>
</body>
</html>
