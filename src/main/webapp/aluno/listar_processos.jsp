<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DispensaDisciplinaProcessoDAO" />
<jsp:useBean id="daoAluno" class="br.edu.fafic.dao.AlunoDAO" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Módulo do Aluno</title>
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
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/aluno/cadastrar-disciplina-cursada.jsp">Cadastrar Disciplinas Cursadas</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/dispensaDisciplina">Solicitar Dispensa de Disciplinas</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/aluno/listar_processos.jsp?param=listar">Listar Processos</a>
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
                            </nav>
                    </div>
                   <h2 class="mt-3 text-white">Lista de Processos</h2>
                            
                            <table class="table table-light table-hover rounded">
                                <thead class="thead-light rounded">  
                                    <tr>

                                        <th>Tipo do Processo</th>
                                        <th>Data da Solicitação</th>
                                        <th>Status</th>
                                        

                                    </tr>
                                </thead>
                                <c:forEach var="processo" items="${processos}">
                                    <tr>
                                    <td>${processo.processos.tipo}</td>
                                    <td>${processo.dataProcesso}</td>
                                    <td>${processo.status}</td>
                                </tr>
                                </c:forEach>      
                                


                            </table>      

            </div>                                 
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