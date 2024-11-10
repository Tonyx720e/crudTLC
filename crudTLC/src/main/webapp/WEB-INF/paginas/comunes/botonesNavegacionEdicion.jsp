<%-- 
    Document   : botonesNavegacionEdicion
    Created on : 6 nov 2024, 12:59:50
    Author     : tonym
--%>

<section id="action" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <a href="index.jsp" class="btn btn-ligth btn-block">
                <i class="fas fa-arrow-left"></i> Regeresar al inicio
            </a>
        </div>
        <div class="row">
            <a href="${pageContext.request.contextPath}/ServletControladorCliente?accion=eliminar&idcliente=${cliente.idcliente}" method="post" class="was-validated " class="btn btn-danger btn-block">
                <i class="fas fa-trash"></i> Eliminar 
            </a>
        </div>
    </div>
</section>

