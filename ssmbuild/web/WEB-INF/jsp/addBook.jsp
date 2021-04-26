<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
添加书籍:
<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    书籍名称：<input type="text" name="bookName"><br><br><br>
    书籍数量：<input type="text" name="bookCounts"><br><br><br>
    书籍详情：<input type="text" name="detail"><br><br><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
