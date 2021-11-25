package com.sd

import grails.gorm.services.Service

@Service(DenunciaEstado)
interface DenunciaEstadoService {

    DenunciaEstado get(Serializable id)

    List<DenunciaEstado> list(Map args)

    Long count()

    void delete(Serializable id)

    DenunciaEstado save(DenunciaEstado denunciaEstado)

}