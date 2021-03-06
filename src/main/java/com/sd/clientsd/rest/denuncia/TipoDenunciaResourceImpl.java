package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value = "tipoDenunciaResource")
public class TipoDenunciaResourceImpl extends BaseResourceImpl<TipoDenunciaDTO> implements ITipoDenunciaResource{
    private static final String RESOURCE_PATH = Configurations.getTipoDenunciaResource();
    // todo agregar esto a un archivo de configuracion!
   /* public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, "/tipoDenuncias");
    }*/

    public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, RESOURCE_PATH);
    }

    @Override
    public TipoDenunciaResult getAll() {
        return getWebResource().get(TipoDenunciaResult.class);
    }

    @Override
    public TipoDenunciaResult getByPage(Integer pageNum) {
       TipoDenunciaResult tResult = new TipoDenunciaResult();

        if(getWebResource()!=null){
            Class<TipoDenunciaResult> tResultClass = TipoDenunciaResult.class;
            String path = "/page/"+pageNum;
            tResult = getWebResource().path(path).get(tResultClass);
        }
        return tResult;
    }
}
