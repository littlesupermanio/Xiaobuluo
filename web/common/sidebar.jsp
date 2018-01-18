<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="head">
    <img src="../storage/avatar/avatar.png" alt="" class="avatar">
    <h4 class="text-center" >${user.name}</h4>
    <div class="sep20"></div>
    <button type="button" class="btn btn-primary btn-block" style="width: 80%;margin:0 auto;"><i class="fa fa-user-circle" aria-hidden="true"></i>&nbsp;&nbsp;用户中心</button>
    <button type="button" class="btn btn-success btn-block"  onclick="window.location.href = '/post.jhtml?type=newPost' " style="cursor: pointer;width: 80%;margin:10px auto;">创建新的主题</button>

</div>
