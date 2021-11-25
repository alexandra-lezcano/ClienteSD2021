<%@ page import="com.sd.DepEstado" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'depEstado.label', default: 'DepEstado')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<a href="#edit-depEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Dependencia del Estado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Dependencias</button></g:link>
    </div>
</div>
<div id="edit-depEstado" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
    <g:hasErrors bean="${depEstadoInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${depEstadoInstance}" var="error">
                <li ><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form bean="${depEstadoInstance}" method="PUT">
        <g:hiddenField name="id" value="${depEstadoInstance?.id}" />
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: depEstadoInstance, field: 'nombre','error')}">
                <label for="nombre"> Nombre:
                Nombre: <g:textField name="nombre" value="${depEstadoInstance?.nombre}"/>
                </label>
            </div>
            <div class="fieldcontain ${hasErrors(bean: depEstadoInstance, field: 'description','error')}">
                <label for="description"> Descripcion:
                Descripcion: <g:textField name="description" value="${depEstadoInstance?.descripcion}"/>
                </label>
            </div>
            <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" value="update" />
            <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                            value="delete"
                            id="${depEstadoInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
            />

        </fieldset>
    </g:form>
</div>
</body>
</html>
