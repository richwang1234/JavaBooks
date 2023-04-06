<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/3/14
  Time: 17:37
  To change this template use File | Settings | File Templates.
  主界面
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--标签语言--%>
<head>
    <title>Title</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
欢迎:&nbsp;${user.getName()}访问主界面<br>
${user.toString()}

</body>
</html>
