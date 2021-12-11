package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface ITipoSujetoResource extends IBaseResource<TipoSujetoDTO> {
    public TipoSujetoResult getAll();
    public TipoSujetoResult getByPage(Integer pageNum);
    public TipoSujetoResult getByPage(Integer page, Integer size);
    public TipoSujetoResult getByPage();
}
