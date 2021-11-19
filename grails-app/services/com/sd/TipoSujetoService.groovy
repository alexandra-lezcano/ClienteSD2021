package com.sd

import grails.gorm.services.Service

@Service(TipoSujeto)
interface TipoSujetoService {

    TipoSujeto get(Serializable id)

    List<TipoSujeto> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoSujeto save(TipoSujeto tipoSujeto)

}