<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.RegimeDomiciliarDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>Listar REGIME DOMICILIAR</title>

</head>

<body>
    <h1>LISTAR REGIME DOMICILIAR</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Data Inicio</td>
            <td>Data Fim</td>
            <td>Tipo</td>
            <td>Disciplina</td>
            <td colspan="2">Execute</td>
        </tr>
        <c:forEach var="regimeDomiciliar" items="${dao.selectAll()}">
            <tr>
                <td>${regimeDomiciliar.idRegimeDomiciliar}</td>
                <td>${regimeDomiciliar.dataInicio}</td>
                <td>${regimeDomiciliar.dataFim}</td>
                <td>${regimeDomiciliar.tipo}</td>
                <td>${regimeDomiciliar.getDisciplina().getNome()}</td>
                <form name="regime-domiciliar" action="${pageContext.request.contextPath}/regimeDomiciliar" method="post">
                    <input type="hidden" value="${regimeDomiciliar.idRegimeDomiciliar}" name="id" />
                    <td><input type="submit" value="alterar" name="param"></td>
                    <td><input type="submit" value="apagar" name="param"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>

</html>