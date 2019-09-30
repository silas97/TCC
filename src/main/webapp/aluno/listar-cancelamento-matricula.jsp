<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.CancelamentoMatriculaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar CANCELAMENTO MATRICULA</title>

</head>

<body>
    <h1>LISTAR CANCELAMENTO MATRICULA</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Justificativa</td>
            <td>Data</td>
            <td colspan="2">Execute</td>
        </tr>
        <c:forEach var="cancelamentoMatricula" items="${dao.selectAll()}">
            <tr>
                <td>${cancelamentoMatricula.idCancelamentoMatricula}</td>
                <td>${cancelamentoMatricula.justificativa}</td>
                <td>${cancelamentoMatricula.dataCadastro}</td>
                <form name="cancelamento-matricula" action="${pageContext.request.contextPath}/cancelamentoMatricula" method="post">
                    <input type="hidden" value="${cancelamentoMatricula.idCancelamentoMatricula}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>