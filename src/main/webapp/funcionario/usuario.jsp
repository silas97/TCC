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
    <title>Upload</title>
</head>

<body>
    <h1>CRUD USUARIO</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/funcionario/cadastrar-usuario.jsp">INSERT</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/listar-usuario.jsp">SELECT</a></li>
    </ul>
</body>

</html>