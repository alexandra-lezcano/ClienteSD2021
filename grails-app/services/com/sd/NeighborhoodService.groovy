package com.sd

import grails.gorm.services.Service

@Service(Neighborhood)
interface NeighborhoodService {

    Neighborhood get(Serializable id)

    List<Neighborhood> list(Map args)

    Long count()

    void delete(Serializable id)

    Neighborhood save(Neighborhood neighborhood)

}