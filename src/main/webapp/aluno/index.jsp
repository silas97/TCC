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
        <link href="../resources/css/menu_side_bar.css" rel="stylesheet"/>
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
                    <li class="menu-item dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><h4>Dispensa de Disciplina</h4></a>
                        <ul class="dropdown-menu">
                            <li class="menu-item dropdown dropdown-submenu">
                                <a href="${pageContext.request.contextPath}/aluno/disciplina-cursada.jsp" class="dropdown-toggle" data-toggle="dropdown">Disciplina(s) Cursada(s)</a>
                                <a href="${pageContext.request.contextPath}/aluno/dispensa-disciplina.jsp" class="dropdown-toggle" data-toggle="dropdown">Disciplina(s) a ser(em) Dispensada(s)</a>
                            </li>
                        </ul>
                    </li>
                    <br>
                    <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/aluno/cancelamento-matricula.jsp"><h4>Cancelamento de Matrícula</h4></a></li>
                    <br>
                    <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/aluno/regime-domiciliar.jsp"><h4>Regime Domiciliar</h4></a></li>
                    <br>
                    <li class="sidebar-brand"><a href="${pageContext.request.contextPath}/login?param=logout"><h4>Sair</h4></a></li>
                   </div> 
                 </ul>
                 
                                   
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><h5>Ocultar Menu</h5></a><br><br/>
                            <p>Acesse as funcionalidades do sistema no menu ao lado</p>

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