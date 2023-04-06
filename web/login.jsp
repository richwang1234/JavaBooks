<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/13
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #frame{
            margin-top: 0px;
            width: 1540px;
            height: 2000px;
            padding-top: 100px;
            background-image: url("a.png");
            /*铺满背景*/
            background-size: 100%100%;
            background-attachment: fixed;
        }
        #inner{
            width: 550px;
            height: 400px;
            margin-top: 100px;
            margin-left: 500px;
            border: solid 3px ;

        }
        #login_{
            width: 350px;
            height: 200px;
            margin-left: 130px;
            margin-top: 80px;
            /*border: blue solid 2px;*/
        }
        input{
            height: 30px;
            width: 220px;
            margin-top: 20px;
            border: #000000 3px solid;
            border-radius: 4px;
        }

        button{
            /*height: 30px;*/
            width: 100px;
            font-size: 18px;
            margin-left: 20px;
        }
    </style>


    <!-- js代码，动作监听事件-->
    <script>
        function login(){
            <!-- 获取输入框的值-->
            let uid = document.getElementById("uid").value;
            let pwd = document.getElementById("upwd").value;
            <!-- 判断输入框的值是否为空-->
            if(uid==null||uid.trim()==""){
                document.getElementById("error").innerHTML = "账户不能为空";
                <!-- 终止，返回-->
                return;
            }
            if(pwd==null||pwd.trim()==""){
                document.getElementById("error").innerHTML = "密码不能为空";
                return;
            }
            <!-- 服务器地址-->
            window.location.href = 'login?uid='+uid+'&pwd='+pwd;//找服务器的一条语句

        }

        function regist() {
            window.open("reg.jsp",null,"width=400,height=400,left=500,top=500",true);
        }





    </script>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</head>
<body>

    <div id="frame">
        <div id="inner" style="background-color: white;opacity: 0.75" >
            <div id="login_">
                <span style="font-size: 50px">图书管理系统</span><br><br><br>
                <!-- 输入框标签-->
                账户:&nbsp;&nbsp;<input type="text" id="uid">
                <br><br>
                密码:&nbsp;&nbsp;<input type="password" id="upwd">
                <br><br>
                <!-- 给按钮添加动作监听事件-->
                <button id="btn01" onclick="regist()">注册</button>&nbsp;&nbsp;
                <button id="btn02" onclick="login()">登录</button><br>
                <!-- 错误提示标签-->
                <span id="error" style="color: red">${error}</span>
            </div>
        </div>
    </div>




</body>
</html>
