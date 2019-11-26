<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.UsuarioDAO" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar Usuarios</title>

</head>

<body>
    <h1>LISTAR USUARIOS</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>nome</td>
            <td>cpf</td>
            <td>cep</td>
            <td>endereco</td>
            <td>bairro</td>
            <td>cidade</td>
            <td>estado</td>
            <td>perfil</td>
            <td colspan="2" style="text-align: center;">Execute</td>
        </tr>
        <c:forEach var="usuario" items="${dao.selectAll()}">
            <tr>
                <td>${usuario.idUsuario}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.cep}</td>
                <td>${usuario.endereco}</td>
                <td>${usuario.bairro}</td>
                <td>${usuario.cidade}</td>
                <td>${usuario.estado}</td>
                <td>${usuario.perfil}</td>
                <form name="usuario" action="${pageContext.request.contextPath}/usuario" method="post">
                    <input type="hidden" value="${usuario.idUsuario}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>