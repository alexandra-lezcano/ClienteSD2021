<!doctype html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>
<body>
<div class="error-page text-center">
    <asset:image class="sad col-md-6 col-sm-12 text-left" src="hazard-sign-svgrepo-com.svg" alt="SAD!"/>
    <div class="col-md-6 col-sm-12 float-right">
        <h2 class="E404-text">¡Ha ocurrido un error en el servidor!</h2>
        <g:link uri="/">
            <button  class="boton-denuncia btn btn-danger">
                Volver al inicio
            </button>
        </g:link>
    </div>
</div>
</body>
</html>
