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
            background-color: lightblue;
        }
        #search{
            width: 1224px;
            height: 100px;
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
<div id="frame" style="background-color: #f8fafb">

    <div id="search">
        <input type="text" id="sea">
        <button id="btn01" onclick="search()">查询</button>

        <script>
            function search() {
                let goalFile = document.getElementById("sea").value;
                let admId = ${user.getUid()};
                window.location.href = "ufiledeal?action=bookSearch&myid="+ admId +"&goalFile="+goalFile;
            }


        </script>




        <div id="file">
            账户:&nbsp;${user.getUid()}<br>
            姓名：${user.getName()}
        </div>
    </div>

    <br><br><br><br><br><br>


    <table border="1"  cellspacing="0"; style="padding-left:10px;border: blueviolet">
        <tr>
            <td>图书编号</td>
            <td>图书名称</td>
            <td>图书类别</td>
            <td>图书总数</td>
            <td>借出总数</td>
            <td>图书操作</td>
            <td>查看借阅</td>
        </tr>

        <c:forEach items="${arr}" var="book">
            <tr>
                <td>${book.getBook_id()}</td>
                <td>${book.getBook_name()}</td>
                <td>${book.getBook_type()}</td>
                <td>${book.getBook_num()}</td>
                <td >${book.getBook_lend()}</td>

                <td ><button onclick="lendBook('${book.getBook_id()}','${book.getBook_num()}','${book.getBook_lend()}')">借书</button>
                </td>
                <td>
                    <button style="background-color: hotpink" onclick="lookbookall('${book.getBook_id()}')">查看详细</button>
                </td>
            </tr>
        </c:forEach>
        <script>
            function lendBook(a,b,c) {//m是book对象
                let m= a;
                alert(a+" "+' '+b+''+c)
                if((b-c)<=0){
                    alert("图书全部借出！");
                    return;
                }else {
                    window.location.href = "ufiledeal?action=lendBook&myid=${user.getUid()}&bookid="+m;
                }

            }
            function findAllFile(v){
                //v:要查的那本书的id
                window.location.href = "fileServlet?action=gofindAllFile&admid=${user.getUid()}&bookid="+v;
            }

            function toUpBook(m){
                window.location.href = "fileServlet?action=toUpBook&admid=${user.getUid()}&bookid="+m;
            }

            function lookLend(n) {
                window.location.href = "fileServlet?action=lookLend&admid=${user.getUid()}&bookid="+n;
            }

            //查看某一本书的详细信息
            function lookbookall(v) {
                window.location.href = "ufiledeal?action=lookbookall&myid=${user.getUid()}&sign="+v;

            }


        </script>
    </table>

</div>
</body>
</html>
