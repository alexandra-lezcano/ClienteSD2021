package com.sd.clientsd.service.investigacion;

import com.protectionapp.sd2021.dto.investigacion.InvestigacionDTO;
import com.protectionapp.sd2021.dto.investigacion.InvestigacionResult;
import com.sd.clientsd.beans.investigacion.InvestigacionB;
import com.sd.clientsd.rest.investigacion.IInvestigacionResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.service.denuncia.IDenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="investigacionService")
public class InvestigacionServiceImpl extends BaseServiceImpl<InvestigacionB, InvestigacionDTO> implements IInvestigacionService {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private IDenunciaService denunciaService;
    @Autowired
    private IInvestigacionResource investigacionResource;

    @Override
    protected InvestigacionDTO convertToDTO(InvestigacionB bean) {
        final InvestigacionDTO dto = new InvestigacionDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setDescripcion(bean.getDescripcion());
        dto.setFechaFin(bean.getFecha_fin());
        dto.setFechaInicio(bean.getFecha_inicio());
        dto.setDenunciaId(bean.getDenuncia_id().getId());
        return dto;
    }

    @Override
    protected InvestigacionB convertToBean(InvestigacionDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("descripcion",String.valueOf(dto.getDescripcion()));
        params.put("fecha_inicio", String.valueOf(dto.getFechaInicio()));
        params.put("fecha_fin", String.valueOf(dto.getFechaFin()));
        final InvestigacionB bean = new InvestigacionB();
        if(dto.getDenunciaId()!=0){
            bean.setDenuncia_id(denunciaService.getById(dto.getDenunciaId()));
        }
        return bean;
    }

    @Override
    public InvestigacionB save(InvestigacionB bean) {
        final InvestigacionDTO dto = convertToDTO(bean);
        final InvestigacionDTO investigacionDTO = investigacionResource.save(dto);
        final InvestigacionB investigacionB = convertToBean(investigacionDTO);
        return investigacionB;
    }

    @Override
    public List<InvestigacionB> getAll(Integer page) {
        InvestigacionResult investigacionResult = investigacionResource.getByPage(page);
        List<InvestigacionDTO> dtosList = new ArrayList<>();
        if(investigacionResult.getInvestigaciones()!=null) dtosList = investigacionResult.getInvestigaciones();
        final List<InvestigacionB> beanList = new ArrayList<>();
        dtosList.forEach(investigacionDTO -> beanList.add(convertToBean(investigacionDTO)));
        return beanList;
    }

    @Override
    public List<InvestigacionB> getAll(Integer page, Integer size) {
        return this.getAll(page);
    }

    @Override
    public List<InvestigacionB> getAll() {
        return this.getAll(0);
    }

    @Override
    public InvestigacionB getById(Integer id) {
        final InvestigacionDTO investigacionDTO = investigacionResource.getById(id);
        return convertToBean(investigacionDTO);
    }

    @Override
    public InvestigacionB update(InvestigacionB bean, Integer id) {
        final InvestigacionDTO dto = convertToDTO(bean);
        final InvestigacionDTO updated = investigacionResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    public InvestigacionB delete(Integer id) {
        final InvestigacionDTO deleted = investigacionResource.delete(id);
        return convertToBean(deleted);
    }
}
