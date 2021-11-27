package com.sd.clientsd.service.location;

import com.protectionapp.sd2021.dto.localization.NeighborhoodDTO;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface INeighborhoodService extends IBaseService<NeighborhoodB, NeighborhoodDTO> {
    List<NeighborhoodB> convertDtoListToBList(List<NeighborhoodDTO> dtos);
    List<NeighborhoodB> getAllNotPaged();
}
