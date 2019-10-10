<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.CancelamentoMatriculaProcessoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Listar PROCESSOS</title>

    </head>

    <body>
        <h1>LISTAR PROCESSOS</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>dataProcesso</td>
                <td>dataEncerramento</td>
                <td>status</td>
                <td>visibilidade</td>
                <td>idProcessos_FK</td>
                <td>idCancelamentoMatricula_FK</td>
                <td colspan="2" style="text-align: center;">Execute</td>
            </tr>
            <c:forEach var="cancelamentoMatriculaProcesso" items="${dao.selectAll()}">
                <tr>
                    <td>${cancelamentoMatriculaProcesso.idCancelamentoMatriculaProcesso}</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>${cancelamentoMatriculaProcesso.getProcessos().getAluno().getUsuario().getNome()} / ${cancelamentoMatriculaProcesso.getProcessos().tipo}</td>
                    <td>${cancelamentoMatriculaProcesso.getCancelamentoMatricula().idCancelamentoMatricula}</td>
                <form name="cancelamentoMatriculaProcesso" action="${pageContext.request.contextPath}/cancelamentoMatriculaProcesso" method="post">
                    <input type="hidden" value="${cancelamentoMatriculaProcesso.idCancelamentoMatriculaProcesso}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>