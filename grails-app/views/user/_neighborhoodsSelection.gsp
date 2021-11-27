<!-- Render de un dropdown luego de que una ciudad sea seleccionada  -->

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'neighborhoods','error')}">
    <label for="neighborhoods">
        Barrios: <g:select name="neighborhoods"
                           from="${neighborhoodInstanceList}"
                           optionKey="id"
                           optionValue="name"
                           multiple="true"
                           value="${userInstance?.neighborhoods*.id}"
        />
    </label>
</div>