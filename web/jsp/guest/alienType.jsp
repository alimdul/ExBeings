<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${emptyList}

    <table border="3" align="center">
        <tr>
            <th>Номер</th>
            <th>Имя</th>
            <th>Опасность</th>
            <%--picture--%>
        </tr>
        <c:forEach var="alien" items="${aliens}">
            <tr>
                <td>${alien.id}</td>
                <td>
                    <form name="showAlien" method="post" action="/controller">
                        <input type="hidden" name="command" value="show_alien"/>
                        <input type="hidden" name="alien" value="${alien.name}"/>
                        <input type="submit" value="${alien.name}"/>
                    </form>
                </td>
                <td>${alien.dangers}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
