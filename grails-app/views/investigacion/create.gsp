<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'investigacion.label', default: 'Investigacion')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-investigacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Investigacion</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Investigaciones</button></g:link>
        </div>
    </div>
        <div id="create-investigacion" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${this.investigacion}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.investigacion}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>


            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: investigacionInstance, field: 'name','error')}">
                        <label for="name">
                            Descripcion: <g:textField name="name" value="${investigacionInstance?.descripcion}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: investigacionInstance, field: 'description','error')}">
                        <label for="description">
                            Fecha Inicio: <g:textField name="description" value="${investigacionInstance?.fecha_inicio}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: investigacionInstance, field: 'description','error')}">
                        <label for="description">
                            Fecha Fin: <g:textField name="description" value="${investigacionInstance?.fecha_fin}"/>
                        </label>
                    </div>
                    <button type="submit" class="separar btn btn-success col-md-6 col-sm-12 rellenar">Crear</button>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
