package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value = "sujetoResource")
public class SujetoResourceImpl extends BaseResourceImpl<SujetoDto> implements ISujetoresource {
    public SujetoResourceImpl() {
        super(SujetoDto.class, "/sujetos");
    }

    @Override
    public SujetoResult getAll() {
        return getWebResource().get(SujetoResult.class);
    }

    @Override
    public SujetoResult getByPage(Integer page) {
        return getWebResource().path("/page/"+page).get(SujetoResult.class);
    }
}
