<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/14
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主界面</title>
    <style>
        *{
            background-color: #f8fafb;
        }
        /**{*/
        /*    background-image: url("img/a.png");*/
        /*}*/
        /*导航的框架*/
        #rightNavigation{
            width: 210px;
            height: 430px;
            border: #f8fafb 3px solid;
            margin-top: 100px;
            margin-left: 40px;
        }

        /*导航上的按钮*/
        #a,#b,#c,#d,#e,#f,#g{
            width: 150px;
            height: 35px;
            border: #8b8989 1px solid;
            border-radius: 2px;
            margin-top: 20px;
            margin-left: 30px;
            /*设置字体*/
            padding-left: 30px;
            padding-top: 5px;
            background-color: #f8fafb;

        }
        #BigFrame{
            /*绝对布局*/
            position: absolute;
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%--大框架--%>
<div id="BigFrame" style="background-color: #f8fafb">
    <%--rightNavigation（导航）--%>
    <div id="rightNavigation" style="background-color: #f8fafb">
        <%--导航上的按钮，添加动作监听--%>
        <button id="a" onclick="goHead()">回到首页</button>
        <button id="b" onclick="goBookManage()">图书管理</button>
       <%-- <button id="c" onclick="goBookAdd()">增加图书</button>--%>
       <%-- <button id="e" onclick="goLendRecode2()">借阅记录</button>
        <button id="f" onclick="goUserShow()">用户管理</button>
        <button id="d" onclick="goInfo()">动态消息</button>
        <button id="g" onclick="ret()">退出系统</button>--%>


    </div>


    <script>
        /*动作监听事件*/
        function goInfo() {
            window.location.href = "fileServlet?action=toinfo&admid=${user.getUid()}";
        }


        function goUserShow() {
            window.location.href = "fileServlet?action=goUserShow&admid="+${user.getUid()};
        }

        function goBookManage() {
            window.location.href = "fileServlet?action=goBookManage&admid="+${user.getUid()};
        }
        function goHead() {
            window.location.href = "fileServlet?action=goHead&admid="+${user.getUid()};
        }
        function goBookAdd() {
            window.location.href = "fileServlet?action=goBookAdd&admid="+${user.getUid()};
        }

        function goLendRecode2(){
            window.location.href = "fileServlet?action=goLendRecode2&admid="+${user.getUid()};
        }

        function ret() {
            window.location.href = "fileServlet?action=goLogin"
        }


    </script>



</div>

<%--包含的网页，page=要包含的网页（如果等空就是show.jsp）--%>
<jsp:include page="${mainRight==null? 'show.jsp':mainRight}"></jsp:include>
</body>
</html>
