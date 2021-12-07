
<%@ page import="com.sd.CasosDerivados" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'casosDerivados.label', default: 'CasosDerivados')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-casosDerivados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Caso Derivado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Casos</button></g:link>
    </div>
</div>
<div id="list-casosDerivados" class="content scaffold-list" role="main">

    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>

            <g:sortableColumn property="date"
                              title="${message(code: 'depEstado.label', default: 'Fecha')}" />

            <th>Description</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${casosDerivadosInstanceList}" status="i" var="casosDerivadosInstance">
       

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
            <g:each in="${casosDerivadosInstance?.getDepEstadoBSet()}"  var="depEstadoInstance">

                <g:link class="edit" action="edit" id="${depEstadoInstance.id}">
                        ${fieldValue(bean: depEstadoInstance, field: "nombre")}</g:link>
            </g:each>
                </td>

                <td>
                    ${fieldValue(bean: casosDerivadosInstance, field: "description")}
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            value="delete"
                            id="${casosDerivadosInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                    <g:link class="show" action="show" id="${casosDerivadosInstance?.id}">Ver detalles</g:link>

                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${casosDerivadosTotal}" />
    </div>
</div>
</body>