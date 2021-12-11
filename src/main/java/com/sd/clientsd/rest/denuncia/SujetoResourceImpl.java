package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value = "sujetoResource")
public class SujetoResourceImpl extends BaseResourceImpl<SujetoDto> implements ISujetoresource {
    private static final String RESOURCE_PATH = Configurations.getSujetoResource();

    public SujetoResourceImpl() {
        super(SujetoDto.class, RESOURCE_PATH);
    }

    @Override
    public SujetoResult getAll() {
        return getWebResource().get(SujetoResult.class);
    }

    @Override
    public SujetoResult getByPage(Integer page) {
        SujetoResult sResult = new SujetoResult();

        if(getWebResource()!=null){
            Class<SujetoResult> sResultClass = SujetoResult.class;
            String path = "/page/"+page;
            sResult = getWebResource().path(path).get(sResultClass);
        }
        return sResult;
    }

    @Override
    public SujetoResult getByPage(Integer page, Integer size) {
        SujetoResult sResult = new SujetoResult();

        if(getWebResource()!=null){
            Class<SujetoResult> sResultClass = SujetoResult.class;
            String path = "/page/"+page+"/"+size;
            sResult = getWebResource().path(path).get(sResultClass);
        }
        return sResult;
    }

    @Override
    public SujetoResult getByPage() {
        SujetoResult sResult = new SujetoResult();

        if(getWebResource()!=null){
            Class<SujetoResult> sResultClass = SujetoResult.class;
            String path = "/page/";
            sResult = getWebResource().path(path).get(sResultClass);
        }
        return sResult;
    }
}
