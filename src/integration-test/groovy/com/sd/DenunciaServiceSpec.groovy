package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DenunciaServiceSpec extends Specification {

    DenunciaService denunciaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Denuncia(...).save(flush: true, failOnError: true)
        //new Denuncia(...).save(flush: true, failOnError: true)
        //Denuncia denuncia = new Denuncia(...).save(flush: true, failOnError: true)
        //new Denuncia(...).save(flush: true, failOnError: true)
        //new Denuncia(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //denuncia.id
    }

    void "test get"() {
        setupData()

        expect:
        denunciaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Denuncia> denunciaList = denunciaService.list(max: 2, offset: 2)

        then:
        denunciaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        denunciaService.count() == 5
    }

    void "test delete"() {
        Long denunciaId = setupData()

        expect:
        denunciaService.count() == 5

        when:
        denunciaService.delete(denunciaId)
        sessionFactory.currentSession.flush()

        then:
        denunciaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Denuncia denuncia = new Denuncia()
        denunciaService.save(denuncia)

        then:
        denuncia.id != null
    }
}
