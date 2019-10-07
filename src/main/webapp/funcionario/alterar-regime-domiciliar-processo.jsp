<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoProcessos" class="br.edu.fafic.dao.ProcessosDAO" />
<jsp:useBean id="daoRegimeDomiciliar" class="br.edu.fafic.dao.RegimeDomiciliarDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR CANCELAMENTO MATRICULA PROCESSO</h1>
    <form name="cancelamento-matricula-processo" method="post"
        action="${pageContext.request.contextPath}/regimeDomiciliarProcesso">
        <h3>Processos(usuario/tipo)</h3>
        <select name="idProcessos_FK" required="">
            <c:forEach var="daoProcessos" items="${daoProcessos.selectAll()}">
                <option value="${daoProcessos.idProcessos}">
                    ${daoProcessos.getAluno().getUsuario().getNome()} / ${daoProcessos.tipo}
                </option>
            </c:forEach>
        </select>
        <h3>RegimeDomiciliar</h3>
        <select name="idRegimeDomiciliar_FK" required="">
            <c:forEach var="daoRegimeDomiciliar" items="${daoRegimeDomiciliar.selectAll()}">
                <option value="${daoRegimeDomiciliar.idRegimeDomiciliar}">
                    ${daoRegimeDomiciliar.tipo}
                </option>
            </c:forEach>
        </select>
        <label>${message}</label>
        <input type="hidden" value="${sRegimeDomiciliarProcesso.idRegimeDomiciliarProcesso}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>