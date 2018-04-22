<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${emptyList}

    <c:forEach var="type" items="${alienTypes}">
        <form name="showAlienType" method="post" action="/controller">
            <input type="hidden" name="command" value="show_alien_type"/>
            <input type="hidden" name="alienType" value="${type.name}"/>
            <input type="submit" value="${type.name}"/>
        </form>
        ${type.description}
        <br><br>
    </c:forEach>

    ${unknownError}
</body>
</html>
