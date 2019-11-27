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
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/jquery/jquery.min.js"></script>
    <script src="../resources/jquery/drop_down_menu.js"></script>
    <link href="../resources/css/menu_side_bar.css" rel="stylesheet" />
    <title>index</title>
</head>

<body>


    <div id="wrapper">

        <!-- Sidebar -->
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
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">
                            <h5>Ocultar Menu</h5>
                        </a><br><br />
                        <h1>Opções de Menu</h1>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/funcionario/cadastrar-processos.jsp"
                                    class="btn btn-default">Cadastrar Processo</a>
                            </li>
                            <br>
                            <li><a href="${pageContext.request.contextPath}/funcionario/listar-processos.jsp"
                                    class="btn btn-default">Listar Processo</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</body>

</html>