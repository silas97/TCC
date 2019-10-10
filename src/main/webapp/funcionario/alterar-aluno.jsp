<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoCurso" class="br.edu.fafic.dao.CursoDAO" />
<jsp:useBean id="daoUsuario" class="br.edu.fafic.dao.UsuarioDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR ALUNO</h1>
    <form name="aluno" method="post" action="${pageContext.request.contextPath}/aluno">
        <h5>Matricula</h5><input type="text" name="matricula" placeholder="Matricula" value="${sAluno.matricula}" required="" />
        <h3>curso</h3>
        <select name="idCurso_FK" required="">
            <c:forEach var="curso" items="${daoCurso.selectAll()}">
                <option value="${curso.idCurso}">${curso.nome}</option>
            </c:forEach>
        </select>
        <h3>Usuario</h3>
        <select name="idUsuario_FK" required="">
            <c:forEach var="usuario" items="${daoUsuario.selectAll()}">
                <option value="${usuario.idUsuario}">${usuario.nome}</option>
            </c:forEach>
        </select>
        <input type="hidden" value="${sAluno.idAluno}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>