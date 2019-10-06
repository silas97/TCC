<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.ProcessosDAO" />
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
                <td>ID_ALUNO</td>
                <td>tipo</td>
                <td colspan="2" style="text-align: center;">Execute</td>
            </tr>
            <c:forEach var="processos" items="${dao.selectAll()}">
                <tr>
                    <td>${processos.idProcessos}</td>
                    <td>${processos.getAluno().getUsuario().getNome()}</td>
                    <td>${processos.tipo}</td>
                <form name="processos" action="${pageContext.request.contextPath}/processos" method="post">
                    <input type="hidden" value="${processos.idProcessos}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>