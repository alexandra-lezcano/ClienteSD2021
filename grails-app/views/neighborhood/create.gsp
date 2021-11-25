<%@ page import="com.sd.Neighborhood" %>
<%@ page import="com.sd.City" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'neighborhood.label', default: 'Neighborhood')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-neighborhood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-neighborhood" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${neighborhoodInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${neighborhoodInstance}" var="error">
                        <li><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'name','error')}">
                        <label for="name">
                            Nombre: <g:textField name="name" value="${neighborhoodInstance?.name}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'description','error')}">
                        <label for="description">
                            Descripcion: <g:textField name="description" value="${neighborhoodInstance?.description}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'city_id','error')}">
                        <label for="city_id">
                           Ciudad: <g:select id="city" name="city_id" from="${cityInstanceList}" optionKey="id" optionValue="name" required="" value="${neighborhoodInstance?.city_id?.id}"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
