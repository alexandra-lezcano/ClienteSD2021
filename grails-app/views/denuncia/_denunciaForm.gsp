<div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'city','error')}">
    <label for="city">
        Ciudad: <g:select id="city" name="city" from="${cityInstanceList}" optionKey="id" optionValue="name" value="${denunciaInstance?.city?.id}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'neighborhood','error')}">
    <label for="neighborhoods">
        Barrio: <g:select id="neighborhoods" name="neighborhood" from="${neighborhoodInstanceList}" optionKey="id" optionValue="name" required="" value="${denunciaInstance?.neighborhood?.id}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: denunciaInstance, field: 'descripcion','error')}">
    <label for="descripcion">
        Describa los hechos: <g:textField name="descripcion" value="${denunciaInstance?.descripcion}"/>
    </label>
</div>