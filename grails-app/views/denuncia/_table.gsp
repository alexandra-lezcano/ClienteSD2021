<table class="table table-striped table-bordered tabla-options">
    <thead>
    <tr>
        <g:sortableColumn property="codigo"
                          title="${message(code: 'denuncia.label', default: 'Codigo')}" />

        <th>Descripcion</th>
        <th>Fecha</th>
        <th>Estado</th>
        <th>Accion</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${denunciaInstanceList}" status="i" var="denunciaInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <g:link class="edit" action="edit" id="${denunciaInstance?.id}">
                    ${fieldValue(bean: denunciaInstance, field: "codigo")}</g:link>
            </td>
            <td>
                ${fieldValue(bean: denunciaInstance, field: "descripcion")}
            </td>
            <td>
                ${fieldValue(bean: denunciaInstance, field: "fecha")}
            </td>
            <td>
                ${fieldValue(bean: denunciaInstance, field: "estado.nombre")}
            </td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${denunciaInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                    Borrar
                </g:link>
                <g:link class="" resource="casosDerivados" action="create"> | Crear Caso Derivado</g:link>

            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="pagination">
    <g:render template="/layouts/pagination" model="[prev: prev, sig:sig]"/>
</div>
