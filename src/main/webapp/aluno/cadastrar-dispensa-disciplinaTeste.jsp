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
    <h1>TELA DE DISPENSA DISCIPLINA</h1>
    <form name="dispensa-disciplina" method="post" action="${pageContext.request.contextPath}/dispensaDisciplina">
        
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>