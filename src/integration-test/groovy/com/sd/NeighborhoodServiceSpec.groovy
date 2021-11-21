package com.sd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NeighborhoodServiceSpec extends Specification {

    NeighborhoodService neighborhoodService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Neighborhood(...).save(flush: true, failOnError: true)
        //new Neighborhood(...).save(flush: true, failOnError: true)
        //Neighborhood neighborhood = new Neighborhood(...).save(flush: true, failOnError: true)
        //new Neighborhood(...).save(flush: true, failOnError: true)
        //new Neighborhood(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //neighborhood.id
    }

    void "test get"() {
        setupData()

        expect:
        neighborhoodService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Neighborhood> neighborhoodList = neighborhoodService.list(max: 2, offset: 2)

        then:
        neighborhoodList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        neighborhoodService.count() == 5
    }

    void "test delete"() {
        Long neighborhoodId = setupData()

        expect:
        neighborhoodService.count() == 5

        when:
        neighborhoodService.delete(neighborhoodId)
        sessionFactory.currentSession.flush()

        then:
        neighborhoodService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Neighborhood neighborhood = new Neighborhood()
        neighborhoodService.save(neighborhood)

        then:
        neighborhood.id != null
    }
}
