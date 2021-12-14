<%@ page import="com.sd.Denuncia" %>

<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Denuncia</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Denuncias</button></g:link>
    </div>
</div>

<div id="list-denuncia" class="content scaffold-list" role="main">

    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>
            <g:sortableColumn property="codigo"
                              title="${message(code: 'denuncia.label', default: 'Codigo')}" />

            <th>Descripcion</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${denunciaInstanceList}" status="i" var="denunciaInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link class="edit" action="edit" id="${denunciaInstance?.id}">
                        ${fieldValue(bean: denunciaInstance, field: "codigo")}</g:link>
                </td>
                <td>
                    ${fieldValue(bean: denunciaInstance, field: "descripcion")}
                </td>
                <td>
                    ${fieldValue(bean: denunciaInstance, field: "fecha")}
                </td>
                <td>
                    ${fieldValue(bean: denunciaInstance, field: "estado")}
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            value="delete"
                            id="${denunciaInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                    </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <g:render template="/layouts/pagination"/>
</div>
</body>



