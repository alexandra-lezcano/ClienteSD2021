<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'neighborhood.label', default: 'Neighborhood')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <a href="#list-neighborhood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Barrio</button></g:link>
            <g:link class="" action="list" params="[page: 0]"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Barrios</button></g:link>
        </div>
    </div>
    <div id="list-tipoDenuncia" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
        <f:table collection="${neighborhoodInstanceList}" properties="['name', 'description', 'city_id']" />

    </div>
</html>