package com.sd

import grails.gorm.services.Service

@Service(TipoDenuncia)
interface TipoDenunciaService {

    TipoDenuncia get(Serializable id)

    List<TipoDenuncia> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoDenuncia save(TipoDenuncia tipoDenuncia)

}