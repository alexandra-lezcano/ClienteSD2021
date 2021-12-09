package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.rest.denuncia.ITipoDenunciaResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.service.location.ICityService;
import com.sd.clientsd.service.location.INeighborhoodService;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "neighborhoodResource")
public class NeighborhoodResourceImpl extends BaseResourceImpl<NeighborhoodDTO> implements INeighborhoodResource {
    private static final String RESOURCE_PATH = Configurations.getNeighborhoodResource();

    public NeighborhoodResourceImpl() {
        super(NeighborhoodDTO.class, RESOURCE_PATH);
    }

    @Override
    public NeighborhoodResult getAll() {
        return getWebResource().get(NeighborhoodResult.class);
    }

    @Override
    public NeighborhoodResult getByPage(Integer pageNum) {
        NeighborhoodResult nResult = new NeighborhoodResult();

        if(getWebResource()!=null){
            Class<NeighborhoodResult> nResultClass = NeighborhoodResult.class;
            String path = "/page/"+pageNum;
            nResult = getWebResource().path(path).get(nResultClass);
        }
        return nResult;
    }

    @Override
    public NeighborhoodResult getByPage(Integer pagenum, Integer size) {
        NeighborhoodResult nResult = new NeighborhoodResult();

        if(getWebResource()!=null){
            Class<NeighborhoodResult> nResultClass = NeighborhoodResult.class;
            String path = "/page/"+pagenum+"/"+size;
            nResult = getWebResource().path(path).get(nResultClass);
        }
        return nResult;
    }

    @Override
    public NeighborhoodResult getBypage() {
        NeighborhoodResult nResult = new NeighborhoodResult();

        if(getWebResource()!=null){
            Class<NeighborhoodResult> nResultClass = NeighborhoodResult.class;
            String path = "/page";
            nResult = getWebResource().path(path).get(nResultClass);
        }
        return nResult;
    }
}