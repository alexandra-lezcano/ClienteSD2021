package com.sd.clientsd.rest.CasosDerivados;


import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="casosDerivadosResource")
public class CasosDerivadosResourceImpl  extends BaseResourceImpl<CasosDerivadosDTO> implements ICasosDerivadosResource {
    public CasosDerivadosResourceImpl() {
        super(CasosDerivadosDTO.class, "/casosDerivados");
    }

    @Override
    public CasosDerivadosResult getAll() {
        return getWebResource().get(CasosDerivadosResult.class);
    }

    @Override
    public CasosDerivadosResult getByPage(Integer pageNum) {
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/"+pageNum;
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

    @Override
    public CasosDerivadosResult getByPage(Integer page, Integer size) {
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/"+page+"/"+size;
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

    @Override
    public CasosDerivadosResult getByPage() {
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/";
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }
}

