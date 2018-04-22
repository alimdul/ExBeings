<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
Регистрация <br><br>
<form name="registerForm" method="post" action="/controller">
    <input type="hidden" name="command" value="register"/>
    Логин <br>
    <input type="text" name="login" value=""/> <br>
    Пароль<br>
    <input type="password" name="password" value=""/> <br>
    E-mail<br>
    <input type="text" name="mail" value=""/> <br>
    ${errorSyntax} <br>
    <input type="submit" value="Зарегистрироваться"/>
</form>
</body>
</html>