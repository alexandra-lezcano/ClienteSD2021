package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository (value="denunciaEstados")
public class DenunciaEstadoResourceImpl extends BaseResourceImpl<DenunciaEstadoDTO> implements IDenunciaEstadoResource {
    private static final String RESOURCE_PATH = Configurations.gerDenunciaEstadoResource();
    public DenunciaEstadoResourceImpl(){super(DenunciaEstadoDTO.class, RESOURCE_PATH);}

    @Override
    public DenunciaEstadoResult getAll(){return getWebResource().get(DenunciaEstadoResult.class);}

    @Override
    public DenunciaEstadoResult getByPage(Integer page){
        DenunciaEstadoResult dResult = new DenunciaEstadoResult();

        if(getWebResource()!=null){
            Class<DenunciaEstadoResult> dResultClass = DenunciaEstadoResult.class;
            String path = "/page/"+page;
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }

    @Override
    public DenunciaEstadoResult getByPage(Integer page, Integer size) {
        DenunciaEstadoResult dResult = new DenunciaEstadoResult();

        if(getWebResource()!=null){
            Class<DenunciaEstadoResult> dResultClass = DenunciaEstadoResult.class;
            String path = "/page/"+page+"/"+size;
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }

    @Override
    public DenunciaEstadoResult getByPage() {
        DenunciaEstadoResult dResult = new DenunciaEstadoResult();

        if(getWebResource()!=null){
            Class<DenunciaEstadoResult> dResultClass = DenunciaEstadoResult.class;
            String path = "/page/";
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }
}
