package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value="cityResource")
public class CityResourceImpl extends BaseResourceImpl<CityDTO> implements ICityResource {
    private static final String RESOURCE_PATH = Configurations.getCityResource();
    public CityResourceImpl(){
        super(CityDTO.class, RESOURCE_PATH);
    }

    @Override
    public CityResult getAll() {
System.out.println("123");
        setWebResourceBasicAuthFilter();
        return getWebResource().get(CityResult.class);
    }

    @Override
    public CityResult getByPage(Integer pageNum) {
        setWebResourceBasicAuthFilter();
        CityResult cResult = new CityResult();

        if(getWebResource()!=null){
            Class<CityResult> cResultClass = CityResult.class;
            String path = "/page/"+pageNum;
            cResult = getWebResource().path(path).get(cResultClass);
        }
        return cResult;
    }

    @Override
    public CityResult getByPage(Integer pageNum, Integer size) {
        setWebResourceBasicAuthFilter();
        CityResult cResult = new CityResult();

        if(getWebResource()!=null){
            Class<CityResult> cResultClass = CityResult.class;
            String path = "/page/"+pageNum+"/"+size;
            cResult = getWebResource().path(path).get(cResultClass);
        }
        return cResult;
    }

    @Override
    public CityResult getByPage() {
        setWebResourceBasicAuthFilter();
        CityResult cResult = new CityResult();

        if(getWebResource()!=null){
            Class<CityResult> cResultClass = CityResult.class;
            String path = "/page/";
            cResult = getWebResource().path(path).get(cResultClass);
        }
        return cResult;
    }

    @Override
    public NeighborhoodResult getNeighborhoodByCityId(Integer id) {

        return getWebResource().path("/"+id+"/neighborhoods").get(NeighborhoodResult.class);
    }
}
