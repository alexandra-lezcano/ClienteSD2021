package com.sd.clientsd.service.casosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosResult;
import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB;
import com.sd.clientsd.rest.CasosDerivados.ICasosDerivadosResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.*;

@Service("casoDerivadoService")
public class CasosDerivadosServiceImpl extends BaseServiceImpl<CasoDerivadoB, CasosDerivadosDTO> implements ICasosDerivadosService {

    @Autowired
    private ICasosDerivadosResource casosDerivadoResource;

    @Autowired
    private CacheManager cacheManager;

    @Override
    protected CasosDerivadosDTO convertToDTO(CasoDerivadoB bean) {
        final CasosDerivadosDTO dto = new CasosDerivadosDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
       // dto.setDate(bean.getDate());
        dto.setDescription(bean.getDescription());
        dto.setUser_id(bean.getTrabajador_social_id());
        return dto;
    }

    @Override
    protected CasoDerivadoB convertToBean(CasosDerivadosDTO dto) {
        final Map<String,String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
     //   params.put("date",dateToStr);
        params.put("description", dto.getDescription());
    //    params.put("trabajador_social_id", Integer.toString(dto.getUser_id()));

        final CasoDerivadoB bean= new CasoDerivadoB(params);
        return bean;
    }

    @Override
    public CasoDerivadoB save(CasoDerivadoB bean) {
        final CasosDerivadosDTO dto= convertToDTO(bean);
        final CasosDerivadosDTO casoDerivado= casosDerivadoResource.save(dto);
        final CasoDerivadoB casoDerivadoB=convertToBean(casoDerivado);
        cacheManager.getCache(Configurations.CACHE_NAME).put("web_casos_derivados_"+casoDerivadoB.getId(), casoDerivadoB);
        return casoDerivadoB;
    }

    @Override
    public List<CasoDerivadoB> getAll(Integer page) {

        CasosDerivadosResult casoDerivadoResult = casosDerivadoResource.getByPage(page);
        List<CasosDerivadosDTO> dtosList = new ArrayList<CasosDerivadosDTO>();

        if(casoDerivadoResult.getCasosDerivados()!=null) dtosList = casoDerivadoResult.getCasosDerivados();

       // System.out.println(casoDerivadoResult.getCasosDerivados().get(1).getDate());

        final List<CasoDerivadoB> beansList = new ArrayList<CasoDerivadoB>();

        dtosList.forEach(casoDerivadoDTO -> {

                beansList.add(convertToBean(casoDerivadoDTO));

        });
        return beansList;
    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_casos_derivados_'+#id")
    public CasoDerivadoB getById(Integer id) {
        final CasosDerivadosDTO dto= casosDerivadoResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_casos_derivados_'+#id")
    public CasoDerivadoB update(CasoDerivadoB bean, Integer id)  {
        final CasosDerivadosDTO dto= convertToDTO(bean);
        final CasosDerivadosDTO nuevo= casosDerivadoResource.update(dto,id);
        return convertToBean(nuevo);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_casos_derivados_'+#id")
    public CasoDerivadoB delete(Integer id) {

        final CasosDerivadosDTO d= casosDerivadoResource.delete(id);
        return convertToBean(d);
    }



}
