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
    <h1>ALTERAR CANCELAMENTO MATRICULA</h1>
    <form name="cancelamento-matricula" method="post" action="${pageContext.request.contextPath}/cancelamentoMatricula">
        <h5>Justificativa</h5><input type="text" name="justificativa" placeholder="Justificativa" value="${sCancelamentoMatricula.justificativa}" required="" />
        <label>${message}</label>
        <input type="hidden" value="${sCancelamentoMatricula.idCancelamentoMatricula}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>