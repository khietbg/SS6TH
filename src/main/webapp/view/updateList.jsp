<%--
  Created by IntelliJ IDEA.
  User: minhkhiet
  Date: 25/04/2023
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Task</h2>
<form action="/TodoServlet" method="post">
  <input type="text" name="taskName" placeholder="new task" value="${taskEdit.taskName}">
    <input type="hidden" name="id" value="${taskEdit.id}">
  <input type="submit" name="action" value="edit"/>
</form>
</body>
</html>
