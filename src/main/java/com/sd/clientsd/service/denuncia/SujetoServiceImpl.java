package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.beans.denuncia.SujetoB;
import com.sd.clientsd.rest.denuncia.ISujetoresource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "SujetoService")
public class SujetoServiceImpl extends BaseServiceImpl<SujetoB, SujetoDto> implements ISujetoService {

    @Autowired
    private ISujetoresource sujetoResource;
    @Autowired
    private ITipoSujetoService tipoSujetoService;

    @Override
    protected SujetoDto convertToDTO(SujetoB bean) {
        final SujetoDto dto = new SujetoDto();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setNombre(bean.getNombre());
        dto.setTipo_id(bean.getTipo().getId());
        dto.setDireccion(bean.getDireccion());
        dto.setCi(bean.getCi());
        dto.setTelefono(bean.getTelefono());
        dto.setCorreo(bean.getCorreo());
        return dto;
    }

    @Override
    protected SujetoB convertToBean(SujetoDto dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("nombre", dto.getNombre());
        params.put("ci", dto.getCi());
        params.put("direccion", dto.getDireccion());
        params.put("telefono",dto.getTelefono());
        params.put("correo", dto.getTelefono());
        params.put("tipo", dto.getTipo_id().toString());

        final SujetoB bean = new SujetoB(params);
        bean.setTipo(tipoSujetoService.getById(dto.getTipo_id()));
        return bean;
    }

    @Override
    public SujetoB save(SujetoB bean) {
        final SujetoDto dto = convertToDTO(bean);
        final SujetoDto sujetoDto  = sujetoResource.save(dto);
        final SujetoB sujetoB = convertToBean(sujetoDto);
        return sujetoB;
    }

    @Override
    public List<SujetoB> getAll(Integer page) {
        final SujetoResult sujetoResult = sujetoResource.getByPage(page);
        final List<SujetoDto> dtosList = null == sujetoResult.getSujetos() ? new ArrayList<>() : sujetoResult.getSujetos();
        final List<SujetoB> beansList = new ArrayList<>();
        dtosList.forEach(sujetoDto -> beansList.add(convertToBean(sujetoDto)));
        return beansList;
    }

    @Override
    public SujetoB getById(Integer id) {
        final SujetoDto sujetoDto = sujetoResource.getById(id);
        return convertToBean(sujetoDto);
    }

    @Override
    public SujetoB update(SujetoB bean, Integer id) {
        final SujetoDto dto = convertToDTO(bean);
        final SujetoDto updated = sujetoResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    public SujetoB delete(Integer id) {
        final SujetoDto deleted = sujetoResource.delete(id);
        return convertToBean(deleted);
    }

}
