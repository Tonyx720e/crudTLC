<%-- 
    Document   : UpdateProveedor
    Created on : Nov 10, 2024, 9:58:40 AM
    Author     : luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Proveedor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
</head>
<body>
    <div class="container">
        <div class="bg-success py-4">
            <h2 class="h2 text-center mb-3 text-light">Actualizar Proveedor</h2>
            <p class="fs-3 text-light text-center">El proveedor <strong>${newNombre}</strong> será modificado</p>
            <form action="ServletUpdateProveedor"  method="POST" class="text-center w-50 mx-auto">
                <div class="input-group flex-nowrap">                 
                    <input type="text" class="form-control" placeholder="Actualizar Proveedor" aria-label="Actualizar Proveerdor" aria-describedby="addon-wrapping" name="nombre">
                </div>
                <button type="summit" class="btn btn-warning mt-2">Actualizar</button>
                <input type="hidden" value="${id}" name="id">
            </form>
        </div>
    </div>
</body>
</html>
