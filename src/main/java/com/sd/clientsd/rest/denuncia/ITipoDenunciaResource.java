package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.IBaseResource;


public interface ITipoDenunciaResource extends IBaseResource<TipoDenunciaDTO> {
    public TipoDenunciaResult getAll();
    public TipoDenunciaResult getByPage(Integer pageNum);
    public TipoDenunciaResult getByPage(Integer page, Integer size);
    public TipoDenunciaResult getByPage();
}
