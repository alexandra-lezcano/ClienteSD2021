package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface ITipoDenunciaService extends IBaseService<TipoDenunciaB, TipoDenunciaDTO> {
    public List<TipoDenunciaB> getAll();
}
