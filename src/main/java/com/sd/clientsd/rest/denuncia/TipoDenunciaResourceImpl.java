package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value = "tipoDenunciaResource")
public class TipoDenunciaResourceImpl extends BaseResourceImpl<TipoDenunciaDTO> implements ITipoDenunciaResource{
    private static final String RESOURCE_PATH = Configurations.getTipoDenunciaResource();

    public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, RESOURCE_PATH);
    }

    @Override
    public TipoDenunciaResult getAll() {
        setWebResourceBasicAuthFilter();
        return getWebResource().get(TipoDenunciaResult.class);
    }

    @Override
    public TipoDenunciaResult getByPage(Integer pageNum) {
        setWebResourceBasicAuthFilter();
       TipoDenunciaResult tResult = new TipoDenunciaResult();

        if(getWebResource()!=null){
            Class<TipoDenunciaResult> tResultClass = TipoDenunciaResult.class;
            String path = "/page/"+pageNum;
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }

    @Override
    public TipoDenunciaResult getByPage(Integer page, Integer size) {
        setWebResourceBasicAuthFilter();
        TipoDenunciaResult tResult = new TipoDenunciaResult();

        if(getWebResource()!=null){
            Class<TipoDenunciaResult> tResultClass = TipoDenunciaResult.class;
            String path = "/page/"+page+"/"+size;
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }

    @Override
    public TipoDenunciaResult getByPage() {
        setWebResourceBasicAuthFilter();
        TipoDenunciaResult tResult = new TipoDenunciaResult();

        if(getWebResource()!=null){
            Class<TipoDenunciaResult> tResultClass = TipoDenunciaResult.class;
            String path = "/page/";
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }
}
