<%@ page import="com.sd.TipoSujeto" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tipoSujeto.label', default: 'TipoSujeto')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-tipoSujeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Tipo de Sujeto</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Tipos de Sujetos</button></g:link>
        </div>
    </div>
        <div id="create-tipoSujeto" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${tipoSujetoInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${tipoSujetoInstance}" var="error">
                        <li><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: tipoSujetoInstance, field: 'titulo','error')}">
                        <label for="titulo">
                            Titulo<g:textField name="titulo" value="${tipoSujetoInstance?.titulo}"/>
                        </label>
                    </div>

                    <button type="submit" class="separar btn btn-success col-md-6 col-sm-12 rellenar">Crear</button>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
