<%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/9
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="resources/js/jquery.js"></script>
    <script src="resources/js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(resources/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <%
        //声明java代码块进行错误提示语逻辑校验
        HttpSession hs=request.getSession();
        Object obj=hs.getAttribute("flag");
        if(obj!=null){
    %>

    <div style="text-align: center">
        <span style="font-size: 15px;color: white;font-weight: bold;">用户名密码错误</span>
    </div>
    <% }%>

    <div class="loginbox loginbox1">
        <form action="/manager/servlet/UserServlet" method="post">
            <input type="hidden" value="login" name="oper">
            <ul>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser"  /></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
            </ul>

        </form>


    </div>

</div>


<div class="loginbm">借用模板  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途，交流QQ：1021612716</div>


</body>

</html>
