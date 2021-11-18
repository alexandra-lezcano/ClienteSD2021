<%@ page import="com.sd.TipoDenuncia" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoDenuncia.label', default: 'TipoDenuncia')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-tipoDenuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-tipoDenuncia" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${tipoDenunciaInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${tipoDenunciaInstance}" var="error">
                <li><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                <div class="fieldcontain ${hasErrors(bean: tipoDenunciaInstance, field: 'titulo','error')}">
                        <label for="titulo">
                            <g:textField name="titulo" value="${tipoDenunciaInstance?.titulo}"/>
                        </label>
                </div>
                <div class="fieldcontain ${hasErrors(bean: tipoDenunciaInstance, field: 'descripcion','error')}">
                        <label for="descripcion">
                            <g:textField name="descripcion" value="${tipoDenunciaInstance?.descripcion}"/>
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
