<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.AlunoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Processos</title>
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
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Usuários</a>
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

            <h2 class="mt-3 text-white">Cadastro de Processos</h2>

            <form  name="consulta_aluno" method="post" action="${pageContext.request.contextPath}/processos">

                <div class="form-group">

                    <div class="card">
                        <div class="card-header">
                            Pesquisar
                        </div>
                        <div class="card-body">
                            <h5 class = ml-1>Matrícula </h5>
                            <input class="form-control" required id="text_matricula" name="matricula_aluno"
                                   style="width: 20em;" type="text" placeholder="Digite a Matrícula do Aluno">

                            <input type="submit"
                                   value="Pesquisar" 
                                   class="btn btn-primary mt-2" >
                            <input type="hidden" name="param" value="consultar_aluno"/>
                        </div>
                    </div>   
                </div>
            </form>

            <form  name="processos" method="post" action="${pageContext.request.contextPath}/processos">

                <div class="form-group mt-5">

                    <div class="card">
                        <div class="card-header">
                            Processo
                        </div>
                        <div class="card-body">
                            <c:choose>
                                <c:when test="${matricula != null}">
                                    <c:if test="${aluno == null}">
                                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                            <strong>Aluno não encontrado!</strong> Verifique se o número de matrícula está correto.
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                    </c:if>
                                    <c:if test="${aluno != null}">
                                        <div class="text-primary">
                                            <h3 class="font-weight-bold" >Aluno: ${aluno.getUsuario().getNome()}</h3>
                                        </div>
                                    </c:if>
                                </c:when>
                            </c:choose >


                        </div>
                        <h5 class = ml-3>Selecione o processo </h5>
                        <div class="radio ml-3">
                            <input class="mr-2" type="radio" name="tipo" value="Dispensa Disciplina" checked>Dispensa Disciplina<br>
                            <input class="mr-2" type="radio" name="tipo" value="Regime Domiciliar">Regime Domiciliar<br>
                            <input class="mr-2" type="radio" name="tipo" value="Cancelamento Matricula">Cancelamento Matricula<br>
                            <label>${message}</label>
                            <input type="hidden" value="cadastrar" name="param" />
                            <input type="submit" value="Continuar" class="btn btn-primary  mt-2 mb-2" />
                        </div>
                    </div>
                </div>  
            </form>


            <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
            <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />
        </div>
    </body>

</html>