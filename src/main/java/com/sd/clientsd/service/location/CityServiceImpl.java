package com.sd.clientsd.service.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.rest.location.ICityResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<CityB, CityDTO>implements ICityService {

    @Autowired
    private ICityResource cityResource;

    @Autowired
    private INeighborhoodService neighborhoodService;

    @Override
    protected CityDTO convertToDTO(CityB bean) {
        final CityDTO dto = new CityDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());

        final Set<Integer> neighborhoodIds = new HashSet<>();
        if(bean.getNeighborhoodBList()!=null){
            bean.getNeighborhoodBList().forEach(neighborhoodB -> neighborhoodIds.add(neighborhoodB.getId()));
        }

        dto.setNeighborhoods(neighborhoodIds);
        return dto;
    }

    @Override
    protected CityB convertToBean(@NotNull CityDTO dto) {
        final Map<String,String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("name",dto.getName());
        params.put("description", dto.getDescription());

        final CityB bean= new CityB(params);

        final NeighborhoodResult neighborhoodResult = cityResource.getNeighborhoodByCityId(dto.getId());
        if(neighborhoodResult!=null){
            final List<NeighborhoodDTO> neighborhoodDtos =  neighborhoodResult.getNeighborhoods();
            final List<NeighborhoodB> neighborhoodBList = neighborhoodService.convertDtoListToBList(neighborhoodDtos);
            bean.setNeighborhoodBList(neighborhoodBList);
        }

        return bean;
    }

    @Override
    public CityB save(CityB bean) {
        final CityDTO dto= convertToDTO(bean);
        final CityDTO city= cityResource.save(dto);
        final CityB cityB=convertToBean(city);

        return cityB;
    }

    @Override
    public List<CityB> getAll(Integer page) {
        CityResult cityResult = cityResource.getByPage(page);
        List<CityDTO> dtosList = new ArrayList<CityDTO>();

        if(cityResult.getCities()!=null) dtosList = cityResult.getCities();
      //  System.out.println(cityResult.getCities().get(1).getName());
        final List<CityB> beansList = new ArrayList<CityB>();

        dtosList.forEach(cityDTO -> beansList.add(convertToBean(cityDTO)));
        return beansList;

    }

    @Override
    @Cacheable(value= Configurations.CACHE_NAME, key = "'web_city_'+#id")

    public CityB getById(Integer id) {
        final CityDTO dto= cityResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    @CachePut(value=Configurations.CACHE_NAME, key = "'web_city_'+#id")
    public CityB update(CityB bean, Integer id) {
        final CityDTO dto= convertToDTO(bean);
        final CityDTO nuevo= cityResource.update(dto,id);
        return convertToBean(nuevo);
    }


    @Override
    @CacheEvict(value=Configurations.CACHE_NAME, key = "'web_city_'+#id")
    public CityB delete(Integer id) {
        System.out.println("ID: "+id);
        final CityDTO c= cityResource.delete(id);
        return convertToBean(c);

    }

    public List<CityB> getAllNotPaged() {
        System.out.println("Inside city get all not paged");
        final CityResult result = cityResource.getAll();

        final List<CityDTO> dtosList = null == result.getCities() ? new ArrayList<CityDTO>() : result.getCities();
        final List<CityB> beansList = new ArrayList<CityB>();

        dtosList.forEach(cityDTO -> beansList.add(convertToBean(cityDTO)));
        return beansList;
    }
}
