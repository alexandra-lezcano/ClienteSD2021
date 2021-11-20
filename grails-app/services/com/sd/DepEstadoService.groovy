package com.sd

import grails.gorm.services.Service

@Service(DepEstado)
interface DepEstadoService {

    DepEstado get(Serializable id)

    List<DepEstado> list(Map args)

    Long count()

    void delete(Serializable id)

    DepEstado save(DepEstado depEstado)

}