package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.protectionapp.sd2021.dto.localization.CityResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository (value="denunciaEstadoResource")
public class DenunciaEstadoResourceImpl extends BaseResourceImpl<DenunciaEstadoDTO> implements IDenunciaEstadoResource {
    private static final String RESOURCE_PATH = Configurations.gerDenunciaEstadoResource();
    public DenunciaEstadoResourceImpl(){
        super(DenunciaEstadoDTO.class, RESOURCE_PATH);
    }

    @Override
    public DenunciaEstadoResult getAll(){
        return getWebResource().get(DenunciaEstadoResult.class);
    }

    @Override
    public DenunciaEstadoResult getByPage(Integer page){
        DenunciaEstadoResult cResult = new DenunciaEstadoResult();

        if(getWebResource()!=null){
            Class<DenunciaEstadoResult> cResultClass = DenunciaEstadoResult.class;
            String path = "/page/"+page;
            cResult = getWebResource().path(path).get(cResultClass);
        }
        return cResult;
    }
}
