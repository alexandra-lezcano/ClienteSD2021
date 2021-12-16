package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.beans.denuncia.SujetoB;
import com.sd.clientsd.rest.denuncia.ISujetoresource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.hibernate.validator.constraints.LuhnCheck;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private IDenunciaService denunciaService;
    @Override
    protected SujetoDto convertToDTO(SujetoB bean) {
        final SujetoDto dto = new SujetoDto();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setNombre(bean.getNombre());
        dto.setTipoId(bean.getTipo().getId());
        dto.setDireccion(bean.getDireccion());
        dto.setCi(bean.getCi());
        dto.setTelefono(bean.getTelefono());
        dto.setCorreo(bean.getCorreo());

        if(bean.getDenuncia()!=null) { dto.setDenunciaId(bean.getDenuncia().getId()); }
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
        params.put("tipo", dto.getTipoId().toString());
        final SujetoB bean = new SujetoB(params);
        bean.setTipo(tipoSujetoService.getById(dto.getTipoId()));
        if (dto.getDenunciaId()!=null){ bean.setDenuncia(denunciaService.getById(dto.getDenunciaId())); }
        return bean;
    }

    @Override
    public SujetoB save(SujetoB bean) {
        final SujetoDto dto = convertToDTO(bean);
        final SujetoDto sujetoDto  = sujetoResource.save(dto);
        final SujetoB sujetoB = convertToBean(sujetoDto);
        cacheManager.getCache(Configurations.CACHE_NAME).put("web_sujeto_"+sujetoB.getId(), sujetoB);
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
    public List<SujetoB> getAll(Integer page, Integer size) {
        final SujetoResult sujetoResult = sujetoResource.getByPage(page, size);
        final List<SujetoDto> dtosList = null == sujetoResult.getSujetos() ? new ArrayList<>() : sujetoResult.getSujetos();
        final List<SujetoB> beansList = new ArrayList<>();
        dtosList.forEach(sujetoDto -> beansList.add(convertToBean(sujetoDto)));
        return beansList;
    }

    @Override
    public List<SujetoB> getAll() {
        final SujetoResult sujetoResult = sujetoResource.getByPage();
        final List<SujetoDto> dtosList = null == sujetoResult.getSujetos() ? new ArrayList<>() : sujetoResult.getSujetos();
        final List<SujetoB> beansList = new ArrayList<>();
        dtosList.forEach(sujetoDto -> beansList.add(convertToBean(sujetoDto)));
        return beansList;
    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_sujeto_'+#id")
    public SujetoB getById(Integer id) {
        final SujetoDto sujetoDto = sujetoResource.getById(id);
        return convertToBean(sujetoDto);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_sujeto_'+#id")
    public SujetoB update(SujetoB bean, Integer id) {
        final SujetoDto dto = convertToDTO(bean);
        final SujetoDto updated = sujetoResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_sujeto_'+#id")
    public SujetoB delete(Integer id) {
        final SujetoDto deleted = sujetoResource.delete(id);
        return convertToBean(deleted);
    }

    public List<SujetoB> newList(){
        final List<SujetoB> ret = new ArrayList<>();
        return ret;
    }
}
