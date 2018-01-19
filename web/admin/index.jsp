<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理</title>
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
<%@ include file="/common/nav_admin.jsp"%>
<div class="container content-main" style="padding-top: 50px;">
    <div class="box" style="margin: 0 auto;padding: 20px;">
        <h2>管理中心</h2>
        <div class="sep10"></div>
        <div class="row">
            <div class="col-4">
                <div class="box-pane">
                    <div class="box-pane-title">
                        用户总数
                    </div>
                    <div class="box-pane-number">
                        38
                    </div>
                    <div class="box-pane-icon"><i class="fa fa-user fa-5x"></i></div>
                </div>
            </div>
            <div class="col-4">
                <div class="box-pane" style="background: linear-gradient(90deg, #E91E63, #C2185B);">
                    <div class="box-pane-title">
                        帖子总数
                    </div>
                    <div class="box-pane-number">
                        20
                    </div>
                    <div class="box-pane-icon"><i class="fa fa-sticky-note fa-5x"></i></div>
                </div>
            </div>
            <div class="col-4">
                <div class="box-pane" style="background: linear-gradient(90deg, #673AB7, #512DA8);">
                    <div class="box-pane-title">
                        版块总数
                    </div>
                    <div class="box-pane-number">
                        5
                    </div>
                    <div class="box-pane-icon"><i class="fa fa-quote-right fa-5x"></i></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
