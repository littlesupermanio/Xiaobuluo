<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
                <h2>注册</h2>
                <div class="sep10"></div>
                <form action="/register.jhtml" method="post" id="register_form">
                    <div class="form-group">
                        <label >用户名</label>
                        <input type="text" class="form-control" name="name" placeholder="请输入您的用户名">
                    </div>
                    <div class="form-group">
                        <label >密码</label>
                        <input type="password" class="form-control" name="password" placeholder="请输入您的密码">
                    </div>
                    <div class="form-group">
                        <label >邮箱</label>
                        <input type="email" id="email" class="form-control" name="email" placeholder="请输入您的邮箱">
                        <div class="invalid-feedback" id="span">
                            Please provide a valid city.
                        </div>

                    </div>
                    <button type="submit" class="btn btn-danger">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#email").keydown(function(){
            var email = $.trim($('#email').val());
            var isEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if(!(isEmail.test(email))){
                $("#span").text( "邮箱格式不正确");
            }else if((isEmail.test(email))){
                $("#span").text( "邮箱格式正确");
            }
        });
    });

    $('#register_form').bind('submit',function () {  //给form标签绑定submit事件
        var i=0;
        this.$("input").each(function(){  //遍历input标签，判断是否有内容未填写
            var vl=$(this).val();
            if(vl==""){
                i=1;
            }
        });
        var t=this.$('textarea').val();  //判断textarea标签是否填写
        if (t=='') {
            i=1;
        }
        if (i==1) {  //如果有未填写的，则return false阻止提交
            alert('请将信息填写完整');
            return false;
        }
    });
</script>
