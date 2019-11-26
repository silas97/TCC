<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.LoginDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar LOGIN</title>

</head>

<body>
    <h1>LISTAR TURMAS</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>email</td>
            <td>senha</td>
            <td>Usuario</td>
            <td colspan="2" style="text-align: center;">Execute</td>
        </tr>
        <c:forEach var="login" items="${dao.selectAll()}">
            <tr>
                <td>${login.idLogin}</td>
                <td>${login.email}</td>
                <td>${login.senha}</td>
                <td>${login.getUsuario().getIdLogin()}</td>
                <form name="login" method="post" action="${pageContext.request.contextPath}/login">
                    <input type="hidden" value="${login.idLogin}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>