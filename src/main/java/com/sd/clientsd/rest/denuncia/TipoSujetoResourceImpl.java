package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import grails.plugin.cache.CacheEvict;
import org.springframework.stereotype.Repository;

@Repository(value = "tipoSujetoResource")
public class TipoSujetoResourceImpl extends BaseResourceImpl<TipoSujetoDTO> implements ITipoSujetoResource {

    public TipoSujetoResourceImpl() {
        super(TipoSujetoDTO.class, "/tiposSujetos");
    }

    @Override
    public TipoSujetoDTO save(TipoSujetoDTO dto){
        final TipoSujetoDTO tipoSujetoDTO = super.save(dto);
        return tipoSujetoDTO;
    }

    @Override
    public TipoSujetoResult getAll(){
        return getWebResource().get(TipoSujetoResult.class);
    }

    @Override
    public TipoSujetoDTO getById(Integer id){
        return getWebResource().path("/"+id).get(TipoSujetoDTO.class);
    }
}
