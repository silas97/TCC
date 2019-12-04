<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGPI</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="resources/login_css/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="resources/login_css/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login_css/css/util.css">
        <link rel="stylesheet" type="text/css" href="resources/login_css/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100 bg-primary">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <span class="login100-form-title p-b-41">
                        <h1>SGPI</h1>
                    </span>
                    <span class="login100-form-title p-b-20">
                        <h6>Sistema de Gerenciamento de Processos Internos</h6>
                    </span>
                    <form class="login100-form validate-form p-b-33 p-t-5" name="login" method="post" action="${pageContext.request.contextPath}/login">
                        <div class="text-center" >
                            <img src="resources/images/fafic.png" style="width: 150px;"/>
                        </div>    
                        <div class="wrap-input100 validate-input" data-validate = "O login é obrigatório">
                            <input class="input100" type="text" name="email" placeholder="Login">
                            <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="A senha é obrigatória">
                            <input class="input100" type="password" name="senha" placeholder="Senha">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>

                        <div class="container-login100-form-btn m-t-32">
                            <button class="btn btn-primary btn-lg">
                                Login
                            </button>
                        </div>
                        <input type="hidden" value="autenticacao" name="param" />
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/bootstrap/js/popper.js"></script>
        <script src="resources/login_css/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/daterangepicker/moment.min.js"></script>
        <script src="resources/login_css/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login_css/js/main.js"></script>

    </body>
</html>