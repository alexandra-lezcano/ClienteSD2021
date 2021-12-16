<table class="table table-striped table-bordered tabla-options">
    <thead>
    <tr>
        <g:sortableColumn property="name"
                          title="${message(code: 'investigacion.label', default: 'Descripcion')}" />

        <th>Descripcion</th>
        <th>Fecha Incicio</th>
        <th>Fecha Fin</th>
        <th>Accion</th>
    </tr>
    </thead>
    <tbody  id="update-find" >
    <g:each in="${investigacionInstanceList}" status="i" var="investigacionInstance">

        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <g:link class="edit" action="edit" id="${investigacionInstance?.id}">
                    ${fieldValue(bean:investigacionInstance, field: "descripcion")}</g:link>
            </td>
            <td>
                ${fieldValue(bean: investigacionInstance, field: "fecha_inicio")}
            </td>
            <td>
                ${fieldValue(bean: investigacionInstance, field: "fecha_fin")}
            </td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${investigacionInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                    Borrar
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="pagination">
    <g:render template="/layouts/pagination" model="[prev: prev, sig:sig]"/>
</div>