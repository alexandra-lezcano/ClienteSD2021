<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Usuario</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Usuarios</button></g:link>
        </div>
    </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <ul class="property-list">
                <li class="fieldcontain">
                    <span class="property-label">Nombre</span>
                    <div class="property-value"><f:display bean="userInstance" property="name"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Apellido</span>
                    <div class="property-value"><f:display bean="userInstance" property="surname"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Username</span>
                    <div class="property-value"><f:display bean="userInstance" property="email"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Cedula de Identidad</span>
                    <div class="property-value"><f:display bean="userInstance" property="cn"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Direccion</span>
                    <div class="property-value"><f:display bean="userInstance" property="address"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Correo Electronico</span>
                    <div class="property-value"><f:display bean="userInstance" property="email"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Numero de Telefon</span>
                    <div class="property-value"><f:display bean="userInstance" property="phone"/></div>
                </li>
                <li class="fieldcontain">
                    <span class="property-label">Ciudad</span>
                    <div class="property-value">${fieldValue(bean:userInstance?.city, field:"name")}</div>
                </li>
            </ul>
            <g:render template="/city/barrios" var="neighborhoodInstanceList"/>
        </div>
    </body>
</html>
