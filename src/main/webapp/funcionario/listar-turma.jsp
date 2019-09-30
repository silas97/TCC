<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.TurmaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar Turmas</title>

</head>

<body>
    <h1>LISTAR TURMAS</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>periodo</td>
            <td>sigla</td>
            <td>idcurso_fk</td>
            <td colspan="2" style="text-align: center;">Execute</td>
        </tr>
        <c:forEach var="turma" items="${dao.selectAll()}">
            <tr>
                <td>${turma.idTurma}</td>
                <td>${turma.periodo}</td>
                <td>${turma.sigla}</td>
                <td>${turma.getCurso().getIdCurso()}</td>
                <form name="turma" method="post" action="${pageContext.request.contextPath}/turma">
                    <input type="hidden" value="${turma.idTurma}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>