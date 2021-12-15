<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>


<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" resource="City" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Ciudades</button></g:link>
        <g:link class="" resource="Neighborhood" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Barrios</button></g:link>
        <g:link class="" resource="DepEstado" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Dependencias de estado</button></g:link>
        <g:link class="" resource="TipoDenuncia" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Tipo de denuncia</button></g:link>
        <g:link class="" resource="User" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Usuarios</button></g:link>



    </div>
</div>
<div id="list-user" class="content scaffold-list" role="main">
    <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Usuario</button></g:link>

    <h1><g:message code="default.list.label" args="[entityName]" /></h1>

    <f:table collection="${userList}" />

    <table class="table table-striped table-bordered tabla-options">
    <thead>
    <tr>
        <g:sortableColumn property="name"
            title="${message(code: 'user.label', default: 'Nombre')}"/>
        <th>Apellido</th>
        <th>CN</th>
        <th>Correo</th>
        <th>Telefono</th>
        <th>Ciudad</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td> <g:link class="edit" action="edit" id="${userInstance?.id}">
                ${fieldValue(bean:userInstance, field:"name")}</g:link> </td>
            <td> ${fieldValue(bean:userInstance, field:"surname")}</td>
            <td> ${fieldValue(bean:userInstance, field:"cn")}</td>
            <td> ${fieldValue(bean:userInstance, field:"email")}</td>
            <td> ${fieldValue(bean:userInstance, field:"phone")}</td>
            <td> ${fieldValue(bean:userInstance?.city, field:"name")}</td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${userInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');">
                        Eliminar usuario
                </g:link> |
                <g:link class="show" action="show" id="${userInstance?.id}">Ver detalles</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>

</table>
    <g:render template="/layouts/pagination"/>
</div>
</body>
</html>