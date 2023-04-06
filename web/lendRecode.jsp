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
            margin-top: 30px;
            border: #000000 1px solid;
            position: absolute;
        }

        #recodeSearch{
            width: 300px;
            height: 40px;
            border: #000000 2px solid;
            border-radius: 2px;
            margin-left: 260px;
            margin-top: 20px;
            padding-left: 10px;
            padding-top: 5px;

        }
        #btn01{
            width: 70px;
            height: 40px;
            background-color: #f8fafb;
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
<div id="frame" style="background-color: #f8fafb">

    <button onclick="retBook()" style="width: 200px;">未还</button>
    <button onclick="unretBook()" style="width: 200px;">归还</button>
    <button onclick="allBook()" style="width: 200px;">全部</button>
    <script>
        function retBook() {
            window.location.href = "fileServlet?action=retBook&admid="+ ${user.getUid()} ;
        }
        function unretBook() {
            window.location.href = "fileServlet?action=unretBook&admid="+ ${user.getUid()} ;
        }
        function allBook() {
            window.location.href = "fileServlet?action=all&admid="+ ${user.getUid()} ;
        }
    </script>


    <div id="search">
        <input type="text" id="recodeSearch">
        <button id="btn01" onclick="search()">查询</button>
        <br>
        <script>
            function search() {
                let goalFile = document.getElementById("recodeSearch").value;
                let admId = ${user.getUid()};
                window.location.href = "fileServlet?action=recodeSearch&admid="+ admId +"&goalFile="+goalFile;
            }
        </script>
    </div>
    <br><br>
    <br><br><br><br>
<%--    <span style="color: red">温馨提示:使用人名进行搜索</span>--%>

    <table border="1"  cellspacing="0"; style="margin-top:100px; padding-left:80px;border: blueviolet">
        <tr>
            <td>借阅编号</td>
            <td>借阅图书</td>
            <td>借书时间</td>
            <td>还书时间(未还书 *)</td>
            <td>
                 状态
            </td>
            <script>
                function retBook() {
                    window.location.href = "fileServlet?action=retBook&admid="+ ${user.getUid()} ;
                }
                function unretBook() {
                    window.location.href = "fileServlet?action=unretBook&admid="+ ${user.getUid()} ;
                }
                function allBook() {
                    window.location.href = "fileServlet?action=all&admid="+ ${user.getUid()} ;
                }

            </script>
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
