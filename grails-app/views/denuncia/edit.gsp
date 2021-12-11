<%@ page import="com.sd.Denuncia"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Denuncia</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Denuncias</button></g:link>
        </div>
    </div>
        <div id="edit-denuncia" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${this.denuncia}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.denuncia}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>

            <g:form bean="${denunciaInstance}" method="PUT">
                <g:hiddenField name="id" value="${denunciaInstance?.id}" />
                <g:hiddenField name="codigo" value="${denunciaInstance?.codigo}"
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'descripcion','error')}">
                        <label for="descripcion"> Desscripcion:
                        <g:textField name="descripcion" value="${denunciaInstance?.descripcion}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'fecha','error')}">
                        <label for="fecha"> Fecha:
                        <g:datePicker name="fecha" value="${denunciaInstance?.fecha}"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset>
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 save btn-primary" value="update" />
                    <g:actionSubmit class="margen-sm col-md-6 col-sm-12 delete btn-secondary"
                                    value="delete"
                                    id="${denunciaInstance?.id}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');"
                    />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
