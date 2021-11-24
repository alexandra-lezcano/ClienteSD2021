<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}"/>
    <title>Panel de admin</title>
</head>

<body>
<a href="#list-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav row botones" role="navigation">
    <ul>
        <li><g:link action="index"><button
                class="col-md-4 col-sm-6 boton-adm btn btn-secondary">Ciudades</button></g:link></li>
    </ul>
    <ul>
        <li><g:link action="createNeighborhood"><button
                class="col-md-4 col-sm-6 boton-adm btn btn-secondary">Barrios</button></g:link></li>
    </ul>
    <ul>
        <li><g:link action="createTipoDenuncia"><button
                class="col-md-4 col-sm-6 boton-adm btn btn-secondary">Sujetos: tipos</button></g:link></li>
    </ul>
    <ul>
        <li><g:link action="createTipoSujeto"><button
                class="col-md-4 col-sm-6 boton-adm btn btn-secondary">Denuncias: tipos</button></g:link></li>
    </ul>
</div>
<div class="tabla">
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="name"
                              title="${message(code: 'city.label', default: 'Nombre')}" />

            <th>Descripcion</th>
            <th>Accion</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${cityInstanceList}" status="i" var="cityInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>
                    ${fieldValue(bean: cityInstance, field: "name")}
                </td>
                <td>
                    ${fieldValue(bean: cityInstance, field: "description")}
                </td>
                <td>

                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>