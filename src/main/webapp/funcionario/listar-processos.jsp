<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.ProcessosDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.2/popper.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.css"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
                
        <title>SGPI</title>
       
            
    </head>

    <body style="background-color: #0056b3;">

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
                        <th>Aluno</th>
                        <th>Tipo do Processo</th>
                        <th>Arquivos</th>
                        <th colspan="2" class="text-center">Ação</th>
                    </tr>
                </thead>
                <c:forEach var="processos" items="${dao.selectAll()}">
                    <tr>

                        <td>${processos.getAluno().getUsuario().getNome()}</td>
                        <td>${processos.tipo}</td>
                        
                        
                        <td> 
                            <form action="${pageContext.request.contextPath}/openPDF" method="post" target="_blank">
                                <input type="hidden" name="path" value="${dao.pathAquivoByPidProcesso(processos.idProcessos)}"/>
                                <input type="submit" value="Ver Arquivos" class="btn btn-info"/>
                            </form>
                        </td>       
                    <form name="processos" action="${pageContext.request.contextPath}/processos" method="post">
                        <input type="hidden" value="${processos.idProcessos}" name="id" />
                        <input type="hidden" value="${processos.getAluno().getUsuario().getNome()}" name="nome_aluno" />
                        <td style="text-align: center;" ><button type="submit" class="btn btn-info" value="alterar" name="param">alterar</button></td>
                        <td style="text-align: center;" ><button type="submit" class="btn btn-danger" value="apagar" name="param">excluir</button></td>
                    </form>
                    </tr>
                </c:forEach>

            </table>  
        </div>    

        
    </body>

</html>