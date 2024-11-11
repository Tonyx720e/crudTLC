<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Productos</title>
        <!-- Bootstrap CSS (versión 5.3) -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!-- Bootstrap JS (versión 5.3, incluye Popper) -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

        <!-- FontAwesome -->
        <script src="https://kit.fontawesome.com/3556f97ea4.js" crossorigin="anonymous"></script>
        
    </head>
    <body>  
        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp" />
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp" />
        <jsp:include page="WEB-INF/paginas/productos/listadoProductos.jsp" />
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp" />

    </body>
</html>