<%@ page import="com.sd.Sujeto" %>

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
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Sujeto</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Sujetos</button></g:link>
        </div>
    </div>
        <div id="edit-sujeto" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${this.sujeto}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.sujeto}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
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
                            Ci: <g:textField name="ci" value="${sujetoInstance?.ci}"/>
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
                            Tipo: <g:select id="tipo" name="tipo" from="${tipoSujetoInstanceList}" optionKey="id" optionValue="titulo" required="" value="${sujetoInstance?.tipo}"/>
                        </label>
                    </div>
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" value="update" />
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                                    value="delete"
                                    id="${sujetoInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
