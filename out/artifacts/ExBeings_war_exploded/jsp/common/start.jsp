<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
    Войти в систему <br>
    <form action="${pageContext.request.contextPath}/jsp/common/login.jsp">
        <input type="submit" value="Войти в систему"/>
    </form>
    <br>
    Зарегистрироваться <br>
    <form action="${pageContext.request.contextPath}/jsp/common/register.jsp">
        <input type="submit" value="Зарегистрироваться"/>
    </form>
    <br>
    Войти как гость <br>
    <form name="showInformationForGuestForm" method="post" action="/controller">
        <input type="hidden" name="command" value="show_alien_types_list"/>
        <input type="submit" value="Войти как гость"/>
    </form>
</body>
</html>
