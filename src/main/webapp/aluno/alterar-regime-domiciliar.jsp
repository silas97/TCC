<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR REGIME DOMICILIAR</h1>
    <form name="regime-domiciliar" method="post" action="${pageContext.request.contextPath}/regimeDomiciliar">
        <h5>Data Inicio</h5>
        <input type="date" name="dataInicio" required="" value="${sRegimeDomiciliar.dataInicio}" />
        <h5>Data Fim</h5>
        <input type="date" name="dataFim" required="" value="${sRegimeDomiciliar.dataFim}" />
        <h5>Tipo</h5>
        <input type="radio" name="tipo" value="atestado" checked>Atestado<br>
        <input type="radio" name="tipo" value="gestante" checked>Gestante<br>
        <h5>Disciplina</h5>
        <select name="idDisciplina_FK">
            <c:forEach var="disciplina" items="${dao.selectAll()}">
                <option value="${disciplina.idDisciplina}">${disciplina.nome}</option>
            </c:forEach>
        </select>
        <label>${message}</label>
        <input type="hidden" value="${sRegimeDomiciliar.idRegimeDomiciliar}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>