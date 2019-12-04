<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Dispensa de Disciplina</title>
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
                                        Regime Domiciliar
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownCursos">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Processos</a>
                                    </div>
                                </li>
                            </div>  
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownDisciplina"  data-toggle="dropdown" >
                                        Dispensa de Disciplinas
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDisciplina">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Processos</a>
                                    </div>
                                </li>
                            </div>

                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownTurma" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Cancelamento de Matrícula
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownTurma">
                                        <a class="dropdown-item" href="#">Cadastrar</a>
                                        <a class="dropdown-item" href="#">Listar Processos</a>
                                    </div>
                                </li>
                            </div>

                            <div class="dropdown" style="text-align: right">
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
                    <h2 class="mt-3 text-white">Cadastro de Disciplinas Cursadas</h2>
                </div>
                <div class="col-6 mt-3" style="text-align: right">
                    
                </div>

            </div>                        


            <form class="text-white border border-white rounded p-3" name="aluno" method="post" action="${pageContext.request.contextPath}/disciplinaCursada">
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
                        <label for="input_nome">Instituição</label>
                        <input type="text" class="form-control" name="instituicaoOrigem" id="instituicaoOrigem" placeholder="Instituição">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="curso">Curso</label>
                        <input type="text" class="form-control" name="curso" id="curso" placeholder="Curso">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="disciplina">Disciplina</label>
                        <input type="text" class="form-control" name="disciplina" id="disciplina" placeholder="Disciplina">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="creditos">Créditos</label>
                        <input type="text" class="form-control" name="creditos" id="creditos" placeholder="Créditos">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="horasCursadas">Horas Cursadas</label>
                        <input type="text" class="form-control" name="horasCursadas" id="horasCursadas" placeholder="Horas Cursadas">
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