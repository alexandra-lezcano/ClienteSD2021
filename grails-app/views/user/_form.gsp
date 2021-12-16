<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name','error')}">
    <label for="name">
        Nombre: <g:textField name="name" value="${userInstance?.name}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'surname','error')}">
    <label for="surname">
        Apellido: <g:textField name="surname" value="${userInstance?.surname}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'cn','error')}">
    <label for="cn">
        Cedula de Identidad: <g:textField name="cn" value="${userInstance?.cn}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'address','error')}">
    <label for="address">
        Direccion: <g:textField name="address" value="${userInstance?.address}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email','error')}">
    <label for="email">
        Correo Electronico: <g:textField name="email" value="${userInstance?.email}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'phone','error')}">
    <label for="phone">
        Numero de Telefono: <g:textField name="phone" value="${userInstance?.phone}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'city','error')}">
    <label for="city">
        Ciudad: <g:select id="city"
                          name="cityId"
                          from="${cityInstanceList}"
                          optionKey="id"
                          optionValue="name"
                          required=""
                          value="${userInstance?.city?.id}"
        />
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username','error')}">
    <label for="username">
       Username: <g:textField name="username" value="${userInstance?.username}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password','error')}">
    <label for="password">
        Username: <g:textField name="password" value="${userInstance?.password}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username','error')}">
    <label for="username">
       Username: <g:textField name="username" value="${userInstance?.username}"/>
    </label>
</div>
<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password','error')}">
    <label for="password">
        Password: <g:textField name="password" value="${userInstance?.password}"/>
    </label>
</div>

<div id="#insertNeighborhood">

</div>

<script>
  function go(){
    jQuery.ajax({
      url:'${g.createLink( controller:'user', action:'findNeighborhoodsByCity')}',
      data: {
          cityId: $("#city").val()
      },
      success: function(template){
          console.log("DENTRO DE AJAX");
          jQuery("#insertNeighborhood").innerHTML(template);
      }
    });
  }
</script>


