
<%@ page import="com.sd.DepEstado" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'depEstado.label', default: 'DepEstado')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-depEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Dependencia del Estado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Dependencias</button></g:link>
    </div>
</div>

<div id="list-depEstado" class="content scaffold-list" role="main">


    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>

            <g:sortableColumn property="name"
                              title="${message(code: 'depEstado.label', default: 'Nombre')}" />

            <th>Descripcion</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${depEstadoInstanceList}" status="i" var="depEstadoInstance">

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link class="edit" action="edit" id="${depEstadoInstance?.id}">
                        ${fieldValue(bean: depEstadoInstance, field: "nombre")}</g:link>
                </td>
                <td>
                    ${fieldValue(bean: depEstadoInstance, field: "descripcion")}
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            value="delete"
                            id="${depEstadoInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${depEstadoTotal}" />
    </div>
</div>
</body>