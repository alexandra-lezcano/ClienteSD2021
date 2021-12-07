package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="depEstadoResource")
public class DepEstadoResourceImpl extends BaseResourceImpl<DepEstadoDTO> implements IDepEstadoResource {
    public DepEstadoResourceImpl() {
        super(DepEstadoDTO.class, "/depEstado");
    }

    @Override
    public DepEstadoResult getAll() {
        return getWebResource().path("/").get(DepEstadoResult.class);
    }

    @Override
    public DepEstadoResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(DepEstadoResult.class);
    }
}
