<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            </tr>
        </c:forEach>
    </tbody>

</table>
