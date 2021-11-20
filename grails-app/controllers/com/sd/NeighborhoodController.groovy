package com.sd

import com.sd.clientsd.beans.location.NeighborhoodB
import com.sd.clientsd.service.location.INeighborhoodService
import static org.springframework.http.HttpStatus.*

class NeighborhoodController {

    INeighborhoodService neighborhoodService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def neighborhoods = neighborhoodService.getAllNotPaged();
        [neighborhoodList: neighborhoods, neighborhoodTotal: neighborhoods.size()]
    }

    def show(Long id) {
        respond neighborhoodService.get(id)
    }

    def create() {
        [neighborhoodInstance: new Neighborhood(params)]
    }

    def save(Neighborhood neighborhood) {
        def neighborhoodN = new NeighborhoodB(params)
        def neighborhoodInstance = neighborhoodService.save(neighborhoodN)

        if(!neighborhoodInstance.getId()){
            render(view: "create", model: [neighborhoodInstance: neighborhoodInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenunciaInstance.getId()])
            }
        }
        redirect(action: "index", id: neighborhoodInstance.getId())
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
        def neighborhoodBUpdated = neighborhoodService.update(neighborhoodB, neighborhoodB.getId())
        redirect(action: "index", id: neighborhoodBUpdated.getId())
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        neighborhoodService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'neighborhood.label', default: 'Neighborhood'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
