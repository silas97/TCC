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
    <title>JSP Page</title>
</head>

<body>
    <h1>Ola Mundo JSP!</h1>
    <form name="login" method="post" action="login">
        <h5>Email</h5><input type="email" name="email" placeholder="Email" required="" /><br>
        <h5>Senha</h5><input type="password" name="senha" placeholder="Senha" required="" /><br>
        <input type="hidden" value="insert" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
    <ul>
        <li><a href="${pageContext.request.contextPath}/upload.jsp">Upload</a></li>
        <li><a href="${pageContext.request.contextPath}/aluno/index.jsp">Aluno</a></li>
        <li><a href="${pageContext.request.contextPath}/funcionario/index.jsp">Funcionario</a></li>
        <li><a href="${pageContext.request.contextPath}/usuario.jsp">Usuário</a></li>
    </ul>
</body>

</html>