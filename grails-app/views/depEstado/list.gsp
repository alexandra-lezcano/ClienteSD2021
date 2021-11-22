
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
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<div id="list-depEstado" class="content scaffold-list" role="main">

    <h1><g:message code="default.list.label" args="[entityName]" /></h1>

    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name"
                              title="${message(code: 'depEstado.label', default: 'Nombre')}" />

            <th>Description</th>
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