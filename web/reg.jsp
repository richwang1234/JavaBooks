<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            background-color: bisque;
        }
    </style>
</head>
<body>
<h1>
    注册
</h1>

<div>
    姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="a"><br>
    性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="d"><br>
    身份证号:&nbsp;<input type="text" id="b"><br>
    密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="c"><br>
    <button onclick="sure()">注册</button>
    <script>
       function sure(){
           let a = document.getElementById('a').value;//姓名
           let b = document.getElementById('b').value;//身份证号
           let c = document.getElementById('c').value;//密码
           let d = document.getElementById('d').value;//性别
           window.location.href = 'reg?a='+a+'&b='+b+'&c='+c+'&d='+d;
       }
    </script>


</div>


</body>
</html>
