<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/14
  Time: 23:02
  To change this template use File | Settings | File Templates.
  管理员图书管理界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
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
            background-color: #f8fafb;
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

        tr,td{
            height: 40px;
        }

        table {margin: auto;} body{text-align: center;}


         /*JSTL*/
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    </style>
    <link rel="stylesheet" href="css/adm.css" type="text/css">
</head>
<body>
<div id="frame" style="background-color: #f8fafb">

    <div id="search">
        <input type="text" id="sea">
        <button id="btn01" onclick="search()">查询</button>
        <button id="c" onclick="goBookAdd()">增加图书</button>

        <script>
            function search() {
                let goalFile = document.getElementById("sea").value;
                let admId = ${user.getUid()};
                alert(a)
                window.location.href = "fileServlet?action=bookSearch&admid="+ admId +"&goalFile="+goalFile;
            }
            function goBookAdd() {
                window.location.href = "fileServlet?action=goBookAdd&admid="+${user.getUid()};
            }


        </script>





        <div id="file">
            账户:&nbsp;${user.getUid()}<br>
            姓名：${user.getName()}
        </div>
    </div>

    <br><br><br><br><br><br>


    <table border="1"  cellspacing="0"; style="padding-left:10px;border: #000000">
        <tr>
            <%--表格名--%>
            <td>图书编号</td>
            <td>图书名称</td>
            <td>图书类别</td>
            <td style="width: 50px">图书总数</td>
            <td style="width: 50px">借出总数</td>
            <td style="width: 220px">图书操作</td>
            <%--<td style="width: 80px">查看借阅</td>--%>
        </tr>
        <%--填充图书信息表--%>
        <c:forEach items="${arr}" var="book">
            <tr>
                <td>${book.getBook_id()}</td>
                <td>${book.getBook_name()}</td>
                <td>${book.getBook_type()}</td>
                <td>${book.getBook_num()}</td>
                <td >${book.getBook_lend()}</td>

                <td style="width: 220px"><button style="background-color: #f8fafb" onclick="toUpBook('${book.getBook_id()}')">图书修改</button>
                    <button style="background-color: #f8fafb" onclick="findAllFile('${book.getBook_id()}')">查看信息</button>
                    <button style="background-color: #f8fafb" onclick="delbook('${book.getBook_id()}',${book.getBook_lend()})">图书删除</button>
                </td>
                <%--<td style="width: 80px">
                    <button style="width: 70px;background-color: #f8fafb" onclick="lookLend('${book.getBook_id()}')">查看借阅</button>
                </td>--%>
            </tr>
        </c:forEach>
        <script>
            function delbook(a,c) {
                if(c>0){
                    alert("暂时不能删除，借出状态不能删除！")
                }else {
                    window.location.href = "fileServlet?action=delbook&admid=${user.getUid()}&bookid="+a;

                }
            }


            function findAllFile(v){
                //v:要查的那本书的id
                window.location.href = "fileServlet?action=findAllFile&admid=${user.getUid()}&bookid="+v;
            }

            function toUpBook(m){
                window.location.href = "fileServlet?action=toUpBook&admid=${user.getUid()}&bookid="+m;
            }

            function lookLend(n) {
                window.location.href = "fileServlet?action=lookLend&admid=${user.getUid()}&bookid="+n;
            }



        </script>
    </table>

</div>
</body>
</html>
