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
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
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
                <fieldset class="buttons">

                    <g:actionSubmit class="save" value="update" />
                    <g:actionSubmit class="delete"
                                    value="${message(code: 'default.button.delete.label', default: 'delete')}"
                                    id="${cityInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
