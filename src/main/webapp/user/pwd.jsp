<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/11
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
    <!--引入jquery文件-->
    <script language="JavaScript" src="../resources/js/jquery.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="" method="get">
        <ul class="forminfo">
            <li><label>新密码</label><input name="newpwd" id="newpwd" type="text" class="dfinput" /><i>请输入原始密码</i></li>
            <li><label>确认密码</label><input name="" id="cofpwd" type="text" class="dfinput" /><i>请输入新密码</i></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存"/></li>
        </ul>
    </form>


</div>


</body>

</html>

