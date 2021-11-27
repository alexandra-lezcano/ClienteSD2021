package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface IDenunciaEstadoResource extends IBaseResource<DenunciaEstadoDTO> {
    public DenunciaEstadoResult getAll();
    public DenunciaEstadoResult getByPage(Integer page);
}
