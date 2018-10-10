<%--
  Created by IntelliJ IDEA.
  User: janusz
  Date: 10.10.18
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Emplolyee</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddEmployee">add employee</a> |
<a href="EditEmployee">edit employee</a> |
<a href="DeleteEmployee">delete employee</a>
<br><br>|
<form action="DeleteEmployee" method="post">

    </label> <label> delete employee with id: <input type="number" name="id" required/>
</label> <br>  <input type="submit" value="Wyślij" required/>

</form>
<%@include file="/WEB-INF/footer.jsp" %>

</body>
</html>
