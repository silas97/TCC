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
    <title>Upload</title>
</head>

<body>
    <h1>Upload de arquivos</h1>
    <form name="upload" method="post" enctype="multipart/form-data" action="upload">
        <h5>Arquivo</h5><input type="file" name="file" id="file"/><br>
        <input type="submit" value="Enviar"/>
    </form>
    <label>${message}</label>
</body>

</html>