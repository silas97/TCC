<%-- 
    Document   : index
    Created on : 25/09/2019, 05:34:55
    Author     : Luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/jquery/jquery.min.js"></script>
        <link href="../resources/css/menu_side_bar.css" rel="stylesheet"/>
        <title>Principal</title>
    </head>
    <body>

     <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <h4>Seja Bem-Vindo(a), ${usuario.nome}</h4>
                </li>
                <li>
                    <a href="#">Documentos</a>
                </li>
                <li>
                    <a href="#">Processos</a>
                </li>
               
                <li>
                    <a href="#">Sair</a>
                </li>
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
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
    </body>
</html>
