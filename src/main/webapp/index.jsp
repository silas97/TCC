<%-- 
    Document   : index
    Created on : 02/09/2019, 15:55:44
    Author     : Silas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>JSP Page</title>
        <link href="resources/css/login.css" rel="stylesheet"/>
    </head>

    <body>
        <div class="wrapper">
            <div id="formContent"><br/><br/> 
                    <img src="resources/images/fafic.png" alt="Fafic" width=150 height=50>
                    <h3>Sistema de Gerenciamento de Processos Internos</h3>
                 <form name="login" method="post" action="${pageContext.request.contextPath}/login">
                    <input type="email" name="email" placeholder="Email" required="" /><br><br/>
                    <input type="password" name="senha" placeholder="Senha" required=""/><br><br>
                    <input type="hidden" value="autenticacao" name="param" />
                    <input type="submit" value="Acessar"  />
                 </form>
            </div>
        </div>
    <br/>

</html>