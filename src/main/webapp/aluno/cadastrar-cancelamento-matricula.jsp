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
    <h1>TELA DE CADASTRO CANCELAMENTO MATRICULA</h1>
    <form name="cancelamento-matricula" method="post" action="${pageContext.request.contextPath}/cancelamentoMatricula">
        <h5>Justificativa</h5><input type="text" name="justificativa" placeholder="Justificativa" required="" />
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>