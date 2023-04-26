<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minhkhiet
  Date: 25/04/2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> list todo </h1>
<form action="/TodoServlet" method="post">
    <input type="text" name="task" placeholder="new task">
    <input type="submit" name="action" value="Add"/>
</form>
<table border="1">
    <thead>
    <tr>
        <th>stt</th>
        <th>task name</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.taskName}</td>
            <td>
                <button><a href="/TodoServlet?action=delete&id=${task.id}">xoa</a></button>
                <button><a href="/TodoServlet?action=edit&id=${task.id}">edit</a></button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
