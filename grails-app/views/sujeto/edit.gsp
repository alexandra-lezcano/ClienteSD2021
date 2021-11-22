<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'sujeto.label', default: 'Sujeto')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-sujeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-sujeto" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${sujetoInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${sujetoInstance}" var="error">
                        <li ><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form bean="${sujetoInstance}" method="PUT">
                <g:hiddenField name="id" value="${sujetoInstance?.id}" />
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

                    <g:actionSubmit class="save" value="update" />
                    <g:actionSubmit class="delete"
                                    value="${message(code: 'default.button.delete.label', default: 'delete')}"
                                    id="${sujetoInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />

                </fieldset>
            </g:form>
        </div>
    </body>
</html>
