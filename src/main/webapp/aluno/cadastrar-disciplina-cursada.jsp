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
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="../resources/css/main_form.css" rel="stylesheet" media="all">
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/jquery/jquery.min.js"></script>

    <title>Disciplina Cursada</title>
</head>

<body style="background-color: #286090">

    <form name="disciplina-cursada" method="post" action="${pageContext.request.contextPath}/disciplinaCursada">
        <div style="background-color: #286090">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title" style="text-align: center">Cadastro de Disciplina Cursada</h2>

                        <div class="row row-space">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label class="font-form">Instituição</label>
                                    <input class="input--style-4" name="instituicaoOrigem" required="">
                                </div>
                            </div>

                        </div>
                        <div class="row row-space">
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <label class="font-form">Curso</label>
                                    <input class="input--style-4" name="curso" required="">
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="input-group">
                                    <label class="font-form">Disciplina</label>
                                    <input class="input--style-4" name="disciplina" required="">
                                </div>
                            </div>
                            <div class="col-sm-6">

                                <div class="input-group">
                                    <label class="font-form">Créditos</label>
                                    <input class="input--style-4" type="text" name="creditos" required="">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <label class="font-form">Horas Cursadas</label>
                                    <input class="input--style-4" type="text" name="horas" required="">
                                </div>


                            </div>
                        </div>
                        <label>${message}</label>
                        <div class="p-t-15">
                                <input type="hidden" value="cadastrar" name="param" />
                            <button class="btn btn--blue btn--radius-2" type="submit">Cadastrar</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- Jquery JS-->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="../resources/vendor/select2/select2.min.js"></script>
    <script src="../resources/vendor/datepicker/moment.min.js"></script>
    <script src="../resources/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="../resources/js/global.js"></script>

</body>

</html>