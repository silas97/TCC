<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoProcessos" class="br.edu.fafic.dao.ProcessosDAO" />
<jsp:useBean id="daoDispensaDisciplina" class="br.edu.fafic.dao.DispensaDisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR DISPENSA DISCIPLINA PROCESSO</h1>
    <form name="dispensa-disciplina-processo" method="post"
        action="${pageContext.request.contextPath}/dispensaDisciplinaProcesso">
        <h3>Processos(usuario/tipo)</h3>
        <select name="idProcessos_FK" required="">
            <c:forEach var="daoProcessos" items="${daoProcessos.selectAll()}">
                <option value="${daoProcessos.idProcessos}">
                    ${daoProcessos.getAluno().getUsuario().getNome()} / ${daoProcessos.tipo}
                </option>
            </c:forEach>
        </select>
        <h3>DispensaDisciplina</h3>
        <select name="idDispensaDisciplina_FK" required="">
            <c:forEach var="daoDispensaDisciplina" items="${daoDispensaDisciplina.selectAll()}">
                <option value="${daoDispensaDisciplina.idDispensaDisciplina}">
                    ${daoDispensaDisciplina.idDispensaDisciplina}
                </option>
            </c:forEach>
        </select>
        <label>${message}</label>
        <input type="hidden" value="${sDispensaDisciplinaProcesso.idDispensaDisciplinaProcesso}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>