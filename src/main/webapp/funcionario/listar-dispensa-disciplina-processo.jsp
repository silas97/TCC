<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DispensaDisciplinaProcessoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Listar DISPENSA DISCPLINA</title>

    </head>

    <body>
        <h1>LISTAR DISCPENSA DISCIPLINA</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>dataProcesso</td>
                <td>dataEncerramento</td>
                <td>status</td>
                <td>visibilidade</td>
                <td>idProcessos_FK</td>
                <td>idDispensaDisciplina_FK</td>
                <td colspan="2" style="text-align: center;">Execute</td>
            </tr>
            <c:forEach var="dispensaDisciplinaProcesso" items="${dao.selectAll()}">
                <tr>
                    <td>${dispensaDisciplinaProcesso.idDispensaDisciplinaProcesso}</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>${dispensaDisciplinaProcesso.getProcessos().getAluno().getUsuario().getNome()} / ${dispensaDisciplinaProcesso.getProcessos().tipo}</td>
                    <td>${dispensaDisciplinaProcesso.getDispensaDisciplina().idDispensaDisciplina}</td>
                <form name="dispensaDisciplinaProcesso" action="${pageContext.request.contextPath}/dispensaDisciplinaProcesso" method="post">
                    <input type="hidden" value="${dispensaDisciplinaProcesso.idDispensaDisciplinaProcesso}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>