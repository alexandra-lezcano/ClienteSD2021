package com.sd.clientsd.rest.location;

import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.protectionapp.sd2021.dto.localization.NeighborhoodResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface INeighborhoodResource extends IBaseResource<NeighborhoodDTO> {
    public NeighborhoodResult getAll();
    public NeighborhoodResult getByPage(Integer pagenum);
}
