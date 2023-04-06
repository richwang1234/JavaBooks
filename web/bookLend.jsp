<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/16
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/14
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            background-color: #f8fafb;
        }
        #search{
            width: 1224px;
            height: 100px;
            border: #000000 1px solid;
            position: absolute;
        }

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
        #btn01{
            width: 70px;
            height: 40px;
            background-color: aliceblue;
        }
        #file{
            width: 180px;
            height: 60px;
            float: right;
            margin-right: 30px;
            margin-top: 20px;
            padding-top: 5px;
        }
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
    <link rel="stylesheet" href="css/adm.css" type="text/css">
</head>
<body>
<div id="frame">

    <div id="search">
        <input type="text" id="sea">
        <button id="btn01" onclick="search()">查询</button>

        <script>
            function search() {
                let goalFile = document.getElementById("sea").value;
                let admId = ${user.getUid()};
                window.location.href = "fileServlet?action=search&admid="+ admId +"&goalFile="+goalFile;
            }


        </script>




        <div id="file">
            账户:&nbsp;${user.getUid()}<br>
            姓名：${user.getName()}
        </div>
    </div>

    <br><br><br><br><br><br>


    <table border="1"  cellspacing="0"; style="padding-left:80px;border: blueviolet">
        <tr>
            <td>借阅编号</td>
            <td>借阅人</td>
            <td>借书时间</td>
            <td>还书时间(未还书 *)</td>
            <td>归还状态</td>
        </tr>

        <c:forEach items="${arr}" var="lbook">
            <tr>
                <td>${lbook.getLend_id()}</td>
                <td>${lbook.getLend_name()}</td>
                <td>${lbook.getLend_stime()}</td>
                <td>${lbook.getLend_rtime()}</td>
                <td>${lbook.getLend_type()}</td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
