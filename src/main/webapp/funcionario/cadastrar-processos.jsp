<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.AlunoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>TELA DE CADASTRO PROCESSOS</h1>
    <form name="processos" method="post" action="${pageContext.request.contextPath}/processos">
        <h5>Aluno</h5>
        <select name="idAluno_FK">
            <c:forEach var="aluno" items="${dao.selectAll()}">
                <option value="${aluno.idAluno}">${aluno.getUsuario().getNome()}</option>
            </c:forEach>
        </select>
        <h5>Tipo</h5>
        <input type="radio" name="tipo" value="Dispensa Disciplina" checked>Dispensa Disciplina<br>
        <input type="radio" name="tipo" value="Regime Domiciliar">Regime Domiciliar<br>
        <input type="radio" name="tipo" value="Cancelamento Matricula">Cancelamento Matricula<br>
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>