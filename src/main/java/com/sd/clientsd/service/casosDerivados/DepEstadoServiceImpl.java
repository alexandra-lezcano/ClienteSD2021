package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.rest.CasosDerivados.IDepEstadoResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("depEstadoService")
public class DepEstadoServiceImpl extends BaseServiceImpl<DepEstadoB, DepEstadoDTO> implements IDepEstadoService {
    @Autowired
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
        final DepEstadoResult DepEstadoResult = depEstadoResource.getByPage(page);
        final List<DepEstadoDTO> dtosList = null == DepEstadoResult.getDepEstado()? new ArrayList<DepEstadoDTO>() : DepEstadoResult.getDepEstado();
        final List<DepEstadoB> beansList = new ArrayList<DepEstadoB>();

        dtosList.forEach(DepEstadoDTO -> beansList.add(convertToBean(DepEstadoDTO)));
        return beansList;
    }

    @Override
    public DepEstadoB getById(Integer id) {
        final DepEstadoDTO dto = depEstadoResource.getById(id);
        return convertToBean(dto);
    }
}
