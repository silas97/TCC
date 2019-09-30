<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.CursoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>TELA DE CADASTRO TURMA</h1>
    <form name="turma" method="post" action="${pageContext.request.contextPath}/turma">
        <h5>Periodo</h5><input type="text" name="periodo" placeholder="Periodo" required="" />
        <h5>Sigla</h5><input type="text" name="sigla" placeholder="Sigla" required="" />
        <h5>Curso</h5>
        <select name="idCurso_FK">
            <c:forEach var="curso" items="${dao.selectAll()}">
                <option value="${curso.idCurso}">${curso.nome}</option>
            </c:forEach>
        </select>
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>