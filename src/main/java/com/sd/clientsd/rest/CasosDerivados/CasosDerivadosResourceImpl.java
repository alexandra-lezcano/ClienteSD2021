package com.sd.clientsd.rest.CasosDerivados;


import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="casosDerivadosResource")
public class CasosDerivadosResourceImpl  extends BaseResourceImpl<CasosDerivadosDTO> implements ICasosDerivadosResource {
    public CasosDerivadosResourceImpl() {
        super(CasosDerivadosDTO.class, "/casosDerivados");
    }

    @Override
    public CasosDerivadosResult getAll() {
        return getWebResource().get(CasosDerivadosResult.class);
    }

    @Override
    public CasosDerivadosResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(CasosDerivadosResult.class);
    }
}

