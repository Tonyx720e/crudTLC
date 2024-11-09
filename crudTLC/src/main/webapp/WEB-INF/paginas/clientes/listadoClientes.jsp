<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <fmt:setLocale value="es_MX" />
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <section id="clientes">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Listado de CLientes</4>
                                </div>
                                <table class="table table-striped table-bordered table-hover table-responsive table-sm">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                            <tr>
                                                <th scope="row">${status.count}</th>
                                                <td>${cliente.nombre}</td>
                                                <td>
                                                    <button
                                                        href="${pageContext.request.contextPath}/ServletControladorCliente?accion=editar&idcliente=${cliente.idcliente}"
                                                        data-bs-toggle="modal" data-bs-target="#agregarPersonaModal" class="btn btn-secondary btn-sm"><i
                                                            class="fas fa-angle-double-right"></i>Editar
                                                        </a>
                                                    </button>
                                                    <button class="btn btn-primary btn-sm">Modificar</button>
                                                    <button class="btn btn-danger btn-sm">Eliminar</button>
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