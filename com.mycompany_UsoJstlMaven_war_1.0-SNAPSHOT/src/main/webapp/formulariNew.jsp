<%-- 
    Document   : formulariNew
    Created on : 15-jun-2017, 8:43:42
    Author     : jmartinezlo
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<jsp:useBean id="persona" scope="page" class="beans.Persona" />
<jsp:setProperty name="persona" property="nombre" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva Persona Wiii</h1>
        <form method="post">
            <input type="text" name="nombre" placeholder="Nombre"/><br><br>
            <input type="submit" value="Crear"/>
        </form>
        <c:if test="${!empty persona.nombre}">
            <sql:transaction dataSource="jdbc/sun-appserv-samples">
                <sql:update var="count" sql="INSERT INTO PERSONA VALUES (60, ?)">
                    <sql:param value="${persona.nombre}"/>
                </sql:update>
            </sql:transaction>
            Has creado una persona:
            - Nombre: <jsp:getProperty name="persona" property="nombre"/>
        </c:if>
        <br><br>
        <a href="primera.jsp">Tornar</a>
    </body>
</html>
