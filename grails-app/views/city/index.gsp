<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create" action="create"><button class="btn btn-primary">Crear Ciudad</button></g:link>
                <g:link class="home" action="list"><button class="btn btn-primary">Lista de ciudades</button></g:link>
                </ul>
        </div>
        <div id="list-city" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <f:table collection="${cityInstanceList}" properties="['name', 'description']" />
        </div>
    </body>
</html>