<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'sujeto.label', default: 'Sujeto')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-sujeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-sujeto" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.sujetoInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.sujetoInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'nombre','error')}">
                        <div>Nombre</div>
                        <label for="nombre">
                            <g:textField name="nombre" value="${sujetoInstance?.nombre}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'ci','error')}">
                        <div>C.I.</div>
                        <label for="ci">
                            <g:textField name="ci" value="${sujetoInstance?.ci}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'telefono','error')}">
                        <div>Telefono</div>
                        <label for="telefono">
                            <g:textField name="telefono" value="${sujetoInstance?.telefono}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'correo','error')}">
                        <div>Correo</div>
                        <label for="correo">
                            <g:textField name="correo" value="${sujetoInstance?.correo}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'direccion','error')}">
                        <div>Direccion</div>
                        <label for="direccion">
                            <g:textField name="direccion" value="${sujetoInstance?.direccion}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'tipo','error')}">
                        <div>Tipo</div>
                        <label for="tipo">
                            <g:textField name="tipo" value="${sujetoInstance?.tipo}"/>
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
