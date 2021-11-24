package com.sd.clientsd.service.location;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.rest.CasosDerivados.IDepEstadoResource;
import com.sd.clientsd.rest.location.ICityResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<CityB, CityDTO>implements ICityService {

    @Autowired
    private ICityResource cityResource;


    @Override
    protected CityDTO convertToDTO(CityB bean) {
        final CityDTO dto = new CityDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        return dto;
    }

    @Override
    protected CityB convertToBean(CityDTO dto) {
        final Map<String,String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("name",dto.getName());
        params.put("description", dto.getDescription());

        final CityB bean= new CityB(params);
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
    public CityB getById(Integer id) {
        final CityDTO dto= cityResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    public CityB update(CityB bean, Integer id) {
        final CityDTO dto= convertToDTO(bean);
        final CityDTO nuevo= cityResource.update(dto,id);
        return convertToBean(nuevo);
    }


    @Override
    public CityB delete(Integer id) {
        final CityDTO c= cityResource.delete(id);
        return convertToBean(c);

    }

    public List<CityB> getAllNotPaged() {
        final CityResult result = new CityResult();

        final List<CityDTO> dtosList = null == result.getCities() ? new ArrayList<CityDTO>() : result.getCities();
        final List<CityB> beansList = new ArrayList<CityB>();

        dtosList.forEach(cityDTO -> beansList.add(convertToBean(cityDTO)));
        return beansList;
    }





}
