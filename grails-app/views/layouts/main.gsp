<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Protection App - SD2021"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
    <div class="container contenedor">
        <div class="wrap">
            <div class="main">
                <g:render template="/layouts/header"/>
                <div class="contenido"><g:layoutBody/></div>
            </div>
        </div>
        <div class="footer text-center" role="contentinfo">
            <p>Protection App - Sistemas de Gestion - 2021</p>
        </div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>


<asset:javascript src="application.js"/>
</div>
</body>
</html>
