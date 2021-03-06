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
    <h1>TELA DE CADASTRO DISCIPLINA</h1>
    <form name="disciplina" method="post" action="${pageContext.request.contextPath}/disciplina">
        <h5>Nome</h5><input type="text" name="nome" placeholder="Nome" required="" />
        <h5>Créditos</h5><input type="text" name="creditos" placeholder="Creditos" required="" />
        <h5>Carga Horaria</h5><input type="text" name="cargaHoraria" placeholder="Carga Horaria" required="" />
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