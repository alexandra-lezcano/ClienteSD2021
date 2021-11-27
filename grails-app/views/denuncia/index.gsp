<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <g:link class="create" action="create"><button class="btn btn-primary">Crear Denuncia</button></g:link>
            <g:link class="home" action="list"><button class="btn btn-primary">Lista de Denuncias</button></g:link>
        </ul>
    </div>
        <div id="list-denuncia" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <f:table collection="${denunciaInstanceList}" properties="['codigo', 'descripcion']" />
        </div>
    </body>
</html>