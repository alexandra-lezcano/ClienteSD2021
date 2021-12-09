package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface IDenunciaResource extends IBaseResource<DenunciaDTO> {
    public DenunciaResult getAll();
    public DenunciaResult getByPage(Integer pageNum);
    public DenunciaResult getByPage(Integer pageNum, Integer size);
    public DenunciaResult getByPage();
}
