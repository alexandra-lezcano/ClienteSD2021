<%@ page import="com.sd.DenunciaEstado" %>

<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'denunciaEstado.label', default: 'Denuncia estado')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-denunciaEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Estado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Estados</button></g:link>
    </div>
</div>

<div id="list-denunciaEstado" class="content scaffold-list" role="main">

    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>
            <g:sortableColumn property="name"
                              title="${message(code: 'city.label', default: 'Nombre')}" />
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${denunciaEstadoInstanceList}" status="i" var="denunciaEstadoInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>
                    <g:link class="edit" action="edit" id="${denunciaEstadoInstance?.id}">
                        ${fieldValue(bean: denunciaEstadoInstance, field: "name")}</g:link>
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            id="${denunciaEstadoInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${denunciaEsdatoTotal}" />
    </div>
</div>
</body>
