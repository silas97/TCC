<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>

<body>
    <h1>INDEX FUNCIONÁRIO</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/funcionario/curso.jsp">CURSO</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/disciplina.jsp">DISCIPLINA</a></li>
    </ul>
</body>

</html>