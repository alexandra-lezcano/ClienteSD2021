package com.sd

import grails.gorm.services.Service

@Service(CasosDerivados)
interface CasosDerivadosService {

    CasosDerivados get(Serializable id)

    List<CasosDerivados> list(Map args)

    Long count()

    void delete(Serializable id)

    CasosDerivados save(CasosDerivados casosDerivados)

}