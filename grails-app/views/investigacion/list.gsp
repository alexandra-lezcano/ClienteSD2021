
<%@ page import="com.sd.Neighborhood" %>
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
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Investigacion</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Investigaciones</button></g:link>
    </div>
</div>
<g:link class="" resource="Neighborhood" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Barrio</button></g:link>

<div id="list-neighborhood" class="content scaffold-list" role="main">
    <g:render template="table"  model="['neighborhoodInstanceList': investigacionInstanceList, 'sig':sig,
                                        'prev':prev]"/>
</div>

</body>