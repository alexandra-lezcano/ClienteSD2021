package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DepEstadoServiceSpec extends Specification {

    DepEstadoService depEstadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DepEstado(...).save(flush: true, failOnError: true)
        //new DepEstado(...).save(flush: true, failOnError: true)
        //DepEstado depEstado = new DepEstado(...).save(flush: true, failOnError: true)
        //new DepEstado(...).save(flush: true, failOnError: true)
        //new DepEstado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //depEstado.id
    }

    void "test get"() {
        setupData()

        expect:
        depEstadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DepEstado> depEstadoList = depEstadoService.list(max: 2, offset: 2)

        then:
        depEstadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        depEstadoService.count() == 5
    }

    void "test delete"() {
        Long depEstadoId = setupData()

        expect:
        depEstadoService.count() == 5

        when:
        depEstadoService.delete(depEstadoId)
        sessionFactory.currentSession.flush()

        then:
        depEstadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DepEstado depEstado = new DepEstado()
        depEstadoService.save(depEstado)

        then:
        depEstado.id != null
    }
}
