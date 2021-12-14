package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository (value="denunciaEstados")
public class DenunciaEstadoResourceImpl extends BaseResourceImpl<DenunciaEstadoDTO> implements IDenunciaEstadoResource {
    private static final String RESOURCE_PATH = Configurations.gerDenunciaEstadoResource();
    public DenunciaEstadoResourceImpl(){super(DenunciaEstadoDTO.class, RESOURCE_PATH);}


    @Override
    public DenunciaEstadoDTO getById(Integer id) {
        setWebResourceBasicAuthFilter();
        // por ahora asumo que voy a crear un Resource con el path ya incluyendo un id
        return getWebResource().path("/"+id).get(DenunciaEstadoDTO.class);
    }
    @Override
    public DenunciaEstadoResult getAll(){
        setWebResourceBasicAuthFilter();
        return getWebResource().get(DenunciaEstadoResult.class);}

    @Override
    public DenunciaEstadoResult getByPage(Integer page){
        setWebResourceBasicAuthFilter();
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
        setWebResourceBasicAuthFilter();
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
        setWebResourceBasicAuthFilter();
        DenunciaEstadoResult dResult = new DenunciaEstadoResult();

        if(getWebResource()!=null){
            Class<DenunciaEstadoResult> dResultClass = DenunciaEstadoResult.class;
            String path = "/page/";
            dResult = getWebResource().path(path).get(dResultClass);
        }
        return dResult;
    }
}
