<%@ page import="com.sd.CasosDerivados" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'casosDerivados.label', default: 'CasosDerivados')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<a href="#edit-casosDerivados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Caso Derivado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Casos</button></g:link>
    </div>
</div>
<div id="edit-casosDerivados" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
    <g:hasErrors bean="${casosDerivadosInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${casosDerivadosInstance}" var="error">
                <li ><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form bean="${casosDerivadosInstance}" method="PUT">
        <g:hiddenField name="id" value="${casosDerivadosInstance?.id}" />
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: casosDerivadosInstance, field: 'date','error')}">
                <label for="date"> Date:
                <g:textField name="date" value="${casosDerivadosInstance?.date}"/>
                </label>
            </div>
            <div class="fieldcontain ${hasErrors(bean: casosDerivadosInstance, field: 'description','error')}">
                <label for="description"> Descripcion:
                <g:textField name="description" value="${depEstadoInstance?.descripcion}"/>
                </label>
            </div>
            <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" value="Guardar Cambios" />
            <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                            value="${message(code: 'default.button.delete.label', default: 'delete')}"
                            id="${casosDerivadosInstance?.id}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
            />

        </fieldset>
    </g:form>
</div>
</body>
</html>
