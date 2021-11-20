package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;


@Repository(value = "neighborhoodResource")
public class NeighborhoodResourceImpl extends BaseResourceImpl<NeighborhoodDTO> implements INeighborhoodResource {

    // todo agregar esto a un archivo de configuracion!
    public NeighborhoodResourceImpl() {
        super(NeighborhoodDTO.class, "/neighborhoods");
    }

    @Override
    public NeighborhoodResult getAll() {
        return getWebResource().get(NeighborhoodResult.class);
    }

    @Override
    public NeighborhoodResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(NeighborhoodResult.class);
    }
}