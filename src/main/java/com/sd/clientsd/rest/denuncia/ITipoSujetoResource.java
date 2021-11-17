package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.rest.base.IBaseResource;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;

public interface ITipoSujetoResource extends IBaseResource<TipoSujetoDTO> {
    public TipoSujetoResult getAll();
}
