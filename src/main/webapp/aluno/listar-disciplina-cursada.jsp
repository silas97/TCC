<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DisciplinaCursadaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar DISCIPLINA CURSADA</title>

</head>

<body>
    <h1>LISTAR DISCIPLINA CURSADA</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>instituicaoOrigem</td>
            <td>curso</td>
            <td>disciplina</td>
            <td>creditos</td>
            <td>horasCursadas</td>
            <td colspan="2">Execute</td>
        </tr>
        <c:forEach var="disciplinaCursada" items="${dao.selectAll()}">
            <tr>
                <td>${disciplinaCursada.idDisciplinaCursada}</td>
                <td>${disciplinaCursada.instituicaoOrigem}</td>
                <td>${disciplinaCursada.curso}</td>
                <td>${disciplinaCursada.disciplina}</td>
                <td>${disciplinaCursada.creditos}</td>
                <td>${disciplinaCursada.horasCursadas}</td>
                <form name="disciplina-cursada" action="${pageContext.request.contextPath}/disciplinaCursada" method="post">
                    <input type="hidden" value="${disciplinaCursada.idDisciplinaCursada}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>