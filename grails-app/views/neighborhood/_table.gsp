<table class="table table-striped table-bordered tabla-options">
       <thead>
       <tr>
<g:sortableColumn property="name"
                  title="${message(code: 'neighborhood.label', default: 'Nombre')}" />

<th>Descripcion</th>
<th>Ciudad</th>
<th>Accion</th>
</tr>
</thead>
    <tbody  id="update-find" >
<g:each in="${neighborhoodInstanceList}" status="i" var="neighborhoodInstance">

    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
        <td>
            <g:link class="edit" action="edit" id="${neighborhoodInstance?.id}">
                ${fieldValue(bean: neighborhoodInstance, field: "name")}</g:link>
        </td>
        <td>
            ${fieldValue(bean: neighborhoodInstance, field: "description")}
        </td>
        <td>
            ${fieldValue(bean: neighborhoodInstance, field: "city_id.name")}
        </td>
        <td>
            <g:link class="delete"
                    action="delete"
                    value="delete"
                    id="${neighborhoodInstance?.id}"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Seguro que quiere borrar?')}');">
                Borrar
            </g:link>
        </td>
    </tr>
</g:each>
    </tbody>
</table>
<div id="pagination">
    <g:render template="/layouts/pagination" model="[prev: prev, sig:sig, find: find]"/>
</div>
