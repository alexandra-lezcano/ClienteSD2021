<h1>m ${fieldValue(bean:sujetoInstance?.tipo, field:"titulo")} </h1>
<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'nombre','error')}">
                    <label for="nombre">
                        Nombre: <g:textField name="nombre" value="${sujetoInstance?.nombre}"/>
                    </label>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="display:none;">
            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'ci','error')}">
                <label for="ci">
                    Ci: <g:textField name="ci" value="${sujetoInstance?.ci}"/>
                </label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'telefono','error')}">
                <label for="telefono">
                    Telefono: <g:textField name="telefono" value="${sujetoInstance?.telefono}"/>
                </label>
            </div>
        </div>

        <div class="col-md-6">
            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'correo','error')}">
                <label for="correo">
                    Correo: <g:textField name="correo" value="${sujetoInstance?.correo}"/>
                </label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="fieldcontain ${hasErrors(bean: sujetoInstance, field: 'direccion','error')}">
                <label for="direccion">
                    Direccion: <g:textField name="direccion" value="${sujetoInstance?.direccion}"/>
                </label>
            </div>
        </div>
    </div>
</div>