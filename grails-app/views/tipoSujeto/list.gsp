<%@ page import="com.sd.TipoSujeto" %>

<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'tipoSujeto.label', default: 'TipoSujeto')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-tipoSujeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Tipo de Sujeto</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Tipos de Sujetos</button></g:link>
    </div>
</div>

<div id="list-tipoSujeto" class="content scaffold-list" role="main">

    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>
            <g:sortableColumn property="titulo"
                              title="${message(code: 'tipoSujeto.label', default: 'Titulo')}" />
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${tipoSujetoInstanceList}" status="i" var="tipoSujetoInstance">

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link class="edit" action="edit" id="${tipoSujetoInstance?.id}">
                        ${fieldValue(bean: tipoSujetoInstance, field: "titulo")}</g:link>
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            value="delete"
                            id="${tipoSujetoInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${tipoDenunciasTotal}" />
    </div>
</div>
</body>