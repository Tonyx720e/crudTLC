<%-- 
    Document   : proveedor
    Created on : Nov 7, 2024, 9:04:39 PM
    Author     : luisa
--%>

<%@page import="dominiosJavaBeans.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de los Proveedores Existentes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="h1 text-center">Proveedores</h1>
            <form action="ServletControladorProveedor"  method="POST">
                <button type="summit"></button>
            </form>
            <ul class="list-group w-50 mx-auto">
                <%
                    ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>)request.getAttribute("proveedores");
                    for(Proveedor pr : proveedores){
                %>
                <li class="list-group-item list-group-item-action fs-4">
                    <a href="#" class="link-info link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover me-3 fs-6">Modificar</a>
                    <a href="#" class="link-darger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover me-5 fs-6">Eliminar</a>
                    <p class="d-inline ms-5"><%= pr.getNombre() %></p>
                    
                </li>
                <% } %>
            </ul>
        </div>
    </body>
</html>
