<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
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

<div class="container content-main" style="padding: 100px 20px;">
    <div class="box" style="width: 70%; margin: 0 auto;padding: 20px;">
        <div class="row">
            <div class="col-6" style="margin: 0 auto;">
                <h2>登录</h2>
                <div class="sep10"></div>
                <form action="/login.jhtml" method="post">
                    <div class="form-group">
                        <label >用户名</label>
                        <input type="text" class="form-control" name="name"  placeholder="请输入您的用户名">
                    </div>
                    <div class="form-group">
                        <label >密码</label>
                        <input type="password" class="form-control" name="password"  placeholder="请输入您的密码">
                    </div>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" style="margin-left: 0">
                        <label class="form-check-label">记住用户名</label>
                    </div>
                    <button type="submit" class="btn btn-primary">登录</button>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
