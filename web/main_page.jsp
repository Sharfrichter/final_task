<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.05.2021
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="css/style.css"%>
</style>
<html>
<head>
    <TITLE>Title</TITLE>
<%--    <link href="css/style.css" rel="stylesheet" type="text/css" />--%>
<%--    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
<%--    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">--%>
</head>

<body>
<p>${message}</p>
<form id="login" action="?command=authorization" method="post">
    <h1>Форма входа</h1>
    <fieldset id="inputs">
        <input id="username" type="text" name="login" placeholder="Логин" autofocus required>
        <input id="password" type="password" name="password" placeholder="Пароль" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="ВОЙТИ">
        <a href="?command=registration_page">Регистрация</a>
    </fieldset>
</form>
</body>
</html>