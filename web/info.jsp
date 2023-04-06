<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2022/4/15
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #frame{
            width: 80%;
            margin-left: 300px;
            border: #000000 3px solid;
            background-color: #f8fafb;
        }

        #tex,#bbb{
            width: 700px;
            height: 40px;
            border: #f8fafb 2px solid;
            font-size: 30px;
            margin-left: 40px;
            margin-top: 40px;
        }

        #ccc{
            width: 120px;
            height: 30px;
        }

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    </style>
</head>
<body>
<div id="frame"style="width:80%">
    <div id="">
        <span id="bbb" style="font-size: 24px;">添加留言:</span>&nbsp;&nbsp;&nbsp;<input id="tex">&nbsp;&nbsp;&nbsp;
        <button id="ccc" onclick="addInfo()">点击添加</button>
    </div>

    <script>
        function addInfo(){
            if('${user.getRole()}'==0){
                window.location.href = "fileServlet?action=addinfo&context="+document.getElementById("tex").value+"&admid=${user.getUid()}"
            }else {
                window.location.href = "ufiledeal?action=addinfo&context="+document.getElementById("tex").value+"&myid=${user.getUid()}"
            }

        }
    </script>




    <tr>  <tr>

<table style="font-size: 16px;margin-left: 210px">
    <c:forEach items="${arr}" var="file">
        <tr>
            <td><span style="color: red">${file.getName()}:</span>&nbsp;&nbsp;&nbsp;<span style="color: cornflowerblue">${file.getInfo()}</span></td>

        </tr>
    </c:forEach>
</table>

    <br><br><br><br>




</div>
</body>
</html>
