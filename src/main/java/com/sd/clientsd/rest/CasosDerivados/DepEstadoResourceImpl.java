package com.sd.clientsd.rest.CasosDerivados;

import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoDTO;
import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult;
import com.protectionapp.sd2021.dto.denuncia.SujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;



@Repository(value="depEstadoResource")
public class DepEstadoResourceImpl extends BaseResourceImpl<DepEstadoDTO> implements IDepEstadoResource {


    private static final String RESOURCE_PATH = Configurations.getDepestadoResource();

    public DepEstadoResourceImpl() {
        super(DepEstadoDTO.class, RESOURCE_PATH);
    }



    @Override
    public DepEstadoDTO getById(Integer id) {
        setWebResourceBasicAuthFilter();
        // por ahora asumo que voy a crear un Resource con el path ya incluyendo un id
        System.out.println(getWebResource().path("/"+id));
        return getWebResource().path("/"+id).get(DepEstadoDTO.class);
    }

    @Override
    public DepEstadoResult getAll() {

        setWebResourceBasicAuthFilter();
        return getWebResource().path("/page").get(DepEstadoResult.class);
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

    @Override
    public DepEstadoResult getAllByName(String name, Integer page)
    {
        setWebResourceBasicAuthFilter();
        DepEstadoResult depEstadoResult = new DepEstadoResult();

        if(getWebResource()!=null){
            Class<DepEstadoResult> depEstadoResultClass = DepEstadoResult.class;
            String path = "/find/"+page+"/"+name;
            depEstadoResult = getWebResource().path(path).get(depEstadoResultClass);
        }
        return depEstadoResult;
    }
}
