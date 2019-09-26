<%--
  Created by IntelliJ IDEA.
  User: TARAZ
  Date: 04.09.2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<p><a href="/update">Update User</a> |
    <a href="/update">Update User</a>|
    <a href="/user"> User</a>
</p>
<h3>Delete User</h3>

<form  method="post" action="/del">
    <p>Id for delete User: <input type="number" name="id"></p>
    <button >Delete User</button>
</form>

</body>
</html>
