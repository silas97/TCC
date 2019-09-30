<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.CursoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar Cursos</title>

</head>

<body>
    <h1>LISTAR CURSOS</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>nome</td>
            <td colspan="2" style="text-align: center;">Execute</td>
        </tr>
        <c:forEach var="curso" items="${dao.selectAll()}">
            <tr>
                <td>${curso.idCurso}</td>
                <td>${curso.nome}</td>
                <form name="curso" action="${pageContext.request.contextPath}/curso" method="post">
                    <input type="hidden" value="${curso.idCurso}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>