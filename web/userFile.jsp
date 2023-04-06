<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/14
  Time: 23:02
  To change this template use File | Settings | File Templates.
  图书管理员的用户管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <style>
        /*导航栏绘制*/
        #search{
            width: 1224px;
            height: 100px;
            border: #000000 1px solid;
            /*浮动*/
            position: absolute;
        }
        /*搜索框绘制*/
        #sea{
            width: 300px;
            height: 40px;
            border: #000000 2px solid;
            border-radius: 2px;
            margin-left: 260px;
            margin-top: 30px;
            padding-left: 10px;
            padding-top: 5px;

        }
        /*查询按钮设置*/
        #btn01{
            width: 70px;
            height: 40px;
            background-color: #8b8989;
        }
        /*页面提示信息*/
        #file{
            width: 180px;
            height: 60px;
            float: right;
            margin-right: 30px;
            margin-top: 20px;
            padding-top: 5px;
        }
        /*列表查询表格的框设计*/
        tr{
            width: 1190px;
            height: 30px;
            font-size: 16px;
        }
        td{
            width: 170px;
            height: 30px;

        }

        table {margin: auto;} body{text-align: center;}。

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    </style>
    <%--调用外部adm.css文件--%>
    <link rel="stylesheet" href="css/adm.css" type="text/css">
</head>
<body>
<%--frame是css中的内容--%>
<div id="frame" style="background-color: #f8fafb">
    <%--导航栏--%>
    <div id="search">
        <input type="text" id="sea">
        <%--按钮 --%>
        <button id="btn01" onclick="search()">查询</button>
        <%--查询--%>
        <script>
            function search() {
                /*获取输入框输入的值*/
                let goalFile = document.getElementById("sea").value;
                let admId = ${user.getUid()};
                // 访问服务器
                window.location.href = "fileServlet?action=search&admid="+ admId +"&goalFile="+goalFile;
            }


        </script>



        <%--页面右上角的提示信息--%>
        <div id="file">
            账户:&nbsp;${user.getUid()}<br>
            姓名：${user.getName()}
        </div>
    </div>

    <br><br><br><br><br><br>

    <%--表格--%>
    <table border="1"  cellspacing="0"; style="padding-left:80px;border: #247dcd">
        <tr>
            <td>账户</td>
            <td>姓名</td>
            <td>身份证号</td>
            <td>借阅次数</td>
            <td>状态</td>
            <td>操作</td>
        </tr>

        <%--填充用户信息--%>
        <c:forEach items="${arr}" var="user">

            <c:if test="${user.getRole() != 0 }">
                <tr>
                    <td>${user.getUid()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getIdcard()}</td>
                    <td>${user.getU_times()}</td>
                    <td>${user.getState()}</td>
                    <td><button style="background-color: #f8fafb" onclick="lookThistUser('${user.getName()}')">查看借阅信息</button></td>
                </tr>

            </c:if>　

        </c:forEach>
    </table>


    <script>
        <%--//window.location.href = "fileServlet?action=goLendRecode2&admid="+${user.getUid()};--%>
        function lookThistUser(v) {
            window.location.href = "fileServlet?action=recodeSearch&admid=${user.getUid()}&goalFile="+v;

        }









    </script>




</div>
</body>
</html>
