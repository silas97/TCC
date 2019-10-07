<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>

<body>
    <h1>INDEX FUNCIONÁRIO</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/funcionario/curso.jsp">CURSO</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/disciplina.jsp">DISCIPLINA</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/turma.jsp">TURMA</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/aluno.jsp">ALUNO</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/processos.jsp">PROCESSOS</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/cancelamento-matricula-processo.jsp">CANCELAMENTO MATRICULA PROCESSO</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/regime-domiciliar-processo.jsp">REGIME DOMICILIAR PROCESSO</a></li>
    </ul>
</body>

</html>