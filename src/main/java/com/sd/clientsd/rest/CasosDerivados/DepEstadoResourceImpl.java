package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;

public class DepEstadoResourceImpl extends BaseResourceImpl<DepEstadoDTO> implements IDepEstadoResource{

    public DepEstadoResourceImpl(Class<DepEstadoDTO> depEstadoDTOClass, String resourcePath) {
        super(depEstadoDTOClass, resourcePath);
    }
    public DepEstadoDTO save(DepEstadoDTO dto) {
        DepEstadoDTO newDto = getWebResource().entity(dto).post(dto.getClass());
        return newDto;
    }

public DepEstadoResult getAll(){
    DepEstadoResult dependencias = getWebResource().get(DepEstadoResult.class);
    return dependencias;
}


}

