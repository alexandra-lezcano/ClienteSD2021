<table class="table table-striped table-bordered tabla-options">
    <thead>
    <tr>

        <g:sortableColumn property="name"
                          title="${message(code: 'depEstado.label', default: 'Nombre')}" />

        <th>Descripcion</th>
        <th>Accion</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${depEstadoInstanceList}" status="i" var="depEstadoInstance">

        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <g:link class="edit" action="edit" id="${depEstadoInstance?.id}">
                    ${fieldValue(bean: depEstadoInstance, field: "nombre")}</g:link>
            </td>
            <td>
                ${fieldValue(bean: depEstadoInstance, field: "descripcion")}
            </td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${depEstadoInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                    Borrar
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="pagination">
<g:render template="/layouts/pagination" model="[prev: prev, sig: sig, find:find]"/>
</div>