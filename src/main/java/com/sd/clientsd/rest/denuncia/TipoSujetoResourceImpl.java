package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository(value="tipoSujetoResource")
public class TipoSujetoResourceImpl extends BaseResourceImpl<TipoSujetoDTO> implements ITipoSujetoResource {

    public TipoSujetoResourceImpl(){
        super(TipoSujetoDTO.class, "/tiposSujetos");
    }

    @Override
    public TipoSujetoResult getAll() {
        return getWebResource().get(TipoSujetoResult.class);
    }

    @Override
    public TipoSujetoResult getByPage(Integer pageNum) {
        return getWebResource().path("/page/"+pageNum).get(TipoSujetoResult.class);
    }
}
