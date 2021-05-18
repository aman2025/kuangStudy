<%--
  Created by IntelliJ IDEA.
  User: zr
  Date: 2021/5/17
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
 <form action="${pageContext.request.contextPath}/login" method="post">
     用户名:<input type="text" name="username">
     <div>--------------------</div>
     密码:<input type="password" name="password">
     <div>--------------------</div>
     爱好:
     <input type="checkbox" name="hobby" value="code">代码
     <input type="checkbox" name="hobby" value="movie">电影
     <input type="submit" value="登录">
 </form>
</body>
</html>
