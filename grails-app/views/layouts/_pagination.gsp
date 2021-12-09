<div class="text-right">
    <g:form action="list">
        <g:hiddenField name="text" value="${text}" />
        <fieldset class="buttons pagination">
                <g:if test="${prev != -1}">
                    <g:link class="fa fa-arrow-left" action="list" params="[page: prev]">Anterior</g:link>
                </g:if>
                <g:if test="${sig != -1}">
                    <g:link class="fa fa-arrow-right" action="list" params="[page: sig]">Siguiente</g:link>
                </g:if>
        </fieldset>
    </g:form>
</div>