<%@ page import="com.xiaobuluo.dao.SectionDao" %>
<%@ page import="com.xiaobuluo.dao.jdbc.SectionDaoImpl" %>
<%@ page import="com.xiaobuluo.entity.Section" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xiaobuluo.globe.Constants" %>
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
    <h2>版块管理</h2>
    <div class="sep20"></div>
    <div class="box" style="padding: 20px;">
        <form action="/section.jhtml?type=<%= Constants.ADMIN_SECTION_ADD%>" method="post" id="editpost_form">
            <h1>创建新版块</h1>
            <div class="form-group">
                <label>版块名称</label>
                <input type="text" class="form-control" placeholder="请在这里输入你的板块名称" name="name">
                <small class="form-text text-muted">版块名称必须能让人了解该版块所讨论的主题</small>
            </div>
            <div class="form-group">
                <label style="line-height: 5px;">选择该板块的父板块</label>
                <select class="custom-select custom-select-lg mb-3" name="parent_id">
                    <%
                        SectionDao sectionDao = new SectionDaoImpl();
                        List<Section> allSections = sectionDao.getMainSections();
                        request.setAttribute("allSections", allSections);
                    %>
                    <option selected value="null">父版块</option>
                    <c:forEach items="${allSections}" var="section">
                        <option value="${section.id}">${section.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success cursor-pointer" onclick="window.location.href = '/section.jhtml?type=<%= Constants.ADMIN_SECTION_ADD %>'"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;创建新版块</button>
        </form>
    </div>
</div>
</body>
</html>
