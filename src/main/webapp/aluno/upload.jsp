<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoDisciplinaCursada" class="br.edu.fafic.dao.DisciplinaCursadaDAO"/>
<jsp:useBean id="daoDisciplina" class="br.edu.fafic.dao.DisciplinaDAO"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Upload</title>
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
                <div class="col-sm-6">
                    <h2 class="mt-3 text-white">Disciplinas Ofertadas</h2>
                    <table class="table table-light table-hover rounded">
                        <thead class="thead-light rounded">  
                            <tr>
                                <th>Disciplina</th>
                                <th>Carga Horária</th>
                                <th>Créditos</th>
                               
                            </tr>
                        </thead>
                        <c:forEach var="disciplina" items="${disOfertadas}">
                            <tr>
                                <td>${disciplina.nome}</td>
                                <td>${disciplina.cargaHoraria}</td>
                                <td>${disciplina.creditos}</td>
                            </tr>
                        </c:forEach>
                    </table>          

                </div>
                <div class="col-sm-6">
                    <h2 class="mt-3 text-white">Disciplinas Cursadas</h2>
                    <table class="table table-light table-hover rounded">
                        <thead class="thead-light rounded">  
                            <tr>
                                <th>Disciplina</th>
                                <th>Carga Horária</th>
                                <th>Créditos</th>
                               
                            </tr>
                        </thead>
                        <c:forEach var="disciplina" items="${disCursadas}">
                            <tr>
                                <td>${disciplina.disciplina}</td>
                                <td>${disciplina.horasCursadas}</td>
                                <td>${disciplina.creditos}</td>
                            </tr>
                        </c:forEach> 
                        
                    </table>          

                </div>
            </div>                          

            <h2 class="mt-3 text-white">Upload de arquivos</h2>
            <div class="card mt-3 mb-2">
                <h5 class="card-header text-info">Envio de Arquivos</h5>
                <div class="card-body">
                    <form name="upload" method="post" enctype="multipart/form-data" action="upload">

                        <h5>Arquivo</h5><input class="btn btn-info mb-4" type="file" name="file" id="file"/><br>
                        <input class="btn btn-info mb-2" type="submit" value="Enviar"/>
                        <input type="hidden" value="${id_processo}" name="id_processo"/>
                    </form>
                </div>
            </div> 


            <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
            <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
            <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />


            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    </body>
</html>