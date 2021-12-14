
<%@ page import="com.sd.Neighborhood" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'neighborhood.label', default: 'Neighborhood')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-neighborhood" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Barrio</button></g:link>
        <g:link class="" action="list" params="[page:0]"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Barrios</button></g:link>
    </div>
</div>
<div class="col-form-label text-right add-margin">
    <label class="col-md-4 col-sm-12" for="city">
        Buscar Barrios por ciudad:
    </label>
    <g:select    class="col-md-8 col-sm-12" id="city" name="city" from="${cityInstanceList}"
                 optionKey="id" optionValue="name" noSelection="${['null':'Ver todo']}"
                 onchange="cityChanged(this.value);" value="${find}"/>
</div>
<div id="list-neighborhood" class="content scaffold-list" role="main">
    <g:render template="table"  model="['neighborhoodInstanceList': neighborhoodInstanceList, 'sig':sig,
    'prev':prev, 'find': find]"/>
</div>

    <script>
        function cityChanged(value){
            jQuery.ajax(
                {type:'POST',data:'find='+value, url:'/neighborhood/updateTable',success:function(data,textStatus){
                    jQuery('#list-neighborhood').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
        };

    </script>
</body>