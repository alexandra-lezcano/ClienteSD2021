<%@ page import="com.sd.Denuncia" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <g:javascript library="jquery"/>
</head>

<body>
<a href="#create-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <g:link class="create" action="create"><button class="btn btn-primary">Crear Denuncia</button></g:link>
        <g:link class="home" action="list"><button class="btn btn-primary">Lista de Denuncias</button></g:link>
    </ul>
</div>

<div id="create-denuncia" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>

    <g:hasErrors bean="${this.denuncia}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.denuncia}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action='save'>
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'descripcion', 'error')}">
                <label for="descripcion">
                    Describa Detalladamente el suceso:
                    <p style="color: #adb5bd; font-size: small">Cual es la relacion entre la victima y el victimario? (familiar/profesor/vecino)
                    Como se entero usted del suceso? Cual es su relacion con la victima(vecino,profesor,conocido,etc)</p>

                    <div style="height:200px;">
                        <g:textArea name="descripcion" value="${denunciaInstance?.descripcion}"/>
                    </div>
                </label>
            </div>

            <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'city', 'error')}">
                <label for="city">
                    Ciudad: <g:select id="city" name="city" from="${cityInstanceList}"
                                      optionKey="id" optionValue="name" value="${denunciaInstance?.city?.id}"
                                      onchange="cityChanged(this.value);"/>
                </label>
            </div>

            <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'neighborhood', 'error')}">
                <label for="neighborhoods">
                    Barrio:
                    <span id="updateNeigh">
                        <g:select id="neighborhoods" name="neighborhood" from="${neighborhoodInstanceList}"
                                  optionKey="id" optionValue="name" required=""
                                  value="${denunciaInstance?.neighborhood?.id}"/>
                    </span>
                </label>
            </div>
        <!-- Recorre la lista de sujetos -->

            <g:each in="${denunciaInstance?.sujetos}" status="i" var="sujetoInstance">
                <h1>${fieldValue(bean: sujetoInstance?.tipo, field: "titulo")} <br></h1>
                <!-- funcionara darle el tipo aca mismo? -->
                <!-- podes probar con g:hiddenField -->
                <g:hiddenField name="sujetos[${i}].tipo" value="${sujetoInstance?.tipo?.titulo}" />
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'nombre', 'error')}">
                                    Nombre Completo: <g:textField name="sujetos[${i}].nombre"
                                                                  value="${sujetoInstance?.nombre}"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'ci', 'error')}">
                                Cédula de Identidad: <g:textField name="sujetos[${i}].ci" value="${sujetoInstance?.ci}"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'telefono', 'error')}">
                                Telefono: <g:textField name="sujetos[${i}].telefono" value="${sujetoInstance?.telefono}"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'correo', 'error')}">
                                Correo: <g:textField name="sujetos[${i}].correo" value="${sujetoInstance?.correo}"/>
                            </div>
                        </div>


                        <div class="col-md-6">
                            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'direccion', 'error')}">
                                Direccion: <g:textField name="sujetos[${i}].direccion" value="${sujetoInstance?.direccion}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </g:each>

            <button type="submit" class="separar btn btn-success col-md-6 col-sm-12 rellenar">Crear</button>
        </fieldset>
    </g:form>
</div>
<script>
    function cityChanged(value) {
        jQuery.ajax({
            type: 'POST',
            data: 'city=' + value,
            url: '/denuncia/updateNeighborhood',
            success: function (data, textStatus) {
                jQuery('#updateNeigh').html(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });
    }
</script>
</body>
</html>
