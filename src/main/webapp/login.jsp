<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoUsuario" class="br.edu.fafic.dao.UsuarioDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>JSP Page</title>
    <link href="resources/css/login.css" rel="stylesheet" />
</head>

<body>
    <div class="wrapper">
        <div id="formContent"><br /><br />
            <img src="resources/images/fafic.png" alt="Fafic" width=150 height=50>
            <h3>Sistema de Gerenciamento de Processos Internos</h3>
            <form name="login" method="post" action="${pageContext.request.contextPath}/login">
                <input type="email" name="email" placeholder="Email" required="" /><br><br />
                <input type="password" name="senha" placeholder="Senha" required="" /><br><br>
                <h3>Usuario</h3>
                <select name="idUsuario_FK" required="">
                    <c:forEach var="usuario" items="${daoUsuario.selectAll()}">
                        <option value="${usuario.idUsuario}">${usuario.nome}</option>
                    </c:forEach>
                </select>
                <input type="hidden" value="insert" name="param" />
                <input type="submit" value="Adicionar" />
            </form>
        </div>
    </div>
    <br />

</html>