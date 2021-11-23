
<%@ page import="com.sd.Sujeto" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'sujeto.label', default: 'Sujeto')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-sujeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<div id="list-sujeto" class="content scaffold-list" role="main">

    <h1><g:message code="default.list.label" args="[entityName]" /></h1>

    <table>
        <thead>
        <tr>
            <g:sortableColumn property="nombre"
                              title="${message(code: 'sujeto.label', default: 'Nombre')}" />

            <th>CI</th>
            <th>Telefono</th>
            <th>Correo</th>
            <th>Direccion</th>
            <th>Tipo</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${sujetoInstanceList}" status="i" var="sujetoInstance">

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link class="edit" action="edit" id="${sujetoInstance?.id}">
                        ${fieldValue(bean: sujetoInstance, field: "nombre")}</g:link>
                </td>
                <td>
                    ${fieldValue(bean: sujetoInstance, field: "ci")}
                </td>
                <td>
                    ${fieldValue(bean: sujetoInstance, field: "telefono")}
                </td>
                <td>
                    ${fieldValue(bean: sujetoInstance, field: "correo")}
                </td>
                <td>
                    ${fieldValue(bean: sujetoInstance, field: "direccion")}
                </td>
                <td>
                    ${fieldValue(bean: sujetoInstance, field: "tipo.titulo")}
                </td>
                <td>
                    <g:link class="delete"
                            action="delete"
                            id="${sujetoInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                        Borrar
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${sujetosTotal}" />
    </div>
</div>
</body>