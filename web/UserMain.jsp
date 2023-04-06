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
            background-color: lightblue;
        }

        #rightNavigation{
            width: 210px;
            height: 430px;
            border: #000000 3px solid;
            margin-top: 100px;
            margin-left: 40px;
        }

        #a,#b,#c,#d,#e,#f,#g{
            width: 150px;
            height: 35px;
            border:  1px solid;
            background-color: #f8fafb;
            border-radius: 2px;
            border-radius: 2px;
            margin-top: 20px;
            margin-left: 30px;
            padding-left: 30px;
            padding-top: 5px;



        }
        #BigFrame{
            position: absolute;
        }


    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="BigFrame">
    <div id="rightNavigation">
        <button id="a" onclick="goHead()">回到首页</button>
        <button id="b" onclick="goBookManage()">图书浏览</button>
        <button id="c" onclick="goUserLendRecode()">我的借书</button>
        <button id="f" onclick="goMyFile()">我的信息</button>
        <button id="d" onclick="goInfo()">动态信息</button>
        <button id="g" onclick="ret()">退出系统</button>


    </div>




    <script>
        function goInfo() {
            window.location.href = "ufiledeal?action=toInfo&myid=${user.getUid()}";
        }

        function ret() {
            window.location.href = "fileServlet?action=goLogin"
        }

        function goUserLendRecode() {
            window.location.href = "ufiledeal?action=goUserLendRecode&myid="+${user.getUid()};
        }

        function goBookManage() {
            window.location.href = "ufiledeal?action=gouserBookLook&myid=${user.getUid()}";
        }
        function goHead() {
            window.location.href = "ufiledeal?action=goHead&myid="+${user.getUid()};
        }
        function goMyFile() {
            window.location.href = "ufiledeal?action=goMyFile&myid="+${user.getUid()};
        }


    </script>



</div>


<jsp:include page="${mainRight==null? 'show.jsp':mainRight}"></jsp:include>
</body>
</html>
