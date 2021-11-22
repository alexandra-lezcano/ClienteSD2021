<%@ page import="com.sd.CasosDerivados" %>


<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'casosDerivados.label', default: 'CasosDerivados')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<a href="#create-casosDerivados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-casosDerivados" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>

    <g:hasErrors bean="${casosDerivadosInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${casosDerivadosInstance}" var="error">
                <li><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form action="save">
        <fieldswet class="form">
            <div class="fieldcontain ${hasErrors(bean: casosDerivadosInstance, field: 'name','error')}">
                <label for="date">
                    <g:textField name="date" value="${casosDerivadosInstance?.date}"/>
                </label>
            </div>
            <div class="fieldcontain ${hasErrors(bean: casosDerivadosInstance, field: 'description','error')}">
                <label for="description">
                    <g:textField name="description" value="${depEstadoInstance?.description}"/>
                </label>
            </div>
        </fieldswet>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
