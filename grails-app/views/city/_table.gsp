<table class="table table-striped table-bordered tabla-options">
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
                <g:link class="edit" action="edit" id="${cityInstance?.id}">
                    ${fieldValue(bean: cityInstance, field: "name")}</g:link>
            </td>
            <td>
                ${fieldValue(bean: cityInstance, field: "description")}
            </td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${cityInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                    Borrar
                </g:link> |
                <g:link class="show" action="show" id="${cityInstance?.id}">Ver detalles</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="pagination">
    <g:render template="/layouts/pagination" model="[prev: prev, sig:sig, find: find]"/>
</div>
