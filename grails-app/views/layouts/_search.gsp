<label for="search-value">
    <input type='text' name="text" id="search-value" class="col-md-8 col-sm-12" value="${find}"/>
</label>
<button class="btn btn-info" name="search" value="Buscar" onclick="searchChanged(document.getElementById('search-value').value)">
    Buscar
</button>