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

            <g:hasErrors bean="${this.sujetoInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.sujetoInstance}" var="error">
                    <li><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>

            <g:form action="save">
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'nombre','error')}">
                        <label for="nombre">
                            Nombre: <g:textField name="nombre" value="${sujetoInstance?.nombre}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'ci','error')}">
                        <label for="ci">
                            C.I.: <g:textField name="ci" value="${sujetoInstance?.ci}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'telefono','error')}">
                        <label for="telefono">
                            Telefono: <g:textField name="telefono" value="${sujetoInstance?.telefono}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'correo','error')}">
                        <label for="correo">
                            Correo: <g:textField name="correo" value="${sujetoInstance?.correo}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'direccion','error')}">
                        <label for="direccion">
                            Direccion: <g:textField name="direccion" value="${sujetoInstance?.direccion}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'tipo','error')}">
                        <label for="tipo">
                            <g:select id="tipo" name="tipo" from="${tipoSujetos}" optionKey="id" optionValue="titulo" required="" value="${sujetoInstance?.tipo?.id}"/>
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
