package com.sd

import grails.gorm.services.Service
// https://www.baeldung.com/grails-mvc-application#2-service-layer
@Service(TipoDenuncia)
interface TipoDenunciaService {

    TipoDenuncia get(Serializable id)

    List<TipoDenuncia> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoDenuncia save(TipoDenuncia tipoDenuncia)

}