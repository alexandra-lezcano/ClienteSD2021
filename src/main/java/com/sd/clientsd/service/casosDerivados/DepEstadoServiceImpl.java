package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.rest.CasosDerivados.IDepEstadoResource;
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

@Service("depEstadoService")
public class DepEstadoServiceImpl extends BaseServiceImpl<DepEstadoB, DepEstadoDTO>implements IDepEstadoService {

    @Autowired
    private IDepEstadoResource depEstadoResource;

    @Autowired
    private CacheManager cacheManager;

    @Override
    protected DepEstadoDTO convertToDTO(DepEstadoB bean) {
        final DepEstadoDTO dto = new DepEstadoDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setName(bean.getNombre());
        dto.setDescription(bean.getDescripcion());
        return dto;
    }

    @Override
    protected DepEstadoB convertToBean(DepEstadoDTO dto) {
        final Map<String,String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("name",dto.getName());
        params.put("description", dto.getDescription());

        final DepEstadoB bean= new DepEstadoB(params);
        return bean;

    }

    @Override
    public DepEstadoB save(DepEstadoB bean) {
        final DepEstadoDTO dto= convertToDTO(bean);
        final DepEstadoDTO depEstado= depEstadoResource.save(dto);
        final DepEstadoB depEstadoB=convertToBean(depEstado);
        cacheManager.getCache(Configurations.CACHE_NAME).put("web_depEstado_"+depEstadoB.getId(), depEstadoB);
        return depEstadoB;
    }

    @Override
    public List<DepEstadoB> getAll(Integer page) {

        DepEstadoResult depEstadoResult = depEstadoResource.getByPage(page);
        List<DepEstadoDTO> dtosList = new ArrayList<DepEstadoDTO>();

        if(depEstadoResult.getDepEstados()!=null) dtosList = depEstadoResult.getDepEstados();

        final List<DepEstadoB> beansList = new ArrayList<DepEstadoB>();

        dtosList.forEach(depEstadoDTO -> beansList.add(convertToBean(depEstadoDTO)));
        return beansList;
    }

    @Override
    public List<DepEstadoB> getAll(Integer page, Integer size) {
        DepEstadoResult depEstadoResult = depEstadoResource.getByPage(page, size);
        List<DepEstadoDTO> dtosList = new ArrayList<DepEstadoDTO>();

        if(depEstadoResult.getDepEstados()!=null) dtosList = depEstadoResult.getDepEstados();

        final List<DepEstadoB> beansList = new ArrayList<DepEstadoB>();

        dtosList.forEach(depEstadoDTO -> beansList.add(convertToBean(depEstadoDTO)));
        return beansList;
    }

    @Override
    public List<DepEstadoB> getAll() {
        DepEstadoResult depEstadoResult = depEstadoResource.getByPage();
        List<DepEstadoDTO> dtosList = new ArrayList<DepEstadoDTO>();

        if(depEstadoResult.getDepEstados()!=null) dtosList = depEstadoResult.getDepEstados();

        final List<DepEstadoB> beansList = new ArrayList<DepEstadoB>();

        dtosList.forEach(depEstadoDTO -> beansList.add(convertToBean(depEstadoDTO)));
        return beansList;
    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_depEstado_'+#id")
    public DepEstadoB getById(Integer id) {
        final DepEstadoDTO dto= depEstadoResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_depEstado_'+#id")
    public DepEstadoB update(DepEstadoB bean, Integer id) {
        final DepEstadoDTO dto= convertToDTO(bean);
        final DepEstadoDTO nuevo= depEstadoResource.update(dto,id);
        return convertToBean(nuevo);
    }

    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_depEstado_'+#id")
    public DepEstadoB delete(Integer id) {

        final DepEstadoDTO d= depEstadoResource.delete(id);
        return convertToBean(d);

    }

    public List<DepEstadoB> getAllNotPaged() {
        final DepEstadoResult result = depEstadoResource.getAll();

        final List<DepEstadoDTO> dtosList = null == result.getDepEstados() ? new ArrayList<DepEstadoDTO>() : result.getDepEstados();
        final List<DepEstadoB> beansList = new ArrayList<DepEstadoB>();

        dtosList.forEach(depEstadoDTO -> beansList.add(convertToBean(depEstadoDTO)));
        return beansList;
    }
}
