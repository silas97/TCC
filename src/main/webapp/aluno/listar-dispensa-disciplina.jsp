<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DispensaDisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar DISCIPLINA CURSADA</title>

</head>

<body>
    <h1>LISTAR DISPENSA DISCIPLINA</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>idAluno_FK</td>
            <td>idDisciplinaCursada_FK</td>
            <td>idDisciplina_FK</td>
            <td colspan="2">Execute</td>
        </tr>
        <c:forEach var="dispensaDisciplina" items="${dao.selectAll()}">
            <tr>
                <td>${dispensaDisciplina.idDispensaDisciplina}</td>
                <td>${dispensaDisciplina.getAluno().getUsuario().getNome()}</td>
                <td>${dispensaDisciplina.getDisciplinaCursada().getDisciplina()}</td>
                <td>${dispensaDisciplina.getDisciplina().getNome()}</td>
                <form name="dispensa-disciplina" action="${pageContext.request.contextPath}/dispensaDisciplina"
                    method="post">
                    <input type="hidden" value="${dispensaDisciplina.idDispensaDisciplina}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>