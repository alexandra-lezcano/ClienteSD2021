<%@ page import="com.sd.Denuncia" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'denuncia.label', default: 'Denuncia')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <g:javascript library="jquery"/>
    </head>
    <body>
        <a href="#create-denuncia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <g:link class="create" action="create"><button class="btn btn-primary">Crear Denuncia</button></g:link>
            <g:link class="home" action="list"><button class="btn btn-primary">Lista de Denuncias</button></g:link>
        </ul>
    </div>
        <div id="create-denuncia" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>

            <g:hasErrors bean="${this.denuncia}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.denuncia}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action='save'>
               <fieldset class="form">
                   <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'city','error')}">
                       <label for="city">
                           Ciudad: <g:select    id="city" name="city" from="${cityInstanceList}"
                                                optionKey="id" optionValue="name" value="${denunciaInstance?.city?.id}"
                                                onchange="cityChanged(this.value);"/>
                       </label>
                   </div>
                   <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'neighborhood','error')}">
                       <label for="neighborhoods">
                            Barrio:
                            <span id="updateNeigh">
                                <g:select id="neighborhoods" name="neighborhood" from="${neighborhoodInstanceList}" optionKey="id" optionValue="name" required="" value="${denunciaInstance?.neighborhood?.id}"/>
                            </span>
                       </label>
                   </div>
                   <div>Introduzca sus datos</div>
                   <g:render template="sujetoForm"/>
                   <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'descripcion','error')}">
                       <label for="descripcion">
                           Describa los hechos: <g:textArea name="descripcion" value="${denunciaInstance?.descripcion}"/>
                       </label
                   </div>
                   <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'neighborhood','error')}">
                           <dv>Añada los datos que conozca de las victimas:</dv>
                           <g:render template="sujetoForm"/>
                           <button class="separar btn btn-success col-md-6 col-sm-12 rellenar">Añadir victima</button>
                   </div>
                   <div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'neighborhood','error')}">
                       <dv>Añada los datos que conozca de los perpetuadores:</dv>
                       <g:render template="sujetoForm"/>
                       <button class="separar btn btn-success col-md-6 col-sm-12 rellenar">Añadir perpetuador</button>
                   </div>
                   <button type="submit" class="separar btn btn-success col-md-6 col-sm-12 rellenar">Crear</button>
               </fieldset>
            </g:form>
        </div>
    <script>
        function cityChanged(value) {
            jQuery.ajax({type:'POST',data:'city='+value, url:'/denuncia/updateNeighborhood',success:function(data,textStatus){jQuery('#updateNeigh').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
        }
    </script>

    </body>

</html>
