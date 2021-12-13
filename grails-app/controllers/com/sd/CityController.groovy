package com.sd
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.utils.config.Configurations
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class CityController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();

    ICityService cityService

    static allowedMethods = [save: "POST", update: "PUT"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def show(Long id) {
        def cityB = cityService.getById(id.toInteger())
        def neighborhoods = cityB.getNeighborhoodBList()
        [cityInstance: cityB, neighborhoodInstanceList: neighborhoods]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer max) {
        def page=null ==params['page'] ? 0 : Integer.valueOf(params['page'])
        def cities = cityService.getAll(page)
        def prev = page - 1;
        def sig = page + 1;
        if(cities.size() < ELEMS_PAGINATION){sig = -1}

        [cityInstanceList: cities, citiesTotal: cities.size(), sig: sig, prev: prev]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        [cityInstance: new City(params)]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        def city = new CityB(params)
        def cityInstance = cityService.save(city)

        if(!cityInstance.getId()){
            render(view: "create", model: [cityInstance: cityInstance])
            return
        }

        // Muestra un mensajito por defecto
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'Ciudad'), cityInstance.getId()])
            }
        }
        redirect(action: "list")
    }
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Long id) {
        def cityInstance = cityService.getById(id.toInteger())

        if(cityInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [cityInstance: cityInstance]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update(City city) {
        def cityB = new CityB(params)

        if(cityB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def cityBUpdated = cityService.update(cityB, cityB.getId())
        redirect(action: 'list')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def delete(Long id) {
        def cityInstance = cityService.delete(id.toInteger())

        if(cityInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'city.label', default: 'City'), id])

        redirect(action: 'list')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
