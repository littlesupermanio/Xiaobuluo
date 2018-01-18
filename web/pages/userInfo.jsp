<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改主题</title>
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
            <div class="box" style="padding: 20px;">
                <form action="#" method="post" id="editpost_form">
                    <h1 style="font-weight: bold">用户中心</h1></br>
                    <div class="form-group">
                        <label>姓名:</label>
                        <td>gh</td>
                    </div>
                    <div class="form-group">
                        <label>密码:</label>
                        <td>gh</td>
                    </div>
                    <div class="form-group">
                        <label>电话:</label>
                        <td>gh</td>
                    </div>
                    <div class="form-group">
                        <label>email:</label>
                        <td>gh</td>
                    </div>
                    <div class="form-group">
                        <label>注册时间:</label>
                        <td>gh</td>
                    </div>
                    <button type="submit" class="btn btn-success"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;修改</button>


                </form>
            </div>
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
