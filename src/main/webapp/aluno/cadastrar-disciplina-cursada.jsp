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
    <h1>TELA DE CADASTRO DISCIPLINA CURSADA</h1>
    <form name="disciplina-cursada" method="post" action="${pageContext.request.contextPath}/disciplinaCursada">
        <h5>Instituição</h5><input type="text" name="instituicaoOrigem" placeholder="Instituição" required="" />
        <h5>Curso</h5><input type="text" name="curso" placeholder="Curso" required="" />
        <h5>Disciplina</h5><input type="text" name="disciplina" placeholder="Disciplina" required="" />
        <h5>Créditos</h5><input type="text" name="creditos" placeholder="Créditos" required="" />
        <h5>Horas Cursadas</h5><input type="text" name="horasCursadas" placeholder="Horas Cursadas" required="" />
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>