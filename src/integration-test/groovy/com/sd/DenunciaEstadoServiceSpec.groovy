package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DenunciaEstadoServiceSpec extends Specification {

    DenunciaEstadoService denunciaEstadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DenunciaEstado(...).save(flush: true, failOnError: true)
        //new DenunciaEstado(...).save(flush: true, failOnError: true)
        //DenunciaEstado denunciaEstado = new DenunciaEstado(...).save(flush: true, failOnError: true)
        //new DenunciaEstado(...).save(flush: true, failOnError: true)
        //new DenunciaEstado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //denunciaEstado.id
    }

    void "test get"() {
        setupData()

        expect:
        denunciaEstadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DenunciaEstado> denunciaEstadoList = denunciaEstadoService.list(max: 2, offset: 2)

        then:
        denunciaEstadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        denunciaEstadoService.count() == 5
    }

    void "test delete"() {
        Long denunciaEstadoId = setupData()

        expect:
        denunciaEstadoService.count() == 5

        when:
        denunciaEstadoService.delete(denunciaEstadoId)
        sessionFactory.currentSession.flush()

        then:
        denunciaEstadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DenunciaEstado denunciaEstado = new DenunciaEstado()
        denunciaEstadoService.save(denunciaEstado)

        then:
        denunciaEstado.id != null
    }
}
