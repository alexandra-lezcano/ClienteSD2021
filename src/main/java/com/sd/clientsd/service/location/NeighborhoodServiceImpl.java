package com.sd.clientsd.service.location;

import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.rest.location.ICityResource;
import com.sd.clientsd.rest.location.INeighborhoodResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.utils.config.Configurations;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="neighborhoodService")
public class NeighborhoodServiceImpl extends BaseServiceImpl<NeighborhoodB, NeighborhoodDTO> implements INeighborhoodService {
    @Autowired
    private INeighborhoodResource neighborhoodResource;

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICityResource cityResource;

    @Override
    protected NeighborhoodDTO convertToDTO(NeighborhoodB bean) {
        final NeighborhoodDTO dto = new NeighborhoodDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setDescription(bean.getDescription());
        dto.setName(bean.getName());

        dto.setCity_id(bean.getCity_id().getId());

        return dto;
    }

    @Override

    protected NeighborhoodB convertToBean(NeighborhoodDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("description", dto.getDescription());
        params.put("name", dto.getName());

        final NeighborhoodB bean = new NeighborhoodB(params);

        if(dto.getCity_id()!=0){
            bean.setCity_id(cityService.getById(dto.getCity_id()));
        }

        return bean;
    }

    @Override
    public NeighborhoodB save(NeighborhoodB bean) {
      //  System.out.println("id ciudad"+bean.getCity_id().getId());
        final NeighborhoodDTO dto = convertToDTO(bean);

        final NeighborhoodDTO neighborhoodDTO  = neighborhoodResource.save(dto);

        final NeighborhoodB neighborhoodB = convertToBean(neighborhoodDTO);

        return neighborhoodB;
    }

    @Override
    public List<NeighborhoodB> getAll(Integer pageNum) {
        NeighborhoodResult neighborhoodResult = neighborhoodResource.getByPage(pageNum);
        List<NeighborhoodDTO> dtosList = new ArrayList<NeighborhoodDTO>();

        if(neighborhoodResult.getNeighborhoods()!=null) dtosList = neighborhoodResult.getNeighborhoods();

        final List<NeighborhoodB> beansList = new ArrayList<NeighborhoodB>();

        dtosList.forEach(neighborhoodDTO -> beansList.add(convertToBean(neighborhoodDTO)));
        return beansList;
    }

    public List<NeighborhoodB> getAllNotPaged() {
        final NeighborhoodResult neighborhoodResult = new NeighborhoodResult();
        //tipoDenunciaResource.getAll();
        final List<NeighborhoodDTO> dtosList = null == neighborhoodResult.getNeighborhoods() ? new ArrayList<>() : neighborhoodResult.getNeighborhoods();
        final List<NeighborhoodB> beansList = new ArrayList<>();

        dtosList.forEach(neighborhoodDTO -> beansList.add(convertToBean(neighborhoodDTO)));
        return beansList;
    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_neighborhood_'+#id")
    public NeighborhoodB getById(Integer id) {
        final NeighborhoodDTO neighborhoodDTO = neighborhoodResource.getById(id);
        return convertToBean(neighborhoodDTO);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_neighborhood_'+#id")
    public NeighborhoodB update(NeighborhoodB bean, Integer id) {
        final NeighborhoodDTO dto = convertToDTO(bean);
        final NeighborhoodDTO updated = neighborhoodResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_neighborhood_'+#id")
    public NeighborhoodB delete(Integer id) {
        final NeighborhoodDTO deleted = neighborhoodResource.delete(id);
        return convertToBean(deleted);
    }

    public List<NeighborhoodB> convertDtoListToBList(@NotNull List<NeighborhoodDTO> dtos){
        final List<NeighborhoodB> beans = new ArrayList<>();
        dtos.forEach(neighborhoodDTO -> {
            neighborhoodDTO.setCity_id(0);
            beans.add(convertToBean(neighborhoodDTO));
        });
        return beans;
    }
}