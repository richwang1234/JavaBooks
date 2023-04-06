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
        #binner{
            width: 85%;
            margin-left: 100px;
            margin-top: 20px;
            border: #000000 solid 2px;
        }
        #ad{
            margin-left: 70px;
            margin-top: 40px;
        }
        *{
            background-color: #f8fafb;
        }
    </style>
    <link rel="stylesheet" href="css/adm.css" type="text/css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="frame">
    <div style="font-size: 40px;margin-left: 400px;margin-top: 20px">图书详细信息</div>
    <div id="binner">
        <div id="ad">
            <br><br>图书编号:&nbsp;&nbsp;&nbsp;${book.getBook_id()}
            <br><br>图书名称:&nbsp;&nbsp;&nbsp;${book.getBook_name()}
            <br><br>图书类型:&nbsp;&nbsp;&nbsp;${book.getBook_type()}
            <br><br>图书数量:&nbsp;&nbsp;&nbsp;${book.getBook_num()}
            <br><br>图书价格:&nbsp;&nbsp;&nbsp;${book.getBook_price()}
            <br><br>借出数量:&nbsp;&nbsp;&nbsp;${book.getBook_lend()}
            <br><br>图书ISBN:&nbsp;&nbsp;&nbsp;${book.getBook_ISBN()}
            <br><br>图书地址:&nbsp;&nbsp;&nbsp;${book.getBook_address()}
            <br><br>发行地址:&nbsp;&nbsp;&nbsp;${book.getBook_business()}
            <br><br>图书作者:&nbsp;&nbsp;&nbsp;${book.getBook_author()}
            <br><br>图书版本:&nbsp;&nbsp;&nbsp;${book.getBook_edition()}
            <br><br>借阅次数:&nbsp;&nbsp;&nbsp;${book.getBook_times()}
            <br><br><br>
            <button type="button" onclick="javascript:history.back();">返回</button>
        </div>

    </div>

</div>
</body>
</html>
