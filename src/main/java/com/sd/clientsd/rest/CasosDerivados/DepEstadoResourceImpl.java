package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="depEstadoResource")
public class DepEstadoResourceImpl extends BaseResourceImpl<DepEstadoDTO> implements IDepEstadoResource {
    public DepEstadoResourceImpl() {
        super(DepEstadoDTO.class, "/depEstado");
    }

    @Override
    public DepEstadoResult getAll() {

        setWebResourceBasicAuthFilter();
        return getWebResource().path("/").get(DepEstadoResult.class);
    }

    @Override
    public DepEstadoResult getByPage(Integer pageNum) {
        setWebResourceBasicAuthFilter();
        DepEstadoResult depEstadoResult = new DepEstadoResult();

        if(getWebResource()!=null){
            Class<DepEstadoResult> depEstadoResultClass = DepEstadoResult.class;
            String path = "/page/"+pageNum;
            depEstadoResult = getWebResource().path(path).get(depEstadoResultClass);
        }
        return depEstadoResult;
    }

    @Override
    public DepEstadoResult getByPage(Integer page, Integer size) {
        setWebResourceBasicAuthFilter();
        DepEstadoResult depEstadoResult = new DepEstadoResult();

        if(getWebResource()!=null){
            Class<DepEstadoResult> depEstadoResultClass = DepEstadoResult.class;
            String path = "/page/"+page+"/"+size;
            depEstadoResult = getWebResource().path(path).get(depEstadoResultClass);
        }
        return depEstadoResult;
    }

    @Override
    public DepEstadoResult getByPage() {
        setWebResourceBasicAuthFilter();
        DepEstadoResult depEstadoResult = new DepEstadoResult();

        if(getWebResource()!=null){
            Class<DepEstadoResult> depEstadoResultClass = DepEstadoResult.class;
            String path = "/page/";
            depEstadoResult = getWebResource().path(path).get(depEstadoResultClass);
        }
        return depEstadoResult;
    }
}
