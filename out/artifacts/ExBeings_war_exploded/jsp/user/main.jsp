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
    </form> <br>

    <form name="showAlienTypesList" method="post" action="/controller">
        <input type="hidden" name="command" value="show_alien_types_list"/>
        <input type="submit" value="Просмотреть"/>
    </form> <br>

    <form action="${pageContext.request.contextPath}/jsp/user/suggestion.jsp">
        <input type="submit" value="Предложить"/>
    </form>

    <%--<form name="suggestAlien" method="post" action="/controller">--%>
        <%--<input type="hidden" name="command" value="suggest_alien"/>--%>
        <%--<input type="submit" value="Предложить"/>--%>
    <%--</form>--%>
</body>
</html>
