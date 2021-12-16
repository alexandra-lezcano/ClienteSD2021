
<%@ page import="com.sd.CasosDerivados" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'casosDerivados.label', default: 'CasosDerivados')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-casosDerivados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Caso Derivado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Casos</button></g:link>
    </div>
</div>
<div id="list-casosDerivados" class="content scaffold-list" role="main">
    <g:render template="table"  model="[depEstadoInstanceList: depEstadoInstanceList, depEstadoTotal: depEstadoTotal
                                        ,casosDerivadosInstanceList: casosDerivadosInstanceList, casosDerivadosTotal: casosDerivadosTotal,
                                        sig: sig, prev: prev]"/>
</body>