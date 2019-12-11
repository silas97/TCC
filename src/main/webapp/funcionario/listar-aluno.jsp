<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.AlunoDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.css"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/menu_side_bar.css" rel="stylesheet" />
        <title>SGPI</title>
    </head>

    <body style="background-color: #0056b3">
        <div class="container">
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
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/cadastrar-curso.jsp">Cadastrar</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/listar-curso.jsp">Listar Cursos</a>
                                    </div>
                                </li>
                            </div>  
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownDisciplina"  data-toggle="dropdown" >
                                        Disciplinas
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownDisciplina">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/disciplina.jsp">Cadastrar</a>
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
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/listar-processos.jsp">Listar Processo</a>
                                    </div>
                                </li>
                            </div>
                            <div class="dropdown float-right">
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


            <h2 class="mt-3 text-white">Lista de Alunos</h2>
            <table class="table table-light table-hover rounded">
                <thead class="thead-light rounded">  
                    <tr>
                        <th>Mátricula</th>
                        <th>Nome</th>
                        <th>Curso</th>
                        <th colspan="2" class="text-center">Ação</th>
                    </tr>
                </thead>
                <c:forEach var="aluno" items="${dao.selectAll()}">
                    <tr>
                        <td>${aluno.matricula}</td>
                        <td>${aluno.usuario.nome}</td>
                        <td>${aluno.curso.nome}</td>
                    <form name="aluno" action="${pageContext.request.contextPath}/aluno" method="post">
                        <input type="hidden" value="${curso.idAluno}" name="id" />
                        <td style="text-align: center;" ><button type="button" class="btn btn-info" value="alterar" name="param">alterar</button></td>
                        <td style="text-align: center;" ><button type="button" class="btn btn-danger" value="apagar" name="param">excluir</button></td>
                     </form>
                    </tr>
                </c:forEach>
            </table>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.js"
                    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.css"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>    
    </body>


</html>