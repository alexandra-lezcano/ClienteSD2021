<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'denunciaEstado.label', default: 'DenunciaEstado')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-denunciaEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Estado</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Estados</button></g:link>
        </div>
    </div>
        <div id="edit-denunciaEstado" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:hasErrors bean="${this.denunciaEsdadoInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.denunciaEsdadoInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form bean="${denunciaEsdadoInstance}" method="PUT">
                <g:hiddenField name="id" value="${denunciaEsdadoInstance?.id}" />
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: denunciaEsdadoInstance, field: 'nombre','error')}">
                        <label for="nombre"> Nombre:
                        <g:textField name="nombre" value="${denunciaEsdadoInstance?.nombre}"/>
                        </label>
                    </div>


                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" value="Guardar Cambios" />
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                                    value="${message(code: 'default.button.delete.label', default: 'delete')}"
                                    id="${denunciaEsdadoInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
