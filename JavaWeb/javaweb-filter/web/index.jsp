<%--
  Created by IntelliJ IDEA.
  User: zr
  Date: 2021/5/24
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  当前人数:
  <%=this.getServletConfig().getServletContext().getAttribute("onlineCounter")%>
  </body>
</html>
