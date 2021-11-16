package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;

import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepEstadoService")
public class IDepEstadoServiceImpl extends BaseServiceImpl<DepEstadoB, DepEstadoDTO> implements IDepEstadoService {


    @Override
    protected DepEstadoDTO convertToDTO(DepEstadoB bean) {
        return null;
    }

    @Override
    protected DepEstadoB convertToBean(DepEstadoDTO dto) {
        return null;
    }

    @Override
    public DepEstadoB save(DepEstadoB bean) {
        return null;
    }

    @Override
    public List<DepEstadoB> getAll(Integer page) {
        return null;
    }

    @Override
    public DepEstadoB getById(Integer id) {
        return null;
    }
}
