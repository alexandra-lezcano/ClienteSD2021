<table>
    <thead>
    <tr>
        <g:sortableColumn property="name"
                          title="${message(code: 'neighborhood.label', default: 'Nombre')}" />

        <th>Descripcion</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${neighborhoodInstanceList}" status="i" var="neighborhoodInstance">

        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                ${fieldValue(bean: neighborhoodInstance, field: "name")}
            </td>
            <td>
                ${fieldValue(bean: neighborhoodInstance, field: "description")}
            </td>
        </tr>
    </g:each>
    </tbody>
</table>