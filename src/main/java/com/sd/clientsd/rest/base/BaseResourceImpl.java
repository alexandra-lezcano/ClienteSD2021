package com.sd.clientsd.rest.base;

import com.protectionapp.sd2021.dto.base.BaseDTO;
import com.sd.clientsd.service.login.IAuthService;
import com.sd.clientsd.utils.config.Configurations;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResourceImpl <DTO extends BaseDTO> implements IBaseResource<DTO>{

    private final String resourcePath;
    private final Class<DTO> dtoClass;
    private final WebResource webResource;
    @Autowired
    private IAuthService authService;
    //private static final String BASE_URL = "http://localhost:8080";
    private static final String BASE_URL = Configurations.getBaseUrl();


    public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {

        final Client jerseyClient = Client.create();
        this.resourcePath =  BASE_URL + resourcePath;
        this.dtoClass = dtoClass;
        this.webResource = jerseyClient.resource(this.resourcePath);
    }

    protected WebResource getWebResource(){


        return this.webResource;
    }

    protected Class getDtoClass(){

        return this.dtoClass;
    }

    /* Ejemplo:
    *     CityDTO response = getJerseyClient().resource(getBaseUrl()+pathToResource).entity(cityTest).post(CityDTO.class);
    *  Esto es como el cliente va a hacer un post*/
    @Override
    public DTO save(DTO dto){
        setWebResourceBasicAuthFilter();
        //return getWebResource().entity(dto).post(getDtoClass()); // tira error, pide que haga cast a DTO
        return getWebResource().entity(dto).post(this.dtoClass);
    }

    @Override
    public DTO getById(Integer id) {
        // por ahora asumo que voy a crear un Resource con el path ya incluyendo un id
        return getWebResource().path("/"+id).get(this.dtoClass);
    }

    @Override
    public DTO update(DTO dto, Integer id) {
        setWebResourceBasicAuthFilter();
        // ej: getJerseyClient().resource(getBaseUrl()+pathToResource+"/1").entity(cityTest).put(CityDTO.class)
        return getWebResource().path("/"+id).entity(dto).put(this.dtoClass);
    }

    @Override
    public DTO delete(Integer id) {
        setWebResourceBasicAuthFilter();
        // ej: getJerseyClient().resource(getBaseUrl()+pathToResource+"/"+id).delete(UserDTO.class);
        return getWebResource().path("/"+id).delete(this.dtoClass);
    }
    /* Este método se encarga de establecer un usuario y contraseña en la cabecera del request
     * del webResource, lo que le permite autenticarse para acceder a los recursos del webService
     * El web service esta configurado para requerir un tipo de autenticación básica la cual se
     * establece en este método
     * Este método se usa siempre antes de llamar al método getWebResource() en todas las clases ResourceImpl
     * menos las clases ResourceImpl de user y role, en donde authService provocaría un fallo
     * ya que authService requiere que el usuario este logueado para que pueda funcionar
     */
    public void setWebResourceBasicAuthFilter(){

        String u = authService.getUsername();

        String p = authService.getPassword();
        this.webResource.addFilter(new HTTPBasicAuthFilter(u,p));
    }





}
