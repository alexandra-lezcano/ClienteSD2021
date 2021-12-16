<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top header-fix" role="navigation">
    <a class="navbar-brand align-middle" href="/#">
        <asset:image class="logo text-center col-4" src="grails.svg" alt="Protection App"/>
        <p class="titulo-logo text-left float-right align-middle">Protection App</p>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">

        </ul>
<g:if test="${!auth}">
        <g:link resource="CasosDerivados" action="list">
            <button class="boton btn btn-warning text-right">Iniciar Sesion</button>
        </g:link>
        <g:link resource="user" action="create">
            <button class="boton btn text-right btn-secondary">Registrarse</button>
        </g:link>
    </g:if>
        <g:if test="${!auth}">
            <g:link resource="Denuncia" action="list">
                <button class="boton btn btn-primary text-right">Denuncias</button>
            </g:link>
            <g:link resource="CasosDerivados" action="list">
                <button class="boton btn text-right btn-primary">Casos Derivados</button>
            </g:link>
        </g:if>
        <g:if test="${!admin}">
            <g:link resource="City" action="list">
                <button class="boton btn btn-primary text-right">Administrar</button>
            </g:link>

        </g:if>

    </div>
</nav>