<%@ page import="com.sd.City" %>

<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Ciudad</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de ciudades</button></g:link>
    </div>
</div>

<div id="list-city" class="content scaffold-list" role="main">

    <table class="table table-striped table-bordered tabla-options">
        <thead>
        <tr>
            <g:sortableColumn property="name"
                              title="${message(code: 'city.label', default: 'Nombre')}" />

            <th>Descripcion</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${cityInstanceList}" status="i" var="cityInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>
                    <g:link class="edit" action="edit" id="${cityInstance?.id}">
                        ${fieldValue(bean: cityInstance, field: "name")}</g:link>
                </td>
                <td>
                    ${fieldValue(bean: cityInstance, field: "description")}
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            value="delete"
                            id="${cityInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${citiesTotal}" />
    </div>
</div>
</body>



