package com.sd.clientsd.service.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface ICityService extends IBaseService<CityB, CityDTO> {
    public List<CityB> getAllNotPaged();
    public CityB getFirst();
    public List<CityB> findAllByName(String search, Integer page);
}
