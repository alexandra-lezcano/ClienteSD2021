<table class="table table-striped table-bordered tabla-options">
    <thead>
    <tr>

        <g:sortableColumn property="date"
                          title="${message(code: 'depEstado.label', default: 'Fecha')}" />

        <th>Description</th>
        <th>Accion</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${casosDerivadosInstanceList}" status="i" var="casosDerivadosInstance">


        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                <g:each in="${casosDerivadosInstance?.getDepEstadoBSet()}"  var="depEstadoInstance">

                    <g:link class="edit" action="edit" id="${depEstadoInstance.id}">
                        ${fieldValue(bean: depEstadoInstance, field: "nombre")}</g:link>
                </g:each>
            </td>

            <td>
                ${fieldValue(bean: casosDerivadosInstance, field: "description")}
            </td>
            <td>
                <g:link class="delete"
                        action="delete"
                        value="delete"
                        id="${casosDerivadosInstance?.id}"
                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                    Borrar
                </g:link>
                <g:link class="show" action="show" id="${casosDerivadosInstance?.id}">Ver detalles</g:link>

            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="pagination">
    <g:render template="/layouts/pagination" model="[prev: prev, sig:sig]"/>
</div>

</div>