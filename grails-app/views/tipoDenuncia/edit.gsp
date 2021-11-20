<%@ page import="com.sd.TipoDenuncia" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoDenuncia.label', default: 'TipoDenuncia')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-tipoDenuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-tipoDenuncia" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${tipoDenunciaInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${tipoDenunciaInstance}" var="error">
                <li ><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form bean="${tipoDenunciaInstance}" method="PUT">
                <g:hiddenField name="id" value="${tipoDenunciaInstance?.id}" />
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: tipoDenunciaInstance, field: 'titulo','error')}">
                        <label for="titulo"> Titulo:
                            <g:textField name="titulo" value="${tipoDenunciaInstance?.titulo}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: tipoDenunciaInstance, field: 'descripcion','error')}">
                        <label for="descripcion"> Descripcion:
                            <g:textField name="descripcion" value="${tipoDenunciaInstance?.descripcion}"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset class="buttons">

                    <g:actionSubmit class="save" value="update" />
                    <g:actionSubmit class="delete"
                                    value="${message(code: 'default.button.delete.label', default: 'delete')}"
                                    id="${tipoDenunciaInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />

                </fieldset>
            </g:form>
        </div>
    </body>
</html>
