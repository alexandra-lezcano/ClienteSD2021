<%@ page import="com.sd.City" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-city" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <ul>
                <li>
                    <f:display bean="cityInstance" property="name"/>
                </li>
                <li>
                    <f:display bean="cityInstance" property="description"/>
                </li>
            </ul>
            <table>
                <thead>
                <tr>
                    <g:sortableColumn property="name"
                                      title="${message(code: 'neighborhood.label', default: 'Nombre')}" />

                    <th>Descripcion</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${neighborhoodInstanceList}" status="i" var="neighborhoodInstance">

                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>
                             ${fieldValue(bean: neighborhoodInstance, field: "name")}
                        </td>
                        <td>
                            ${fieldValue(bean: neighborhoodInstance, field: "description")}
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </body>
</html>
