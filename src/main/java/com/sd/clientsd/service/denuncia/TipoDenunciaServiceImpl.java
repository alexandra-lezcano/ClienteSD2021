package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.rest.denuncia.ITipoDenunciaResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.sd.clientsd.utils.config.Configurations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tipoDenunciaService")
public class TipoDenunciaServiceImpl extends BaseServiceImpl<TipoDenunciaB, TipoDenunciaDTO> implements ITipoDenunciaService {
    @Autowired
    private ITipoDenunciaResource tipoDenunciaResource;

    @Autowired
    private CacheManager cacheManager;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected TipoDenunciaDTO convertToDTO(TipoDenunciaB bean) {
        final TipoDenunciaDTO dto = new TipoDenunciaDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setTitulo(bean.getTitulo());
        dto.setDescripcion(bean.getDescripcion());
        return dto;
    }

    @Override
    protected TipoDenunciaB convertToBean(TipoDenunciaDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("titulo", dto.getTitulo());
        params.put("descripcion", dto.getDescripcion());

        final TipoDenunciaB bean = new TipoDenunciaB(params);
        return bean;
    }

    @Override
    public TipoDenunciaB save(TipoDenunciaB bean) {
        final TipoDenunciaDTO dto = convertToDTO(bean);
        final TipoDenunciaDTO tipoDenundiaDto  = tipoDenunciaResource.save(dto);
        final TipoDenunciaB tipoDenunciaB = convertToBean(tipoDenundiaDto);
        cacheManager.getCache(Configurations.CACHE_NAME).put("web_tipo_denuncia_"+tipoDenunciaB.getId(), tipoDenunciaB);
        return tipoDenunciaB;
    }

    @Override
    public List<TipoDenunciaB> getAll(Integer pageNum) {
        TipoDenunciaResult tipoDenunciaResult = tipoDenunciaResource.getByPage(pageNum);
        List<TipoDenunciaDTO> dtosList = new ArrayList<TipoDenunciaDTO>();

        if(tipoDenunciaResult.getTipoDenuncias()!=null) dtosList = tipoDenunciaResult.getTipoDenuncias();

      // final List<TipoDenunciaDTO> dtosList = null == tipoDenunciaResult.getTipoDenunciasList() ? new ArrayList<TipoDenunciaDTO>() : tipoDenunciaResult.getTipoDenunciasList();
        final List<TipoDenunciaB> beansList = new ArrayList<TipoDenunciaB>();
        dtosList.forEach(tipoDenunciaDTO -> beansList.add(convertToBean(tipoDenunciaDTO)));
        return beansList;
    }

    public List<TipoDenunciaB> getAllNotPaged() {
        final TipoDenunciaResult tipoDenunciaResult = new TipoDenunciaResult();
                //tipoDenunciaResource.getAll();
        final List<TipoDenunciaDTO> dtosList = null == tipoDenunciaResult.getTipoDenuncias() ? new ArrayList<TipoDenunciaDTO>() : tipoDenunciaResult.getTipoDenuncias();
        final List<TipoDenunciaB> beansList = new ArrayList<TipoDenunciaB>();

        dtosList.forEach(tipoDenunciaDTO -> beansList.add(convertToBean(tipoDenunciaDTO)));
        return beansList;
    }

    @Override
    @Cacheable(value=Configurations.CACHE_NAME, key = "'web_tipo_denuncia_'+#id")
    public TipoDenunciaB getById(Integer id) {
        logger.info("getById test");
        final TipoDenunciaDTO tipoDenunciaDTO = tipoDenunciaResource.getById(id);
        return convertToBean(tipoDenunciaDTO);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_tipo_denuncia_'+#id")
    public TipoDenunciaB update(TipoDenunciaB bean, Integer id) {
        logger.info("update test");
        final TipoDenunciaDTO dto = convertToDTO(bean);
        final TipoDenunciaDTO updated = tipoDenunciaResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_tipo_denuncia_'+#id")
    public TipoDenunciaB delete(Integer id) {
        logger.info("delete test");
        final TipoDenunciaDTO deleted = tipoDenunciaResource.delete(id);
        return convertToBean(deleted);
    }
}
