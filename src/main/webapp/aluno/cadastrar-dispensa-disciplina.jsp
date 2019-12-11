<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="daoAluno" class="br.edu.fafic.dao.AlunoDAO" />
<jsp:useBean id="daoDisciplinaCursada" class="br.edu.fafic.dao.DisciplinaCursadaDAO" />
<jsp:useBean id="daoDisciplina" class="br.edu.fafic.dao.DisciplinaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css">
            .filter-option-inner-inner{
                content: "Selecione..." !important;
            }
        </style>

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

                            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                                <ul class="navbar-nav">
                                    <div class="dropdown ">
                                        <li class="nav-item active " >
                                            <a class="nav-link border border rounded" href="#" id="navbarDropdownSair" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <img src="${pageContext.request.contextPath}/resources/images/icon.png"/> <b style="color: #0056b3">${usuario.nome}</b>
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdownSair">
                                                <form>
                                                    <a class="dropdown-item" href="${pageContext.request.contextPath}">Sair</a>
                                                </form>
                                            </div>
                                        </li>
                                    </div>
                                </ul>


                            </div>


                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-6">
                    <h2 class="mt-3 text-white">Cadastro de Dispensa de Disciplinas</h2>
                </div>
                <div class="col-6 mt-3" style="text-align: right">

                </div>

            </div>  
            <div id="loading" class="spinner-border text-info" role="status">
                <span class="sr-only">Loading...</span>
            </div>                                    


            <form class="text-white border border-white rounded p-3" name="aluno" method="post" action="${pageContext.request.contextPath}/dispensaDisciplina">
                <c:if test="${param != null}">
                    <div class="${classe}" role="alert">
                        <strong>${message}</strong> 
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="disiciplina_cursada">Disciplina Cursada</label>
                        <select id="disiciplina_cursada" name="disciplina_cursada" class="form-control selectpicker" multiple>

                            <c:forEach var="disciplinaCursada" items="${disciplinasCursadasDoAluno}">
                                <option value="${disciplinaCursada.idDisciplinaCursada}">${disciplinaCursada.disciplina}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="disciplina_ofertada">Disciplina Ofertada</label>
                        <select id="disciplina_ofertada" name="disciplina_ofertada" class="form-control selectpicker" multiple>

                            <c:forEach var="disciplina" items="${daoDisciplina.selectAll()}">
                                <option value="${disciplina.idDisciplina}">${disciplina.nome}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>


                <button type="submit" id="continuar" class="btn btn-light">Continuar</button>
                <input type="hidden" name="param" value="continuar"/>


            </form>    
              

        </div>          
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/umd/popper.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        
        <script>
            $("#continuar").on("loading", "click", function(){
                    $("#loading").show();
            });
        </script>



    </body>

</html>