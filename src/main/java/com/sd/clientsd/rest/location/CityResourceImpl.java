package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="cityResource")
public class CityResourceImpl extends BaseResourceImpl<CityDTO> implements ICityResource {
    public CityResourceImpl(){
        super(CityDTO.class, "/cities");
    }

    @Override
    public CityResult getAll() {
        return getWebResource().get(CityResult.class);
    }

    @Override
    public CityResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(CityResult.class);
    }
}
