
<div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'city', 'error')} required">
    <label for="city">
        <g:message code="neighborhood.city.label" default="City" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="city" name="city_id" from="${cities}" optionKey="id" optionValue="name" required="" value="${neighborhoodInstance?.city_id?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="neighborhood.name.label" default="Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${stateInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: neighborhoodInstance, field: 'description', 'error')} required">
    <label for="name">
        <g:message code="neighborhood.description.label" default="Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" maxlength="50" required="" value="${neighborhoodInstance?.description}"/>
</div>
