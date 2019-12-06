<%-- 
    Document   : login
    Created on : 14/03/2019, 15:57:07
    Author     : silas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.edu.fafic.dao.DisciplinaCursadaDAO" />
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Disciplinas Cursadas</title>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../resources/vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="../resources/vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="../resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" type="text/css" href="../resources/css/util_table.css">
        <link rel="stylesheet" type="text/css" href="../resources/css/main_table.css">

    </head>

    <body>
        <h1>LISTAR DISCIPLINA CURSADA</h1>
     
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100 ver1 m-b-110">
                        <div class="table100-head">    
                            <table class="table">
                                <thead class="thead-light"  >
                                    <tr class="row100 head">
                                        <td>Instituição de Origem</td>
                                        <td>Curso</td>
                                        <td>Disciplina</td>
                                        <td>Créditos</td>
                                        <td>Horas Cursadas</td>
                                        <td colspan="2">Ação</td>
                                    </tr>
                                </thead>
                                <c:forEach var="disciplinaCursada" items="${disciplinasCursadas}">
                                    <tr class="row100 body">
                                        <td>${disciplinaCursada.instituicaoOrigem}</td>
                                        <td>${disciplinaCursada.curso}</td>
                                        <td>${disciplinaCursada.disciplina}</td>
                                        <td>${disciplinaCursada.creditos}</td>
                                        <td>${disciplinaCursada.horasCursadas}</td>
                                    <form name="disciplina-cursada" action="${pageContext.request.contextPath}/disciplinaCursada" method="post">
                                        <input type="hidden" value="${disciplinaCursada.idDisciplinaCursada}" name="id" />
                                        <td><input type="submit" value="alterar" name="param"></td>
                                        <td><input type="submit" value="apagar" name="param"></td>
                                    </form>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
             </div>
       
   </body>

  </html>