<%@ page import="com.sd.Neighborhood" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'neighborhood.label', default: 'Neighborhood')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-neighborhood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Barrio</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Barrios</button></g:link>
        </div>
    </div>
        <div id="show-neighborhood" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>

            <ul>
                <li>
                    <f:display bean="neighborhoodInstance" property="name"/>
                </li>
                <li>
                    <f:display bean="neighborhoodInstance" property="description"/>
                </li>
                <li>
                    <f:display bean="neighborhoodInstance" property="city_id.name"/>
                </li>
            </ul>
            <g:form resource="${neighborhoodInstance}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" id="${neighborhoodInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
