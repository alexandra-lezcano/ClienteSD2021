package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaDTO;
import com.sd.clientsd.beans.denuncia.DenunciaB;
import com.sd.clientsd.beans.denuncia.SujetoB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface IDenunciaService extends IBaseService<DenunciaB, DenunciaDTO> {
    DenunciaB saveCabeceraDetalle(DenunciaB denuncia);
}
