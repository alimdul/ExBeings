<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${pageContext.session.getAttribute("name")}, привет=) Вы пользователь! <br><br>

    <form name="logoutForm" method="post" action="/controller">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Выйти"/>
    </form>
</body>
</html>
