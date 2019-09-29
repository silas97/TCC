<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TURMA</title>
</head>

<body>
    <h1>CRUD TURMA</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/funcionario/cadastrar-turma.jsp">INSERT</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/listar-turma.jsp">SELECT</a></li>
    </ul>
</body>

</html>