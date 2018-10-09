<%--
  Created by IntelliJ IDEA.
  User: janusz
  Date: 09.10.18
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddEmployee">add employee</a> |
<a href="EditEmployee">edit employee</a> |
<a href="DeleteEmployee">delete employee</a> |<br><br><br>

<form action="AddEmployee" method="post">
    <label>
        Name: <input type="text" name="name" />
    </label><br><br>
    <label>
        Lastname: <input type="text" name="lastname" />
    </label><br><br>
    <label>
        Address: <input type="text" name="address" />
    </label><br><br>
    <label>
        Phone: <input type="text" name="phone" />
    </label><br><br>
    <label>
        Note: <input type="text" name="note" />
    </label><br><br>
    <label>
        Pph: <input type="number" name="pph" />
    </label> <br><br>
    <input type="submit" value="Wyślij" />

</form>
<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>
