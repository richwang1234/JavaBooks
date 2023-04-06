<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/15
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adm.css" type="text/css">
    <style>
        #book{
            width: 80%;
            margin-top: 40px;
            margin-bottom: 60px;
            /*border: blueviolet solid 2px;*/
            margin-left: 120px;
        }

        #binner{
            margin-left: 100px;
            margin-top: 40px;
            font-size: 20px;
        }

    </style>
</head>
<body>
<div id="frame">
    <div style="font-size: 40px;margin-left: 400px;margin-top: 20px">修改图书信息</div>
    <div id="book">

        <div id="binner">
            图书编号:&nbsp;&nbsp;&nbsp;&nbsp;${book.getBook_id()}
            <%--<br><br>图书名称:&nbsp;&nbsp;&nbsp;${book.getBook_name()}--%>
            <br><br>图书名称:&nbsp;&nbsp;&nbsp;<input id="name" style="height: 30px;width: 270px; border: #000000 2px solid;border-radius: 2px;font-size: 17px" value="${book.getBook_name()}">
            <br><br>图书数量:&nbsp;&nbsp;&nbsp;<input id="num" style="height: 30px;width: 270px; border: #000000 2px solid;border-radius: 2px;font-size: 17px" value="${book.getBook_num()}">
            <br><br>图书价格:&nbsp;&nbsp;&nbsp;<input id="price" style="height: 30px;width: 270px; border: #000000 2px solid;border-radius: 2px;font-size: 17px" value="${book.getBook_price()}">

            <br><br><button style="margin-left: 170px;width: 240px" onclick="upBook()">确认修改</button>
            <script>

                function upBook(){
                    let number = document.getElementById("num").value;
                    let price = document.getElementById("price").value;
                    window.location.href = "fileServlet?action=upbook&admid=${user.getUid()}&bookId=${book.getBook_id()}&number="+number+"&price="+price;
                }




            </script>

        </div>

    </div>



</div>

</body>
</html>
