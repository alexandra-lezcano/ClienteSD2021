package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value = "tipoDenunciaResource")
public class TipoDenunciaResourceImpl extends BaseResourceImpl<TipoDenunciaDTO> implements ITipoDenunciaResource{

    // todo agregar esto a un archivo de configuracion!
    public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, "/tipoDenuncias");
    }

    @Override
    public TipoDenunciaResult getAll() {
        return getWebResource().get(TipoDenunciaResult.class);
    }

    @Override
    public TipoDenunciaResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(TipoDenunciaResult.class);
    }
}
