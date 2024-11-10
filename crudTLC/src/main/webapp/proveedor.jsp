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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="IncludeNav.jsp"/>
            <h1 class="h1 text-center py-4 bg-primary text-light mb-0">Proveedores</h1>
            <div class="bg-success py-4">
                <h2 class="h2 text-center mb-3 text-light">Ingresar Nuevo Proveedores</h2>
                <form action="ServletControladorProveedor"  method="POST" class="text-center w-50 mx-auto">
                    <div class="input-group flex-nowrap">                 
                        <input type="text" class="form-control" placeholder="Nuevo Proveedor" aria-label="Nuevo Proveerdor" aria-describedby="addon-wrapping" name="nombre">
                    </div>
                    <button type="summit" class="btn btn-warning mt-2">Agregar</button>
                </form>
            </div>
            <div>
                <h2 class="h2 text-center mt-4">Lista de Proveedores</h2>
                <ul class="list-group w-50 mx-auto">
                    <%
                        ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) request.getAttribute("proveedores");
                        int id;
                        String newNombre;
                        String parameter;
                        for (Proveedor pr : proveedores) {
                            id = pr.getIdproveedor();
                            newNombre = pr.getNombre().replace(" ", "_");
                            parameter = "?id=" + id + "&newNombre=" + newNombre;
                    %>
                    <li class="list-group-item list-group-item-action fs-4">
                        <a href="ServletUpdateProveedor<%= parameter%>" class="link-info link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover me-3 fs-6">Modificar</a>
                        <a href="ServletDeleteProveedor<%= parameter%>" class="link-darger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover me-5 fs-6">Eliminar</a>
                        <p class="d-inline ms-5"><%= pr.getNombre()%></p>

                    </li>
                    <% }%>
                </ul>
            </div>
        </div>
    </body>
</html>
