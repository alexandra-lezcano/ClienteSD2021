package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.CityDTO;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface ICityResource extends IBaseResource<CityDTO> {
    public CityResult getAll();
    public CityResult getByPage(Integer pageNum);
    public CityResult getByPage(Integer pageNum, Integer size);
    public CityResult getByPage();
    public CityResult getByName(String search, Integer pageNum);

    public CityDTO getFirst();

    NeighborhoodResult getNeighborhoodByCityId(Integer id);
}
