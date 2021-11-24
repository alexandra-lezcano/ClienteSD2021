<!doctype html>
<html>
    <head>
        <title>Page Not Found</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
        <div class="error-page text-center">
            <asset:image class="sad col-md-6 col-sm-12 text-left" src="sad-face-svgrepo-com.svg" alt="SAD!"/>
            <div class="col-md-6 col-sm-12 float-right">
                <h1 class="E404">404!</h1>
                <h2 class="E404-text">¡Pagina no encontrada!</h2>
                <g:link uri="/">
                    <button  class="boton-denuncia btn btn-danger">
                        Volver al inicio
                    </button>
                </g:link>
            </div>
        </div>
    </body>
</html>
