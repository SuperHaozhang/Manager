<%@ page import="com.cheer.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 10216
  Date: 2019/6/10
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../resources/js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })

            //退出功能
            $("#out").click(function () {
                var flag=window.confirm("你真的要退出吗？");
                //alert(flag);
                if(flag){
                    window.top.location.href="/manager/servlet/UserServlet?oper=out";
                }
            })
        })

    </script>


</head>

<body style="background:url(../resources/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.jsp" target="_parent"><img src="../resources/images/logo.png" title="系统首页" /></a>
</div>


<div class="topright">
    <ul>
        <li><a href="javascript:void (0)" id="out">退出</a></li>
    </ul>

    <div class="user">
        <span><%=((User)session.getAttribute("user")).getUname()%></span>
    </div>

</div>

</body>
</html>
