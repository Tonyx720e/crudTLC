<!-- index.jsp -->
<!DOCTYPE html>
<html>

<head>
    <!-- Bootstrap CSS (versión 5.3) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet"
        crossorigin="anonymous">

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Bootstrap JS (versión 5.3, incluye Popper) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

    <!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/3556f97ea4.js" crossorigin="anonymous"></script>
    <title>Menu Principal</title>
    <style>
        /* Estilo para los botones */
        .menu-button {
            display: inline-block;
            padding: 10px 20px;
            color: white;
            background-color: #007BFF;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px;
            font-size: 16px;
        }

        .menu-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp" />

    <div class="container py-2">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="text-center">Menu Principal</h4>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-responsive table-sm">
                        <thead class="table-dark text-center">
                            <tr>
                                <th class="text-center">Clientes</th>
                                <th class="text">Proveedores</th>
                                <th class="text-center">Productos</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>

                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControladorCliente"
                                        class="menu-button">Clientes</a>

                                </td>
                                <td>

                                    <a href="${pageContext.request.contextPath}/ServletControladorProveedor"
                                        class="menu-button">Proveedores</a>

                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControladorProducto"
                                        class="menu-button">Productos</a>
                                </td>

                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp" />
</body>

</html>