package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoSujetoServiceSpec extends Specification {

    TipoSujetoService tipoSujetoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoSujeto(...).save(flush: true, failOnError: true)
        //new TipoSujeto(...).save(flush: true, failOnError: true)
        //TipoSujeto tipoSujeto = new TipoSujeto(...).save(flush: true, failOnError: true)
        //new TipoSujeto(...).save(flush: true, failOnError: true)
        //new TipoSujeto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoSujeto.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoSujetoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoSujeto> tipoSujetoList = tipoSujetoService.list(max: 2, offset: 2)

        then:
        tipoSujetoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoSujetoService.count() == 5
    }

    void "test delete"() {
        Long tipoSujetoId = setupData()

        expect:
        tipoSujetoService.count() == 5

        when:
        tipoSujetoService.delete(tipoSujetoId)
        sessionFactory.currentSession.flush()

        then:
        tipoSujetoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoSujeto tipoSujeto = new TipoSujeto()
        tipoSujetoService.save(tipoSujeto)

        then:
        tipoSujeto.id != null
    }
}
