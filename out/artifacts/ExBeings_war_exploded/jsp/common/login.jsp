<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
Вход в систему <br><br>
<form name="loginForm" method="post" action="/controller">
    <input type="hidden" name="command" value="login"/>
    Логин <br>
    <input type="text" name="login" value=""/> <br><br>
    Пароль<br>
    <input type="password" name="password" value=""/> <br>
    ${errorSyntax} <br>
    ${errorLogin} <br>
    <input type="submit" value="Войти"/>
</form>
</body>
</html>
