
<%@ page import="com.sd.TipoDenuncia" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'tipoDenuncia.label', default: 'TipoDenuncia')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-tipoDenuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<div id="list-tipoDenuncia" class="content scaffold-list" role="main">

    <h1><g:message code="default.list.label" args="[entityName]" /></h1>

    <table>
        <thead>
        <tr>
            <g:sortableColumn property="titulo"
                              title="${message(code: 'tipoDenuncia.label', default: 'Titulo')}" />


            <th>Descripcion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${tipoDenunciaInstanceList}" status="i" var="tipoDenunciaInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>
                    <g:link class="edit" action="edit" id="${tipoDenunciaInstance?.id}">
                        ${fieldValue(bean: tipoDenunciaInstance, field: "titulo")}</g:link>
                </td>

                <td>
                    ${fieldValue(bean: tipoDenunciaInstance, field: "descripcion")}
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



