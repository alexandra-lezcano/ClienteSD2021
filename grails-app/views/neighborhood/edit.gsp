<%@ page import="com.sd.Neighborhood" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'neighborhood.label', default: 'Neighborhood')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-neighborhood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Barrio</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Barrios</button></g:link>
        </div>
    </div>
        <div id="edit-neighborhood" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${neighborhoodInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${neighborhoodInstance}" var="error">
                        <li ><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form bean="${neighborhoodInstance}" method="PUT">
                <g:hiddenField name="id" value="${neighborhoodInstance?.id}" />
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'name','error')}">
                        <label for="name"> Nombre:
                        <g:textField name="name" value="${neighborhoodInstance?.name}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'description','error')}">
                        <label for="description"> Descripcion:
                        <g:textField name="description" value="${neighborhoodInstance?.description}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'city_id','error')}">
                        <label for="description"> Ciudad:
                        <g:select id="city" name="city_id" from="${cityInstanceList}" optionKey="id" optionValue="name" required="" value="${neighborhoodInstance?.city_id?.id}" class="many-to-one"/>
                        </label>
                    </div>
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" action ="update" value="Actualizar" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
