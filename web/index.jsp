<%-- 
    Document   : index
    Created on : 28-mar-2017, 9:03:06
    Author     : migue
--%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
    </head>
    <% 
        Date date = new Date();
    %>
    <body>
        <h1>Hello World!</h1><form name="myForm" action="menu_usuario.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Usuario: </td>
                        <td><input type="text" name="usuario" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña: </td>
                        <td><input type="password" name="contrasena" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Empresa: </td>
                        <td><select name="empresa">
                                <option></option>
                                <option></option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Departamento: </td>
                        <td><select name="depto">
                                <option></option>
                                <option></option>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Limpiar" name="limpiar" />
            <input type="submit" value="Login" name="login" />
            <input type="submit" value="Crear Usuario" name="crearusuario" />
        </form>
    </body>
</html>
