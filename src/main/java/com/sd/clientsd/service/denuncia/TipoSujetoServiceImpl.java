package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.beans.denuncia.TipoSujetoB;
import com.sd.clientsd.rest.denuncia.ITipoSujetoResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
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

@Service(value="TipoSujetoService")
public class TipoSujetoServiceImpl extends BaseServiceImpl<TipoSujetoB, TipoSujetoDTO> implements ITipoSujetoService {

    @Autowired
    private ITipoSujetoResource tipoSujetoResource;

    @Autowired
    private CacheManager cacheManager;

    @Override
    protected TipoSujetoDTO convertToDTO(TipoSujetoB bean) {
        final TipoSujetoDTO dto = new TipoSujetoDTO();
        if(bean.getId()!= 0){
            dto.setId(bean.getId());
        }

        dto.setNombre(bean.getTitulo());
        return dto;
    }

    @Override
    protected TipoSujetoB convertToBean(TipoSujetoDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("titulo", dto.getNombre());
        final TipoSujetoB bean = new TipoSujetoB(params);
        return bean;
    }

    @Override
    public TipoSujetoB save(TipoSujetoB bean) {
        final TipoSujetoDTO dto = convertToDTO(bean);
        final TipoSujetoDTO tipoSujetoDTO = tipoSujetoResource.save(dto);
        final TipoSujetoB tipoSujetoB = convertToBean(tipoSujetoDTO);
        cacheManager.getCache(Configurations.CACHE_NAME).put("web_tipo_sujeto_"+tipoSujetoB.getId(), tipoSujetoB);
        return tipoSujetoB;
    }

    @Override
    public List<TipoSujetoB> getAll(Integer page) {
        TipoSujetoResult tipoSujetoResult = tipoSujetoResource.getByPage(page);
        List<TipoSujetoDTO> dtosList = new ArrayList<TipoSujetoDTO>();

        if(tipoSujetoResult.getTipoSujetos()!=null) dtosList = tipoSujetoResult.getTipoSujetos();

        final List<TipoSujetoB> beansList = new ArrayList<TipoSujetoB>();

        dtosList.forEach(tipoSujetoDTO -> beansList.add(convertToBean(tipoSujetoDTO)));
        return beansList;
    }

    @Override
    public List<TipoSujetoB> getAll(Integer page, Integer size) {
        TipoSujetoResult tipoSujetoResult = tipoSujetoResource.getByPage(page, size);
        List<TipoSujetoDTO> dtosList = new ArrayList<TipoSujetoDTO>();

        if(tipoSujetoResult.getTipoSujetos()!=null) dtosList = tipoSujetoResult.getTipoSujetos();

        final List<TipoSujetoB> beansList = new ArrayList<TipoSujetoB>();

        dtosList.forEach(tipoSujetoDTO -> beansList.add(convertToBean(tipoSujetoDTO)));
        return beansList;
    }

    @Override
    public List<TipoSujetoB> getAll() {
        TipoSujetoResult tipoSujetoResult = tipoSujetoResource.getByPage();
        List<TipoSujetoDTO> dtosList = new ArrayList<TipoSujetoDTO>();

        if(tipoSujetoResult.getTipoSujetos()!=null) dtosList = tipoSujetoResult.getTipoSujetos();

        final List<TipoSujetoB> beansList = new ArrayList<TipoSujetoB>();

        dtosList.forEach(tipoSujetoDTO -> beansList.add(convertToBean(tipoSujetoDTO)));
        return beansList;
    }

    public List<TipoSujetoB> getAllNotPage() {
        final TipoSujetoResult tipoSujetoResult = new TipoSujetoResult();
        final List<TipoSujetoDTO> dtosList = null == tipoSujetoResult.getTipoSujetos() ? new ArrayList<TipoSujetoDTO>() : tipoSujetoResult.getTipoSujetos();
        final List<TipoSujetoB> beansList = new ArrayList<TipoSujetoB>();

        dtosList.forEach(tipoSujetoDTO -> beansList.add(convertToBean(tipoSujetoDTO)));
        return beansList;
    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_tipo_sujeto_'+#id")
    public TipoSujetoB getById(Integer id) {
        final TipoSujetoDTO tipoSujetoDTO = tipoSujetoResource.getById(id);
        return convertToBean(tipoSujetoDTO);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_tipo_sujeto_'+#id")
    public TipoSujetoB update(TipoSujetoB bean, Integer id) {
        final TipoSujetoDTO dto = convertToDTO(bean);
        final TipoSujetoDTO updated = tipoSujetoResource.update(dto,id);
        return convertToBean(updated);
    }

    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_tipo_sujeto_'+#id")
    public TipoSujetoB delete(Integer id) {
        final TipoSujetoDTO deleted = tipoSujetoResource.delete(id);
        return convertToBean(deleted);
    }
}
