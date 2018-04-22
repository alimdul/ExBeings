<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${emptyList}

    Чтобы получить больше информации, авторизуйтесь
    Войти в систему <br>
    <form action="${pageContext.request.contextPath}/jsp/common/login.jsp">
        <input type="submit" value="Войти в систему"/>
    </form>
    Зарегистрироваться <br>
    <form action="${pageContext.request.contextPath}/jsp/common/register.jsp">
        <input type="submit" value="Зарегистрироваться"/>
    </form>
    <br>

    <table border="3" align="center">
        <tr>
            <th>Номер</th>
            <th>Имя инопланетянина</th>
            <th>Место обитания</th>
            <th>Пища</th>
            <th>Опасность</th>
            <th>Внешний вид</th>
            <th>Отличительная черта</th>
            <%--picture--%>
        </tr>

        <tr>
            <td>${alien.id}</td>
            <td>${alien.name}</td>
            <td>${alien.place}</td>
            <td>${alien.food}</td>
            <td>${alien.dangers}</td>
            <td>${alien.appearance}</td>
            <td>${alien.feature}</td>
        </tr>
    </table>

</body>
</html>
