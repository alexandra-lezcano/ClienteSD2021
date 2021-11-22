package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface ICasosDerivadosResource extends IBaseResource<CasosDerivadosDTO> {
    public CasosDerivadosResult getAll();
    public CasosDerivadosResult getByPage(Integer pageNum);
}
