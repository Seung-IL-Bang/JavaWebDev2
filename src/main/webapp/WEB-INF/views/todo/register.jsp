<%--
  Created by IntelliJ IDEA.
  User: bang
  Date: 2023/05/02
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>

<form action="/todo/register" method="post">
    <div>
        Title: <input type="text" name="title" />
    </div>
    <div>
        DueDate: <input type="date" name="dueDate" value="2023-05-02" />
    </div>
    <div>
        Writer: <input type="text" name="writer" />
    </div>
    <div>
        Finished: <input type="checkbox" name="finished" />
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>

</body>
</html>
