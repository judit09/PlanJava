<%-- 
    Document   : usoLista
    Created on : 15-jun-2017, 8:25:16
    Author     : jmartinezlo
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista personas</h1>
        <sql:setDataSource  dataSource="jdbc/sun-appserv-samples"/>
        <sql:query maxRows="10" var="personas" sql="SELECT ID, NOMBRE FROM PERSONA ORDER BY ID"/>
        <ul>
            <c:forEach begin="0" var="fila" items="${personas.rowsByIndex}">
                <li>Identificador ${fila[0]}. Nombre ${fila[1]}</li>
            </c:forEach>
        </ul>
    </body>
</html>
