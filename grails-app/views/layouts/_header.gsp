<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top header-fix" role="navigation">
    <a class="navbar-brand align-middle" href="/#">
        <asset:image class="logo text-center col-4" src="grails.svg" alt="Protection App"/>
        <p class="titulo-logo text-left float-right align-middle">Protection</p>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Opciones<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">
                                <g:message code="${c.logicalPropertyName}.label"/>
                            </g:link>
                        </li>
                    </g:each>
                </ul>
            </li>
        </ul>
        <g:link resource="user" action="login">
            <button class="boton btn btn-warning text-right">Iniciar Sesion</button>
        </g:link>
        <g:link resource="user" action="register">
            <button class="btn text-right btn-primary">Registrarse</button>
        </g:link>
    </div>
</nav>