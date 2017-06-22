<%-- 
    Document   : nuevo
    Created on : 22-jun-2017, 12:40:43
    Author     : jmartinezlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Usuario</h1>
        <form action="nuevo" method="post">
            <div>
                Username: <input type="text" name="username"/>
            </div>
            <div>
                Password: <input type="password" name="password"/>
            </div>
            
            <br><input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
