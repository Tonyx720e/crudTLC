<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX" />
<section id="productos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped table-bordered table-hover table-responsive table-sm">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="producto" items="${productos}" varStatus="status">
                                <tr>
                                    <th scope="row">${status.count}</th>
                                    <td>${producto.nombre}</td>
                                    <td>
                                        <a class="btn btn-warning btn-sm"
                                           href="${pageContext.request.contextPath}/ServletControladorProducto?accion=editar&idproducto=${producto.idproducto}">
                                            <i class="fas fa-angle-double-right"></i> Modificar
                                        </a>
                                        <a class="btn btn-danger btn-sm btn-block" 
                                           href="${pageContext.request.contextPath}/ServletControladorProducto?accion=eliminar&idproducto=${producto.idproducto}" method="post" class="was-validated ">
                                            <i class="fas fa-trash"></i> Eliminar
                                        </a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="agregarProducto.jsp" />