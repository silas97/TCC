<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.AlunoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar ALUNO</title>

</head>

<body>
    <h1>LISTAR ALUNO</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>MATRICULA</td>
            <td>CURSO</td>
            <td>IDUSUARIO_NOME</td>
            <td colspan="2" style="text-align: center;">Execute</td>
        </tr>
        <c:forEach var="aluno" items="${dao.selectAll()}">
            <tr>
                <td>${aluno.idAluno}</td>
                <td>${aluno.matricula}</td>
                <td>${aluno.getCurso().getNome()}</td>
                <td>${aluno.getUsuario().getNome()}</td>
                <form name="aluno" action="${pageContext.request.contextPath}/aluno" method="post">
                    <input type="hidden" value="${aluno.idAluno}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>