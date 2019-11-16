<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 16.11.19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>

<form action="addBook" method="POST">
    <input type="hidden" name="id" value="0">
    <label>
        ISBN:
        <input type="number" name="isbn">
        Title:
        <input type="text" name="title">
        Author:
        <input type="text" name="author">
        Publisher:
        <input type="text" name="publisher">
        Type:
        <input type="text" name="type">

        <input type="submit">
    </label>
</form>

</body>
</html>
