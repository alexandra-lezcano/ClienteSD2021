package com.sd.clientsd.rest.CasosDerivados;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.sd.clientsd.rest.base.IBaseResource;
public interface IDepEstadoResource extends IBaseResource<DepEstadoDTO> {
    public DepEstadoResult getAll();


}
