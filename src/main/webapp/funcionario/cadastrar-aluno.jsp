<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoCurso" class="br.edu.fafic.dao.CursoDAO" />
<jsp:useBean id="daoUsuario" class="br.edu.fafic.dao.UsuarioDAO" />
<jsp:useBean id="util" class="br.edu.fafic.utils.Util" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Cadastro de Aluno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body style="background-color: #0056b3">
        <div class="container" >

            <div>
                <nav class="navbar navbar-expand-lg navbar-light bg-light mt-2 rounded">
                    <h5 class="mt-2">SGPI</h5>

                    <div class="collapse navbar-collapse ml-3" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownCursos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Cursos
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownCursos">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Cursos</a>
                                    </div>
                                </li>
                            </div>  
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownDisciplina"  data-toggle="dropdown" >
                                        Disciplinas
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDisciplina">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Disciplinas</a>
                                    </div>
                                </li>
                            </div>

                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownTurma" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Turmas
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownTurma">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Turmas</a>
                                    </div>
                                </li>
                            </div>

                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link " href="#" id="navbarDropdownUsuario" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Usuários
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownUsuario">
                                        <a class="dropdown-item" href="#">Listar Usuários</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/cadastrar-usuario.jsp">Funcionários</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/cadastrar-aluno.jsp">Alunos</a>
                                    </div>
                                </li>
                            </div>
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownProcesso" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Processos
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownProcesso">
                                        <a class="dropdown-item"  href="${pageContext.request.contextPath}/funcionario/cadastrar-processos.jsp?matricula_aluno=null">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Processo</a>
                                    </div>
                                </li>
                            </div>
                            <div class="dropdown">
                                <li class="nav-item active" aria-labelledby="navbarDropdownSair">
                                    <a class="nav-link" id="navbarDropdownSair" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Seja Bem-Vindo(a), ${usuario.nome}
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownSair">
                                        <form>
                                            <a class="dropdown-item" href="#">Sair</a>
                                        </form>
                                    </div>
                                </li>
                            </div>
                        </ul>


                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-6">
                    <h2 class="mt-3 text-white">Cadastro de Aluno</h2>
                </div>
                <div class="col-6 mt-3" style="text-align: right">
                    <form action="${pageContext.request.contextPath}/funcionario/listar-aluno.jsp">
                        <button type="submit" class="btn btn-light">Ver todos</button>
                    </form>

                </div>

            </div>

            <form class="text-white border border-white rounded p-3" name="aluno" method="post" action="${pageContext.request.contextPath}/aluno">
                <c:if test="${param != null}">
                    <div class="${classe}" role="alert">
                        <strong>${message}</strong> 
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="input_nome">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="matricula">Matrícula</label>
                        <input type="text" class="form-control" name="matricula" id="matricula" placeholder="Matrícula">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="input-cpf">CPF</label>
                        <input type="text" class="form-control" name="cpf" id="cpf" placeholder="CPF">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="logradouro">Rua</label>
                        <input type="text" class="form-control" name="rua" id="logradouro" placeholder="Rua, Logradouro">
                    </div>
                    <div class="form-group col-md-1">
                        <label for="numero">Nº</label>
                        <input type="text" class="form-control" name="numero" id="numero" placeholder="Nº">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="bairro">Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Bairro">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento" placeholder="Apartamento, sala">
                    </div>
                </div>    

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" name="cidade" id="inputCity">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputState">Estado</label>
                        <select name="estado" id="inputState" class="form-control">
                            <option selected>Selecione...</option>
                            <c:forEach var="estado" items="${util.nomesEstados}">
                                <option value="${estado}">${estado}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control" id="cep" name="cep">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="select-curso">Curso</label>
                        <select id="select-curso" name="idCurso_FK" class="form-control">
                            <option selected>Selecione...</option>
                            <c:forEach var="curso" items="${daoCurso.selectAll()}">
                                <option value="${curso.idCurso}">${curso.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-light">Cadastrar</button>
                <input type="hidden" name="param" value="cadastrar"/>


            </form>  


            <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
            <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />




    </body>

</html>