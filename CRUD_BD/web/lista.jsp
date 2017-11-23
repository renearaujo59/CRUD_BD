<%-- 
    Document   : lista
    Created on : 14/11/2017, 19:34:37
    Author     : rene_araujo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>
            a {
                color: red;
                font-family: Verdana;
            }
        </style>
    </head>
    
    <body>
        <h1>Lista de produtos:</h1>
        
        <center><table>
            <thead>
            <td>
                Nome
            </td>
            <td>
                Preco
            </td>
            <td>
                Validade
            </td>
            <td>
                Editar
            </td>
            <td>
                Deletar
            </td>
        </thead>
        
        <c:forEach items="${requestScope.lista}" var="prod">
            <tr>
                <td>
                    ${prod.nome}
                </td>
                <td>
                    ${prod.preco}
                </td>
                <td>
                    ${prod.validade}
                </td>                    
                <td>
                    <a class="dif" href="FormEditar?nome=${prod.nome}"> Editar</a>
                </td>
                <td>
                    <a class="dif" href="confirmaDelete.jsp?nome=${prod.nome}"> Deletar</a>
                </td>
            </tr>
        </c:forEach>
    </table></center>
<br/>

<center><input type="button" value="Voltar" onClick="history.go(-1)">
<form method="get" action="index.html"><button type="submit">Home</button></center>

</body>
</html>
