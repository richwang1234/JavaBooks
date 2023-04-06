<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/16
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adm.css" type="text/css">
    <style>
        *{
            background-color: lightblue;
        }
        #binner{
            width: 85%;
            margin-left: 100px;
            margin-top: 20px;
        }
        #ad{
            margin-left: 70px;
            margin-top: 40px;
            background-color: lightblue;
        }


    </style>


</head>
<body>
<div style="font-size: 40px;margin-left: 400px;margin-top: 20px">个人详细信息</div>
<div id="frame" style="background-color: lightblue">
    <div id="binner" >
        <div id="ad" >
            <br><br>读者编号:&nbsp;&nbsp;&nbsp;${user.getUid()}
            <br><br>读者姓名:&nbsp;&nbsp;&nbsp;${user.getName()}
            <br><br>读者性别:&nbsp;&nbsp;&nbsp;${user.getSex()}
            <br><br>身份证号:&nbsp;&nbsp;&nbsp;${user.getIdcard()}
            <br><br>借阅次数:&nbsp;&nbsp;&nbsp;${user.getU_times()}
            <br><br>
            <button onclick="uppwd()" style="width: 200px">修改密码</button>
            <br><br><br>
        </div>

        <script>
            function uppwd() {
                window.location.href = "ufiledeal?action=touppwd&myid="+${user.getUid()};
            }
        </script>
    </div>
    <br><br><br>
</div>
</body>
</html>
