package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface IDepEstadoResource extends IBaseResource<DepEstadoDTO> {
    public DepEstadoResult getAll();
    public DepEstadoResult getByPage(Integer pageNum);
    public DepEstadoResult getByPage(Integer page, Integer size);
    public DepEstadoResult getByPage();
    public DepEstadoResult getAllByName(String name, Integer page);
}
