package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value="denunciaResource")
public class DenunciaResourceImpl extends BaseResourceImpl<DenunciaDTO> implements IDenunciaResource {
    private static final String RESOURCE_PATH = Configurations.getDenunciaResource();
    public DenunciaResourceImpl(){
        super (DenunciaDTO.class, RESOURCE_PATH);
    }


    @Override
    public DenunciaResult getAll() {
        return getWebResource().get(DenunciaResult.class);
    }

    @Override
    public DenunciaResult getByPage(Integer pageNum) {
        DenunciaResult dResult = new DenunciaResult();
        if(getWebResource()!=null){
            Class<DenunciaResult> dResultClass = DenunciaResult.class;
            String path = "/page/"+pageNum;
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }

    @Override
    public DenunciaResult getByPage(Integer pageNum, Integer size) {
        DenunciaResult dResult = new DenunciaResult();
        if(getWebResource()!=null){
            Class<DenunciaResult> dResultClass = DenunciaResult.class;
            String path = "/page/"+pageNum+"/"+size;
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }

    @Override
    public DenunciaResult getByPage(){
        DenunciaResult dResult = new DenunciaResult();
        if(getWebResource()!=null){
            Class<DenunciaResult> dResultClass = DenunciaResult.class;
            String path = "/page/";
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }
}
