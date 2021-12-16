package com.sd

import grails.gorm.services.Service

@Service(Users)
interface UserService {

    Users get(Serializable id)

    List<Users> list(Map args)

    Long count()

    void delete(Serializable id)

    Users save(Users user)

}