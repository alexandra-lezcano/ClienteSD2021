package com.sd
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.beans.denuncia.TipoDenunciaB
import com.sd.clientsd.beans.location.NeighborhoodB
import com.sd.clientsd.service.location.INeighborhoodService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NeighborhoodController {

    INeighborhoodService neighborhoodService
    ICityService cityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def neighborhoods = neighborhoodService.getAll(page)

        [neighborhoodInstanceList: neighborhoods, neighborhoodsTotal: neighborhoods.size()]


    }

    def listCities(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def cities = cityService.getAll(page)

        [cityInstanceList: cities, citiesTotal: cities.size()]
    }


    def show(Long id) {
        NeighborhoodB neighborhoodB = neighborhoodService.getById(id)
        [neighborhoodInstance: neighborhoodB]
    }

    def create() {
        [tipoDenunciaInstance: new TipoDenuncia(params)]
    }

    def save() {
        def neighborhood = new NeighborhoodB(params)

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
        redirect(action: "show", id: neighborhoodInstance.getId())
    }

    def edit(Long id) {
        def neighborhoodInstance = neighborhoodService.getById(id.toInteger())

        if(neighborhoodInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [neighborhoodInstance: neighborhoodInstance]
    }

    def update(Neighborhood neighborhood) {
        def neighborhoodB = new NeighborhoodB(params)

        if(neighborhoodB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def neighborhoodBUpdated = neighborhoodService.update(neighborhoodB, neighborhoodB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def neighborhoodInstance = neighborhoodService.delete(id.toInteger())
        System.out.println("Se borro "+neighborhoodInstance.id+" "+neighborhoodInstance.titulo)
        // como hago para mostrar la tabla en la paginacion que ya estaba?

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
