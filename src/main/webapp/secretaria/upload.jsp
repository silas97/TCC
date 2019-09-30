<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/css/bootstrap.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/js/bootbox.min.js"></script>
        <script src="../resources/js/bootbox.locales.min.js"></script>
        <title>Sistema</title>

    </head>

    <body>

        <div class="panel-body">
         <h1>Gerenciamento de Documentos</h1>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Lista de Documentos 
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <tr>
                            <td style="width: 200px;"><b>Documento</b></td>
                            <td style="width: 200px;"><b>Visualizar</b></td>
                        </tr> 
                        <c:forEach  items="${documentos}" var="documento">
                            <tr>
                                <td>${documento.tipo}</td>
                                <td>Visualizar</td>
                            </tr>
                        </c:forEach>
                    </table> <br/><br/> 
                </div>
            </div>     

            <form method="post" id="upload" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload">
                <h5>Arquivo</h5><input type="file" name="file" id="file"/><br>
                <div class="dropdown" >  

                    <h5>Tipo</h5>
                    <select name="tipo" id="tipo">
                        <option value=""></option>
                        <option value="dispensa de disciplina">Dispensa de Disciplina(s)</option>
                        <option value="regime domiciliar">Regime Domiciliar</option>
                    </select>

                    <input type="submit" value="Enviar"/>
                </div>
            </form>
            <label>${message}</label>

        </div>    
    </body>

</html>