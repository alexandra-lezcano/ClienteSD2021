<%@ page import="com.sd.Denuncia" %>

<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Denuncia</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Denuncias</button></g:link>
    </div>
</div>

<div id="list-denuncia" class="content scaffold-list" role="main">
    <g:render template="table"  model="['denunciaInstanceList': denunciaInstanceList, 'sig':sig, 'prev':prev]"/>
</div>
</body>



