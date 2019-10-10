<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.RegimeDomiciliarProcessoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Listar REGIME DOMICILIAR</title>

    </head>

    <body>
        <h1>LISTAR REGIME DOMICILIAR</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>dataProcesso</td>
                <td>dataEncerramento</td>
                <td>status</td>
                <td>visibilidade</td>
                <td>idProcessos_FK</td>
                <td>idRegimeDomiciliar_FK</td>
                <td colspan="2" style="text-align: center;">Execute</td>
            </tr>
            <c:forEach var="regimeDomiciliarProcesso" items="${dao.selectAll()}">
                <tr>
                    <td>${regimeDomiciliarProcesso.idRegimeDomiciliarProcesso}</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>NADA AINDA</td>
                    <td>${regimeDomiciliarProcesso.getProcessos().getAluno().getUsuario().getNome()} / ${regimeDomiciliarProcesso.getProcessos().tipo}</td>
                    <td>${regimeDomiciliarProcesso.getRegimeDomiciliar().idRegimeDomiciliar}</td>
                <form name="regimeDomiciliarProcesso" action="${pageContext.request.contextPath}/regimeDomiciliarProcesso" method="post">
                    <input type="hidden" value="${regimeDomiciliarProcesso.idRegimeDomiciliarProcesso}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>