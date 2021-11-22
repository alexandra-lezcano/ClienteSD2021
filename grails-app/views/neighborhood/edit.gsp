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
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
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
                        <g:select id="city" name="city_id" from="${cities}" optionKey="id" optionValue="name" required="" value="${neighborhoodInstance?.city_id?.id}" class="many-to-one"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset class="buttons">f
                    <g:actionSubmit class="save" value="update" />
                    <g:actionSubmit class="delete"
                                    value="${message(code: 'default.button.delete.label', default: 'delete')}"
                                    id="${neighborhoodInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
