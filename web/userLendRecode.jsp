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
            background-color: aliceblue;
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
<div id="frame" style="background-color: lightblue">
    <br><br>
    <button onclick="retBook()" style="width: 200px;">未还</button>
    <button onclick="unretBook()" style="width: 200px;">归还</button>
    <button onclick="allBook()" style="width: 200px;">全部</button>
    <script>

        function retBook() {
            window.location.href = "ufiledeal?action=retBook&myid="+ ${user.getUid()} ;
        }
        function unretBook() {
            window.location.href = "ufiledeal?action=unretBook&myid="+ ${user.getUid()} ;
        }
        function allBook() {
            window.location.href = "ufiledeal?action=all&myid="+ ${user.getUid()} ;
        }
    </script>

    <br><br>
    <br><br>
    <%--    <span style="color: red">温馨提示:使用人名进行搜索</span>--%>

    <table border="1"  cellspacing="0"; style=" padding-left:80px;border: blueviolet">
        <tr>
            <td>借阅编号</td>
            <td>借阅图书</td>
            <td>借书时间</td>
            <td>还书时间(未还书 *)</td>
            <td>
                操作
            </td>
        </tr>


        <c:forEach items="${arr}" var="lbook">
            <tr>
                <td>${lbook.getLend_id()}</td>
                <td>${lbook.getLend_name()}</td>
                <td>${lbook.getLend_stime()}</td>
                <td>${lbook.getLend_rtime()}</td>
                <td><button style="background-color: aqua" onclick="UserRetBook('${lbook.getLend_id()}','${lbook.getLend_rtime()}')">还书</button></td>
            </tr>
        </c:forEach>
    </table>
    <script>
        function UserRetBook(v,m) {
            if(m!="*"){
                alert("此书已经还！");
                return;
            }
            //还书操作
            //v ：借阅编号
            window.location.href = "ufiledeal?action=UserRetBook&myid=${user.getUid()}&lendid="+v;



        }
    </script>

</div>
</body>
</html>
