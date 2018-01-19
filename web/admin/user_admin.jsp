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
    <h2>用户管理</h2>
    <div class="sep20"></div>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">用户名</th>
            <th scope="col">用户邮箱</th>
            <th scope="col">用户发帖数量</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.posts_count}</td>
                <td>
                    <button type="button" class="btn btn-outline-warning btn-sm cursor-pointer">编辑</button>
                    <button type="button" class="btn btn-outline-danger btn-sm cursor-pointer" onclick="window.location.href = '/user.jhtml?type=deleteUserAdmin&id='+${user.id}">删除</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
