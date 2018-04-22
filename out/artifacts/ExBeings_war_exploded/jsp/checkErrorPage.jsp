<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="ob" class="java.lang.String"/>
    ${ob.toString} //нет скобок после метода
</body>
</html>
