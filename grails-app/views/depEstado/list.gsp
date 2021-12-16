
<%@ page import="com.sd.DepEstado" %>
<html>

<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'depEstado.label', default: 'DepEstado')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
<a href="#list-depEstado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>


<div class="nav" role="navigation">
    <div class="row sin-margin">
        <g:link class="" action="create"><button class="rellenar col-sm-6 col-xs-12 btn btn-primary">Crear Dependencia del Estado</button></g:link>
        <g:link class="" action="list"><button class="rellenar col-sm-6 col-xs-12 float-right btn btn-primary">Lista de Dependencias</button></g:link>
    </div>
</div>


<div class="col-form-label text-right add-margin">
    <g:render template="/layouts/search" model="['find': find]"/>
</div>

<div id="list-depEstado" class="content scaffold-list" role="main">
    <g:render template="table" model="['depEstadoInstanceList': depEstadoInstanceList, 'sig':sig, 'prev':prev, 'find': find ]"/>
</div>

<script>
    function searchChanged(value){
        jQuery.ajax(
            {type:'POST',data:'find='+value, url:'/depEstado/updateTable',success:function(data,textStatus){
                    jQuery('#list-depEstado').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
    };

</script>

</body>