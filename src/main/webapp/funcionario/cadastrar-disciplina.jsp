<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.CursoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Curso</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />

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
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/cadastrar-curso.jsp">Cadastrar</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/listar-curso.jsp">Listar Cursos</a>
                                    </div>
                                </li>
                            </div>  
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownDisciplina"  data-toggle="dropdown" >
                                        Disciplinas
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDisciplina">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/cadastrar-disciplina.jsp">Cadastrar</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/listar-disciplina.jsp">Listar Disciplinas</a>
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
                            </div>
                        </ul>


                    </div>
                </nav>
            </div>
            <h2 class="mt-3 text-white">Cadastro de Disciplina</h2>

            <form class="text-white border border-white rounded p-3" name="form_disciplina" method="post" action="${pageContext.request.contextPath}/disciplina">

                <div class="form-row">
                    <div class="form-group col-md-8">
                        <c:if test="${param != null}">
                            <div class="${classe}" role="alert">
                                <strong>${message}</strong> 
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>
                        <label for="input_nome">Nome</label>
                        <input type="text" required name="nome" class="form-control" id="input_nome" placeholder="Nome">
                        <label for="input_creditos">Créditos</label>
                        <input type="text" required name="creditos" class="form-control" id="input_nome" placeholder="Créditos">
                        <label for="input_carga_horaria">Carga Horária</label>
                        <input type="text" required name="cargaHoraria" class="form-control" id="input_nome" placeholder="Carga Horária">
                        <label for="input_nome">Curso</label>
                        <select name="idCurso_FK" class="form-control">
                            <option selected>Selecione...</option>
                            <c:forEach var="curso" items="${dao.selectAll()}">
                                <option value="${curso.idCurso}">${curso.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-light">Cadastrar</button>
                <input type="hidden" name="param" value="cadastrar"/>


            </form>  

            <script src="https://code.jquery.com/jquery-3.3.1.js"
                    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.css"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
    </body>


</html>