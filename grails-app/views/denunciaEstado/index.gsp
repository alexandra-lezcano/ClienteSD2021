<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'denunciaEstado.label', default: 'DenunciaEstado')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-denunciaEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <g:link class="create" action="create"><button class="btn btn-primary">Crear Estado</button></g:link>
            <g:link class="home" action="list"><button class="btn btn-primary">Lista de Estados</button></g:link>
        </ul>
    </div>
        <div id="list-denunciaEstado" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <f:table collection="${denunciaEstadoList}" />

            <div class="pagination">
                <g:paginate total="${denunciaEstadoCount ?: 0}" />
            </div>
        </div>
    </body>
</html>