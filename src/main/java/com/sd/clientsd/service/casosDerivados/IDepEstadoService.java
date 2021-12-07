package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface IDepEstadoService extends IBaseService<DepEstadoB, DepEstadoDTO> {

    public List<DepEstadoB> getAllNotPaged();

}
