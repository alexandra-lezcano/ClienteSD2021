package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.Set;

public interface ICasosDerivadosService extends IBaseService<CasoDerivadoB, CasosDerivadosDTO> {


    public Set<DepEstadoB> newLista();
}

