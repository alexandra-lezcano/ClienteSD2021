package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoResult;
import com.sd.clientsd.beans.denuncia.DenunciaEstadoB;
import com.sd.clientsd.rest.denuncia.IDenunciaEstadoResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="DenunciaEstadoService")
public class DenunciaEstadoServiceImpl extends BaseServiceImpl<DenunciaEstadoB, DenunciaEstadoDTO> implements IDenunciaEstadoService {

    @Autowired
    private IDenunciaEstadoResource denunciaEstadoResource;

    @Override
    protected DenunciaEstadoDTO convertToDTO(DenunciaEstadoB bean) {
        final DenunciaEstadoDTO dto = new DenunciaEstadoDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setNombre(bean.getNombre());
        return dto;
    }

    @Override
    protected DenunciaEstadoB convertToBean(DenunciaEstadoDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("nombre", dto.getNombre());
        final DenunciaEstadoB bean = new DenunciaEstadoB(params);
        return bean;
    }

    @Override
    public DenunciaEstadoB save(DenunciaEstadoB bean) {
        final DenunciaEstadoDTO dto = convertToDTO(bean);
        final DenunciaEstadoDTO estadoDto = denunciaEstadoResource.save(dto);
        final DenunciaEstadoB denunciaEstadoB = convertToBean(estadoDto);
        return denunciaEstadoB;
    }

    @Override
    public List<DenunciaEstadoB> getAll(Integer page) {
        final DenunciaEstadoResult denunciaEstadoResult = denunciaEstadoResource.getByPage(page);
        final List<DenunciaEstadoDTO> dtoList = null == denunciaEstadoResult.getDenunciaEstados() ? new ArrayList<>() : denunciaEstadoResult.getDenunciaEstados();
        final List<DenunciaEstadoB> beansList = new ArrayList<>();
        dtoList.forEach(denunciaEstadoDTO -> beansList.add(convertToBean(denunciaEstadoDTO)));
        return beansList;
    }

    @Override
    public List<DenunciaEstadoB> getAll(Integer page, Integer size) {
        final DenunciaEstadoResult denunciaEstadoResult = denunciaEstadoResource.getByPage(page, size);
        final List<DenunciaEstadoDTO> dtoList = null == denunciaEstadoResult.getDenunciaEstados() ? new ArrayList<>() : denunciaEstadoResult.getDenunciaEstados();
        final List<DenunciaEstadoB> beansList = new ArrayList<>();
        dtoList.forEach(denunciaEstadoDTO -> beansList.add(convertToBean(denunciaEstadoDTO)));
        return beansList;
    }

    @Override
    public List<DenunciaEstadoB> getAll() {
        final DenunciaEstadoResult denunciaEstadoResult = denunciaEstadoResource.getByPage();
        final List<DenunciaEstadoDTO> dtoList = null == denunciaEstadoResult.getDenunciaEstados() ? new ArrayList<>() : denunciaEstadoResult.getDenunciaEstados();
        final List<DenunciaEstadoB> beansList = new ArrayList<>();
        dtoList.forEach(denunciaEstadoDTO -> beansList.add(convertToBean(denunciaEstadoDTO)));
        return beansList;
    }

    @Override
    public DenunciaEstadoB getById(Integer id) {
        final DenunciaEstadoDTO denunciaEstadoDTO = denunciaEstadoResource.getById(id);
        return convertToBean(denunciaEstadoDTO);
    }

    @Override
    public DenunciaEstadoB update(DenunciaEstadoB bean, Integer id) {
        final DenunciaEstadoDTO dto = convertToDTO(bean);
        final DenunciaEstadoDTO updated = denunciaEstadoResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    public DenunciaEstadoB delete(Integer id) {
        final DenunciaEstadoDTO deleted = denunciaEstadoResource.delete(id);
        return convertToBean(deleted);
    }
}
