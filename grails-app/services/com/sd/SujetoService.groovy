package com.sd

import grails.gorm.services.Service

@Service(Sujeto)
interface SujetoService {

    Sujeto get(Serializable id)

    List<Sujeto> list(Map args)

    Long count()

    void delete(Serializable id)

    Sujeto save(Sujeto sujeto)

}