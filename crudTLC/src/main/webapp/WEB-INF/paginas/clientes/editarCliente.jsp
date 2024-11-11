<%-- Document : editarCliente Created on : 6 nov 2024, 12:58:24 Author : tonym --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap CSS (versión 5.3) -->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet"
                crossorigin="anonymous">
            <!-- FontAwesome -->
            <script src="https://kit.fontawesome.com/3556f97ea4.js" crossorigin="anonymous"></script>
            <title>Editar Persona</title>
        </head>

        <body>
            <jsp:include page="../comunes/cabecera.jsp" />
            <form action="${pageContext.request.contextPath}/ServletControladorCliente?accion=modificar&idcliente=${cliente.idcliente}"
                method="post" class="was-validated">
                <jsp:include page="../comunes/botonesNavegacionEdicion.jsp" />
                <section id="datails">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>Modificar Cliente</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nombre" > Nombre</label>
                                            <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar Cliente</button>
                </div>
            </form>
        </body>

        </html>