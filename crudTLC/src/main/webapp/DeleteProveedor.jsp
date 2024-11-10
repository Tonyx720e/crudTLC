<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Proveedor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <div class="bg-success py-4">
                <h2 class="h2 text-center mb-3 text-light">Eliminar Proveedor</h2>
                <p class="fs-3 text-light text-center text-danger">El proveedor <strong class="text-primary">${nombre}</strong> será Eliminado</p>
                <form action="ServletDeleteProveedor"  method="POST" class="text-center w-50 mx-auto">
                    <button type="summit" class="btn btn-danger mt-2 fs-2">Eliminar</button>
                    <input type="hidden" value="${id}" name="id">
                </form>
            </div>
        </div>
    </body>
</html>
