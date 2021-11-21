
<%@ page import="com.sd.City" %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
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

<div id="list-city" class="content scaffold-list" role="main">

    <h1><g:message code="default.list.label" args="[entityName]" /></h1>

    <table>
        <thead>
        <tr>
            <g:sortableColumn property="name"
                              title="${message(code: 'city.label', default: 'Name')}" />


            <th>Descripcion</th>
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
                    ${fieldValue(bean: cityInstance, field: "descripcion")}
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



