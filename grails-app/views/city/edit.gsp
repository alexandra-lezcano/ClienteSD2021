<%@ page import="com.sd.City" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Ciudad</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de ciudades</button></g:link>
        </div>
    </div>
        <div id="edit-city" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${cityInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${cityInstance}" var="error">
                        <li ><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form bean="${cityInstance}" method="PUT">
                <g:hiddenField name="id" value="${cityInstance?.id}" />
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'name','error')}">
                        <label for="name"> Nombre:
                        <g:textField name="name" value="${cityInstance?.name}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'descripcion','error')}">
                        <label for="description"> Descripcion:
                        <g:textField name="description" value="${cityInstance?.description}"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset>
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" action ="update" value="Actualizar" />
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                                    value="delete"
                                    id="${cityInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
