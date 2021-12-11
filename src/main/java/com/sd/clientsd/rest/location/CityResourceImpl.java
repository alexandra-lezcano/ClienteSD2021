package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value="cityResource")
public class CityResourceImpl extends BaseResourceImpl<CityDTO> implements ICityResource {
    //private static final String RESOURCE_PATH = Configurations.getCityResource();
    public CityResourceImpl(){
        super(CityDTO.class, "/cities");
    }

    @Override
    public CityResult getAll() {
        return getWebResource().get(CityResult.class);
    }

    @Override
    public CityResult getByPage(Integer pageNum) {
        CityResult cResult = new CityResult();

        if(getWebResource()!=null){
            Class<CityResult> cResultClass = CityResult.class;
            String path = "/page/"+pageNum;
            cResult = getWebResource().path(path).get(cResultClass);
        }
        return cResult;
    }

    @Override
    public NeighborhoodResult getNeighborhoodByCityId(Integer id) {
        return getWebResource().path("/"+id+"/neighborhoods").get(NeighborhoodResult.class);
    }
}
