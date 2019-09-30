<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Listar Disciplinas</title>

    </head>

    <body>
        <h1>LISTAR CURSOS</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>nome</td>
                <td>creditos</td>
                <td>carga horaria</td>
                <td>idcurso_fk</td>
                <td colspan="2" style="text-align: center;">Execute</td>
            </tr>
            <c:forEach var="disciplina" items="${dao.selectAll()}">
                <tr>
                    <td>${disciplina.idDisciplina}</td>
                    <td>${disciplina.nome}</td>
                    <td>${disciplina.creditos}</td>
                    <td>${disciplina.cargaHoraria}</td>
                    <td>${disciplina.getCurso().getIdCurso()}</td>
                <form name="curso" action="${pageContext.request.contextPath}/disciplina" method="post">
                    <input type="hidden" value="${disciplina.idDisciplina}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>