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
        <link href="../resources/css/bootstrap.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/js/bootbox.min.js"></script>
        <script src="../resources/js/bootbox.locales.min.js"></script>
        <title>Sistema</title>
    </head>

    <body>
        <h1>Lista de Documentos Disponíveis</h1>
        <form method="post" id="upload" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload">
            <h5>Arquivo</h5><input type="file" name="file" id="file"/><br>
            
            <h5>Tipo</h5>
            <select name="tipo" id="tipo">
                <option value=""></option>
                <option value="dispensa de disciplina">Dispensa de Disciplina(s)</option>
                <option value="regime domiciliar">Regime Domiciliar</option>
            </select>
                          
            <input type="submit" value="Enviar"/>
        </form>
        <label>${message}</label>
    </body>
    
</html>