<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.05.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${message}</p>

<form action="?command=registration" method="post">
    Login<input type="text" name="login">
    Password<input type="text" name="password">
    Name<input type="text" name="firstName">
    Last Name<input type="text" name="lastName">
    <input type="submit" value="send">
</form>
</body>
</html>
