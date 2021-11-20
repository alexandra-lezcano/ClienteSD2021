package com.sd

import com.sd.clientsd.beans.CasosDerivados.DepEstadoB
import com.sd.clientsd.service.casosDerivados.IDepEstadoService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepEstadoController {

    IDepEstadoService depEstadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)
        //respond depEstadoService.list(params), model:[depEstadoCount: depEstadoService.count()]

        def depEstado=depEstadoService.getAllNotPaged()
                [depEstadoInstanceList:depEstado,depEstadoTotal: depEstado.size()]


    }

    def show(Long id) {
        DepEstadoB depEstadoB = depEstadoService.getById(id);
        [depEstadoInstance: depEstadoB]
        //respond depEstadoService.get(id)
    }

    def create() {

        [depEstadoInstance: new DepEstado(params) ]
      //  respond new DepEstado(params)
    }

    def save() {


        def depEstado = new DepEstadoB(params)
        def depEstadoInstance= depEstadoService.save(depEstado)

        if(!depEstadoInstance.getId()){
            render(view: "create", model: [depEstadoInstance: depEstadoInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'depEstado.label', default: 'depEstado'), depEstadoInstance.getId()])
            }
        }
        redirect(action: "index", id: depEstadoInstance.getId())

        /*
        if (depEstado == null) {
            notFound()
            return
        }

        try {
            depEstadoService.save(depEstado)
        } catch (ValidationException e) {
            respond depEstado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), depEstado.id])
                redirect depEstado
            }
            '*' { respond depEstado, [status: CREATED] }
        }*/
    }

    def edit(Long id) {
        def depEstadoInstance= depEstadoService.getById(id.toInteger())

        if(depEstadoInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [depEstadoInstance: depEstadoInstance]

        //respond depEstadoService.get(id)
    }

    def update(DepEstado depEstado) {

        def depEstadoB = new DepEstadoB(params)
        def depEstadoBup= depEstadoService.update(depEstadoB,depEstadoB.getId())
        redirect(action: "show", id: depEstadoBup.getId())

        /*
        if (depEstado == null) {
            notFound()
            return
        }

        try {
            depEstadoService.save(depEstado)
        } catch (ValidationException e) {
            respond depEstado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), depEstado.id])
                redirect depEstado
            }
            '*'{ respond depEstado, [status: OK] }
        }*/
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        depEstadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
