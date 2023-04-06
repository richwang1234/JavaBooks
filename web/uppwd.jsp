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
        *{
            background-color: lightblue;
        }
        #book{
            width: 80%;
            margin-top: 40px;
            margin-bottom: 60px;
            /*border: blueviolet solid 2px;*/
            margin-left: 120px;
            background-color: lightblue;
        }

        #binner{
            margin-left: 100px;
            margin-top: 40px;
            font-size: 20px;
            background-color: lightblue;
        }

    </style>
</head>
<body>
<div id="frame">
    <div style="font-size: 40px;margin-left: 400px;margin-top: 20px">个人信息信息</div>
    <div id="book">

        <div id="binner">
            你的账户:&nbsp;&nbsp;&nbsp;&nbsp;${user.getUid()}
            <br><br>输入密码:&nbsp;&nbsp;&nbsp;<input id="aa" type="password" style="height: 30px;width: 270px; border: blueviolet 2px solid;border-radius: 2px;font-size: 17px">
            <br><br>确认密码:&nbsp;&nbsp;&nbsp;<input id="bb" type="password" style="height: 30px;width: 270px; border: blueviolet 2px solid;border-radius: 2px;font-size: 17px">

            <br><br><button  style="background-color: darkcyan; margin-left: 170px;width: 240px" onclick="uppwd()">确认修改</button>
            <script>

                function uppwd(){
                    let m = document.getElementById("aa").value;
                    let n = document.getElementById("bb").value;
                    alert(m+"  "+n);
                    if(m==n&&m.trim()!=""&&n.trim()!=""){
                        alert(1);
                        window.location.href = "ufiledeal?action=uppwd&pwd="+m+"&myid=${user.getUid()}";
                    }else {
                        alert("两次密码不一致");
                        return;
                    }

                }
            </script>
        </div>
    </div>
</div>
</body>
</html>