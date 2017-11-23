<%-- 
    Document   : editar
    Created on : 14/11/2017, 20:07:43
    Author     : rene_araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    <body>
        <form action="Editar">
            <p>Nome: <input type="text" name="nome" value="${prod.nome}" readonly="readonly"></p>
            <p>Preco: <input type="text" name="preco" value="${prod.preco}"></p>
            <p>Validade: <input type="text" name="validade" value="${prod.validade}"></p>
            <center><input type="button" value="Voltar" onClick="history.go(-1)">
                <input type="submit" value="Salvar"></center>
        </form>
            
    </body>
</html>
