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
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR USUARIO</h1>
    <form name="curso" method="post" action="${pageContext.request.contextPath}/curso">
        <h5>Nome</h5><input type="text" name="nome" placeholder="Nome" value="${course.nome}" required="" />
        <label>${message}</label>
        <input type="hidden" value="${course.idCurso}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>