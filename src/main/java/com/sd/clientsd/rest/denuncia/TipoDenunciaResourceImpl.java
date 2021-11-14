package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;


// repository acaso no es la clase de nuestros daos?
@Repository(value = "tipoDenunciaResource")
public class TipoDenunciaResourceImpl extends BaseResourceImpl<TipoDenunciaDTO> implements ITipoDenunciaResource{

    // todo agregar esto a un archivo de configuracion!
    public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, "/tipoDenuncias");
    }

     /* todo implementar getAll y otros metodos para busqueda y filtrado
    @Override
    public TipoDenunciaResult getAll(Pageable pageable) {
        // return getWebResource().path("/page"+id).get(this.dtoClass);??
        return null;
    }*/
}
