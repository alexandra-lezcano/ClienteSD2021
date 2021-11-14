package com.sd.clientsd.rest.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

// repository acaso no es la clase de nuestros daos?
@Repository("tipoDenunciaRepository")
public class TipoDenunciaResourceImpl extends BaseResourceImpl<TipoDenunciaDTO, TipoDenunciaResult> implements ITipoDenunciaResource{

    // todo agregar esto a un archivo de configuracion!
    public TipoDenunciaResourceImpl() {
        super(TipoDenunciaDTO.class, "/tipoDenuncias");
    }
}
