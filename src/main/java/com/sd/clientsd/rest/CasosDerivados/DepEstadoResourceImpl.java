package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value = "depEstadoResource")
public class DepEstadoResourceImpl extends BaseResourceImpl<DepEstadoDTO> implements IDepEstadoResource{





    public DepEstadoResourceImpl() {
        super(DepEstadoDTO.class, "/depEstado");

    }
    public DepEstadoDTO save(DepEstadoDTO dto) {
        DepEstadoDTO newDto = getWebResource().entity(dto).post(dto.getClass());
        return newDto;
    }

    public DepEstadoResult getAll(Integer page){
        final DepEstadoResult result = getWebResource().path("/page/"+page).get(DepEstadoResult.class);
        return result;
}

    public DepEstadoResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(DepEstadoResult.class);
    }

public DepEstadoResult getAll(){
    DepEstadoResult dependencias = getWebResource().get(DepEstadoResult.class);
    return dependencias;
}


}

