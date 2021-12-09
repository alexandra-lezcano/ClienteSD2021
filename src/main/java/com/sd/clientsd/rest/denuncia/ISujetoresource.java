package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface ISujetoresource extends IBaseResource<SujetoDto> {
    public SujetoResult getAll();
    public SujetoResult getByPage(Integer page);
    public SujetoResult getByPage(Integer page, Integer size);
    public SujetoResult getByPage();
}
