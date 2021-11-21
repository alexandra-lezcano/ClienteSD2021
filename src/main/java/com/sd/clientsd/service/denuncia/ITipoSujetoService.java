package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.sd.clientsd.beans.denuncia.TipoSujetoB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface ITipoSujetoService extends IBaseService<TipoSujetoB, TipoSujetoDTO> {
    public List<TipoSujetoB> getAllNotPage();
}
