<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoAluno" class="br.edu.fafic.dao.AlunoDAO" />
<jsp:useBean id="daoDisciplinaCursada" class="br.edu.fafic.dao.DisciplinaCursadaDAO" />
<jsp:useBean id="daoDisciplina" class="br.edu.fafic.dao.DisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>TELA DE CADASTRO DISPENSA DISCIPLINA</h1>
    <form name="dispensa-disciplina" method="post" action="${pageContext.request.contextPath}/dispensaDisciplina">
        <h5>Usuario</h5>
        <select name="idAluno_FK" required="">
            <c:forEach var="aluno" items="${daoAluno.selectAll()}">
                <option value="${aluno.idAluno}">${aluno.getUsuario().getNome()}</option>
            </c:forEach>
        </select>
        <h5>Disciplina Cursada</h5>
        <select name="idDisciplinaCursada_FK" required="">
            <c:forEach var="disciplinaCursada" items="${daoDisciplinaCursada.selectAll()}">
                <option value="${disciplinaCursada.idDisciplinaCursada}">${disciplinaCursada.disciplina}</option>
            </c:forEach>
        </select>
        <h5>Disciplina</h5>
        <select name="idDisciplina_FK" required="">
            <c:forEach var="disciplina" items="${daoDisciplina.selectAll()}">
                <option value="${disciplina.idDisciplina}">${disciplina.nome}</option>
            </c:forEach>
        </select>
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>