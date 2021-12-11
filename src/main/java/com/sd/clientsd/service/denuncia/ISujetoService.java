package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.sd.clientsd.beans.denuncia.SujetoB;
import com.sd.clientsd.service.base.IBaseService;

import java.util.List;

public interface ISujetoService extends IBaseService<SujetoB, SujetoDto> {
    public List<SujetoB> newList();
}
