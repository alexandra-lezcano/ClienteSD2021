package com.sd
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.beans.denuncia.TipoDenunciaB
import com.sd.clientsd.beans.location.NeighborhoodB
import com.sd.clientsd.service.location.INeighborhoodService
import com.sd.clientsd.utils.config.Configurations
import grails.validation.ValidationException
import org.grails.datastore.mapping.query.Query.In

import static org.springframework.http.HttpStatus.*

class NeighborhoodController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();
    INeighborhoodService neighborhoodService
    ICityService cityService
    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {
        def page= null == params['page'] ? 0 : Integer.valueOf(params['page'])
        def city = 0;
        try {
            city = null == params['find'] ? -1 : Integer.valueOf(params['find'])
        } catch (NumberFormatException e){
            city = 0;
        }
        def neighborhoods = null;
        if(city > 0) {
            neighborhoods = neighborhoodService.getAllByCityPaged(city, page)
        }
        else {
            neighborhoods = neighborhoodService.getAll(page)
        }
        def prev = page - 1
        def sig = page + 1
        if(neighborhoods.size() < ELEMS_PAGINATION) {sig = -1}
        def cities = cityService.getAllNotPaged()
        [neighborhoodInstanceList: neighborhoods, neighborhoodsTotal: neighborhoods.size(),
         prev: prev, sig: sig, cityInstanceList: cities, find: city]
    }

    def listCities() {
        def cities = cityService.getAllNotPaged()
        [cityInstanceList: cities, citiesTotal: cities.size()]
    }

    //Cuando llama a update table desde la vista con el boton de busqueda
    def updateTable (Integer find){
        def page=null ==params['page'] ? 0 : Integer.valueOf(params['page'])
        def neighborhoodInstanceList = null;
        def city = find
        if(city > 0){
            neighborhoodInstanceList = neighborhoodService.getAllByCityPaged(city, page)
        } else {
            neighborhoodInstanceList = neighborhoodService.getAll(page)
        }
        def prev = page - 1
        def sig = page + 1
        if (neighborhoodInstanceList.size() < ELEMS_PAGINATION) {sig = -1}
        render(template: 'table', model:[neighborhoodInstanceList: neighborhoodInstanceList, sig: sig, prev:prev, find: city])
    }

    def updatePagination(Integer isBusqueda, Integer prev, Integer sig){
        render(template: '/layouts/pagination', model:[isBusqueda: isBusqueda, prev: prev, sig: sig])
    }

    def show(Long id) {
        NeighborhoodB neighborhoodB = neighborhoodService.getById(id)
        [neighborhoodInstance: neighborhoodB]
    }

    def create() {
        //def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def cities = cityService.getAllNotPaged()

        [cityInstanceList: cities, citiesTotal: cities.size(),
        cityInstance: new City(params),neighborhoodInstance: new Neighborhood (params)]

    }

    def save() {
        def neighborhood = new NeighborhoodB(params)

        System.out.println("param"+params['city_id'])
        neighborhood.setCity_id(cityService.getById(Integer.parseInt(params['city_id'])))

        def neighborhoodInstance = neighborhoodService.save(neighborhood)

        if(!neighborhoodInstance.getId()){
            render(view: "create", model: [neighborhoodInstance: neighborhoodInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'neighborhood.label', default: 'Neighborhood'), neighborhoodInstance.getId()])
            }
        }
        redirect(action: "list")
    }

    def edit(Long id) {
        def neighborhoodInstance = neighborhoodService.getById(id.toInteger())

        if(neighborhoodInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        def cities = cityService.getAllNotPaged()

        [neighborhoodInstance: neighborhoodInstance, cityInstanceList: cities]
    }

    def update(Neighborhood neighborhood) {
        def neighborhoodB = new NeighborhoodB(params)

        if(neighborhoodB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        neighborhoodB.setCity_id(cityService.getById(Integer.parseInt(params['city_id'])))

        def neighborhoodBUpdated = neighborhoodService.update(neighborhoodB, neighborhoodB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def neighborhoodInstance = neighborhoodService.delete(id.toInteger())


        if(neighborhoodInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), id])

        redirect(action: 'list')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'neighborhood.label', default: 'Neighborhood'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
