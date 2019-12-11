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
                    <h5 class="mt-2" style="color: #0056b3"><b>SGPI</b></h5>

                    <div class="collapse navbar-collapse ml-3" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <div class="dropdown">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#" id="navbarDropdownCursos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Cursos
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownCursos">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/funcionario/curso.jsp">Cadastrar</a>
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
                        </ul>
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
                                            <a class="dropdown-item" href="./index.jsp">Sair</a>
                                        </form>
                                    </div>
                                </li>
                            </div>
                        </ul>


                    </div>

                </nav>
            </div>


    <!-- Card -->
    <div class="card  mt-3 ">

        <!-- Content -->
        <div class="card-image especial" style="height: 400px;">
            <div class="card-body ">

            </div>

        </div>
        <div class="card-footer">
            <p class="card-text">Olá, ${usuario.nome}. Seja bem vindo ao SGPI, aqui você poderá gerenciar processos como: Dispensa de Disciplina, Regime Especial e Cancelamento de Matrículas </p>
        </div>  
        <!-- Content -->
    </div>
    <!-- Card -->                        

</div>   



<!--        <div id="wrapper">

             Sidebar 
            <div id="sidebar-wrapper">
                <ul class="nav navbar-nav">
                    <div style="text-align: center">
                        <div style="border-radius: 15px 15px 15px 15px">
                            <h4>Sistema de Gerenciamento de Processos Internos</h4>
                        </div>
                    </div>
                    <br>
                    <div style="text-align: center;">
                        <li class="menu-item dropdown">
                            <h4 style="margin-left: 14px;">Seja Bem-Vindo(a), ${usuario.nome}</h4>
                        </li>


                        <br><br>
                        <div style="text-align: center; color: #ffffff">
                            <h2>Menu</h2>
                        </div>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/funcionario/curso.jsp">
                                <h4>Curso</h4>
                            </a></li>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/funcionario/disciplina.jsp">
                                <h4>Disciplina</h4>
                            </a></li>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/funcionario/turma.jsp">
                                <h4>Turma</h4>
                            </a></li>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/funcionario/usuario.jsp">
                                <h4>Usuários</h4>
                            </a></li>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/funcionario/processos.jsp">
                                <h4>Processos</h4>
                            </a></li>
                        <br>
                        <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/login?param=logout">
                                <h4>Sair</h4>
                            </a></li>
                    </div>
                </ul>


            </div>
             /#sidebar-wrapper 

             Page Content 
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">
                                <h5>Ocultar Menu</h5>
                            </a><br><br />
                            <p>Acesse as funcionalidades do sistema no menu ao lado</p>

                        </div>
                    </div>
                </div>
            </div>
             /#page-content-wrapper 

        </div>-->
<!-- /#wrapper -->
<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.css"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/drop_down_menu.js"></script> 
</body>

</html>