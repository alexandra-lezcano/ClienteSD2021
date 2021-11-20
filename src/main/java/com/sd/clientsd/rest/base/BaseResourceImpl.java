package com.sd.clientsd.rest.base;

import com.protectionapp.sd2021.dto.base.BaseDTO;
import com.sd.clientsd.utils.config.Configurations;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public abstract class BaseResourceImpl <DTO extends BaseDTO> implements IBaseResource<DTO>{

    private final String resourcePath;
    private final Class<DTO> dtoClass;
    private final WebResource webResource;
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
        // ej: getJerseyClient().resource(getBaseUrl()+pathToResource+"/1").entity(cityTest).put(CityDTO.class)
        return getWebResource().path("/"+id).entity(dto).put(this.dtoClass);
    }

    @Override
    public DTO delete(Integer id) {
        // ej: getJerseyClient().resource(getBaseUrl()+pathToResource+"/"+id).delete(UserDTO.class);
        return getWebResource().path("/"+id).delete(this.dtoClass);
    }
}
