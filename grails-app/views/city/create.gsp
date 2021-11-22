<%@ page import="com.sd.City" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-city" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${cityInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${cityInstance}" var="error">
                    <li><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'name','error')}">
                        <label for="nombre">
                            Nombre<g:textField name="nombre" value="${cityInstance?.name}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'descripcion','error')}">
                        <label for="descripcion">
                            Descripcion<g:textField name="descripcion" value="${cityInstance?.description}"/>
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
