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
    <h1>TELA DE CADASTRO USUARIO</h1>
    <form name="usuario" method="post" action="${pageContext.request.contextPath}/usuario">
        <h5>Nome</h5><input type="text" name="nome" placeholder="Nome" required="" />
        <h5>CPF</h5><input type="text" name="cpf" placeholder="CPF" required="" />
        <h5>CEP</h5><input type="text" name="cep" placeholder="CEP" required="" />
        <h5>Endereço</h5><input type="text" name="endereco" placeholder="Endereço" required="" />
        <h5>Bairro</h5><input type="text" name="bairro" placeholder="Bairro" required="" />
        <h5>Cidade</h5><input type="text" name="cidade" placeholder="Cidade" required="" />
        <h5>Estado</h5><input type="text" name="estado" placeholder="Estado" required="" />
        <h5>Perfil</h5><select name="perfil" id="perfil-usuario">
            <option value="Aluno">Aluno</option>
            <option value="Funcionario">Funcionario</option>
        </select>
        <label>${message}</label>
        <input type="hidden" value="cadastrar" name="param" />
        <input type="submit" value="Cadastrar" class="primary" />
    </form>
</body>

</html>