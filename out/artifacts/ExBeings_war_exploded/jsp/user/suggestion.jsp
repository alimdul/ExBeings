<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form name="suggestionForm" method="post" action="/controller">
        <input type="hidden" name="command" value="suggest"/>
        Название <br>
        <input type="text" name="name" value=""/> <br>
        Место <br>
        <textarea  name="place"></textarea>  <br>
        Пища <br>
        <textarea name="food"></textarea> <br>
        Опасность <br>
        <textarea name="dangers"></textarea> <br>
        Внешний вид <br>
        <textarea name="appearance"></textarea> <br>
        Интересное <br>
        <textarea name="feature"></textarea><br>

        <input type="submit" value="предложить"/>
    </form>

</body>
</html>
