<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>ALTERAR Disciplina Cursada</h1>
    <form name="disciplina-cursada" method="post" action="${pageContext.request.contextPath}/disciplinaCursada">
        <h5>Instituição</h5><input type="text" name="instituicaoOrigem" placeholder="Instituição" value="${sDisciplinaCursada.instituicaoOrigem}" required="" />
        <h5>Curso</h5><input type="text" name="curso" placeholder="Curso" value="${sDisciplinaCursada.curso}" required="" />
        <h5>Disciplina</h5><input type="text" name="disciplina" placeholder="Disciplina" value="${sDisciplinaCursada.disciplina}" required="" />
        <h5>Créditos</h5><input type="text" name="creditos" placeholder="Créditos" value="${sDisciplinaCursada.creditos}" required="" />
        <h5>Horas Cursadas</h5><input type="text" name="horasCursadas" placeholder="Horas Cursadas" value="${sDisciplinaCursada.horasCursadas}" required="" />
        <label>${message}</label>
        <input type="hidden" value="${sDisciplinaCursada.idDisciplinaCursada}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>