package com.sd.clientsd.rest.investigacion;

import com.protectionapp.sd2021.dto.investigacion.InvestigacionDTO;
import com.protectionapp.sd2021.dto.investigacion.InvestigacionResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface IInvestigacionResource extends IBaseResource<InvestigacionDTO> {
    public InvestigacionResult getAll();
    public InvestigacionResult getByPage(Integer pageNum);

}
