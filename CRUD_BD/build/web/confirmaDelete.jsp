<%-- 
    Document   : confirmaDelete
    Created on : 14/11/2017, 19:54:13
    Author     : rene_araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacao de Exclusao</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <h1>Tem certeza que quer deletar ${param.nome}?</h1>

        <center><a href="Deletar?nome=${param.nome}">Sim</a>
        /  /
        <a href="" onclick="window.history.go(-1); return false;">Nao</a></center>

    </body>
</html>
