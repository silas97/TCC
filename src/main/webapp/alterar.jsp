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
    <h1>ALTERAR USUARIO</h1>
    <form name="usuario" method="post" action="${pageContext.request.contextPath}/usuario">
        <h5>Nome</h5><input type="text" name="nome" placeholder="Nome" value="${user.nome}" required="" />
        <h5>CPF</h5><input type="text" name="cpf" placeholder="CPF" value="${user.cpf}" required="" />
        <h5>CEP</h5><input type="text" name="cep" placeholder="CEP" value="${user.cep}" required="" />
        <h5>Endereço</h5><input type="text" name="endereco" placeholder="Endereço" value="${user.endereco}" required="" />
        <h5>Bairro</h5><input type="text" name="bairro" placeholder="Bairro" value="${user.bairro}" required="" />
        <h5>Cidade</h5><input type="text" name="cidade" placeholder="Cidade" value="${user.cidade}" required="" />
        <h5>Estado</h5><input type="text" name="estado" placeholder="Estado" value="${user.estado}" required="" />
        <h5>Perfil</h5><select name="perfil" id="perfil-usuario">
            <option value="Aluno">Aluno</option>
            <option value="Funcionario">Funcionario</option>
        </select>
        <label>${message}</label>
        <input type="hidden" value="${user.idUsuario}" name="id" />
        <input type="hidden" value="update" name="param" />
        <input type="submit" value="Alterar" class="primary" />
    </form>
</body>

</html>