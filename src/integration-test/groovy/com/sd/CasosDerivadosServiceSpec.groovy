package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CasosDerivadosServiceSpec extends Specification {

    CasosDerivadosService casosDerivadosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CasosDerivados(...).save(flush: true, failOnError: true)
        //new CasosDerivados(...).save(flush: true, failOnError: true)
        //CasosDerivados casosDerivados = new CasosDerivados(...).save(flush: true, failOnError: true)
        //new CasosDerivados(...).save(flush: true, failOnError: true)
        //new CasosDerivados(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //casosDerivados.id
    }

    void "test get"() {
        setupData()

        expect:
        casosDerivadosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CasosDerivados> casosDerivadosList = casosDerivadosService.list(max: 2, offset: 2)

        then:
        casosDerivadosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        casosDerivadosService.count() == 5
    }

    void "test delete"() {
        Long casosDerivadosId = setupData()

        expect:
        casosDerivadosService.count() == 5

        when:
        casosDerivadosService.delete(casosDerivadosId)
        sessionFactory.currentSession.flush()

        then:
        casosDerivadosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CasosDerivados casosDerivados = new CasosDerivados()
        casosDerivadosService.save(casosDerivados)

        then:
        casosDerivados.id != null
    }
}
