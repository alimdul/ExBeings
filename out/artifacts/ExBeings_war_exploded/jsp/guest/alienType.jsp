<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${emptyList}

    Чтобы получить больше информации, авторизуйтесь <br><br>
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
            <th>Имя</th>
            <th>Опасность</th>
            <th>Изображение</th>
            <%--picture--%>
        </tr>
        <c:forEach var="alien" items="${aliens}">
            <tr>
                <td>${alien.id}</td>
                <td>${alien.name}</td>
                <td>${alien.dangers}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
