package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.rest.CasosDerivados.IDepEstadoResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DepEstadoService")
public class IDepEstadoServiceImpl extends BaseServiceImpl<DepEstadoB, DepEstadoDTO> implements IDepEstadoService {

    private IDepEstadoResource depEstadoResource;
    @Override
    protected DepEstadoDTO convertToDTO(DepEstadoB bean) {
        final DepEstadoDTO dto = new DepEstadoDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getNombre());
        dto.setDescription(bean.getDescripcion());
        return dto;
    }

    @Override
    protected DepEstadoB convertToBean(DepEstadoDTO dto) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("userName", dto.getName());
        params.put("subject", dto.getDescription());
        final DepEstadoB bean = new DepEstadoB(params);
        return bean;

    }

    @Override
    public DepEstadoB save(DepEstadoB bean) {
        final DepEstadoDTO depEstado= convertToDTO(bean);
        final DepEstadoDTO dto= depEstadoResource.save(depEstado);
        final DepEstadoB new_bean= convertToBean(dto);
        return bean;

    }

    public List<DepEstadoB> getAll() {

        final DepEstadoResult result = depEstadoResource.getAll();
//al parecer esto devuelve la lista  de dto obtenida en del result
        final List<DepEstadoDTO> depEstadoDTOList = null == result.getDepEstado() ? new ArrayList<DepEstadoDTO>()
                : result.getDepEstado();
        final List<DepEstadoB> dependencias = new ArrayList<DepEstadoB>();

        for (DepEstadoDTO dto : depEstadoDTOList) {
            final DepEstadoB depB = convertToBean(dto);
            dependencias.add(depB);
        }

        return dependencias;
    }
    @Override
    public List<DepEstadoB> getAll(Integer page) {
        return null;
    }

    @Override
    public DepEstadoB getById(Integer id) {
        final DepEstadoDTO dto = depEstadoResource.getById(id);
        return convertToBean(dto);
    }
}
