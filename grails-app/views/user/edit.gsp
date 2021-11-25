<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <div class="row sin-margin">
            <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Usuario</button></g:link>
            <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Usuarios</button></g:link>
        </div>
    </div>
        <div id="edit-user" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${userInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${userInstance}" var="error">
                <li><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>

            <g:form bean="${userInstance}" method="PUT">
                <g:hiddenField name="id" value="${userInstance?.id}" />
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name','error')}">
                        <label for="name">
                            Nombre: <g:textField name="name" value="${userInstance?.name}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'surname','error')}">
                        <label for="surname">
                            Apellido: <g:textField name="surname" value="${userInstance?.surname}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'cn','error')}">
                        <label for="cn">
                            Cedula de Identidad: <g:textField name="cn" value="${userInstance?.cn}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'address','error')}">
                        <label for="address">
                            Direccion: <g:textField name="address" value="${userInstance?.address}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email','error')}">
                        <label for="email">
                            Correo Electronico: <g:textField name="email" value="${userInstance?.email}"/>
                        </label>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'phone','error')}">
                        <label for="phone">
                            Numero de Telefono: <g:textField name="phone" value="${userInstance?.phone}"/>
                        </label>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:actionSubmit class="save"
                                    value="${message(code: 'default.button.update.label')}"
                                    action="update"/>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
