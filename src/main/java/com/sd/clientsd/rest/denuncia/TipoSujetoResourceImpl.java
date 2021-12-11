package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="tipoSujetoResource")
public class TipoSujetoResourceImpl extends BaseResourceImpl<TipoSujetoDTO> implements ITipoSujetoResource {

    //private static final String RESOURCE_PATH = Configurations.getTipoSujetoResource();

    public TipoSujetoResourceImpl(){
        super(TipoSujetoDTO.class, "/tiposSujetos");
    }

    @Override
    public TipoSujetoResult getAll() {
        return getWebResource().get(TipoSujetoResult.class);
    }

    @Override
    public TipoSujetoResult getByPage(Integer pageNum) {
        TipoSujetoResult tResult = new TipoSujetoResult();

        if(getWebResource()!=null){
            Class<TipoSujetoResult> tResultClass = TipoSujetoResult.class;
            String path = "/page/"+pageNum;
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }

    @Override
    public TipoSujetoResult getByPage(Integer page, Integer size) {
        TipoSujetoResult tResult = new TipoSujetoResult();

        if(getWebResource()!=null){
            Class<TipoSujetoResult> tResultClass = TipoSujetoResult.class;
            String path = "/page/"+page+"/"+size;
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }

    @Override
    public TipoSujetoResult getByPage() {
        TipoSujetoResult tResult = new TipoSujetoResult();

        if(getWebResource()!=null){
            Class<TipoSujetoResult> tResultClass = TipoSujetoResult.class;
            String path = "/page/";
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }
}
