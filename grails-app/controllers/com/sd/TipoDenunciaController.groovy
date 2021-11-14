package com.sd

import com.sd.clientsd.beans.denuncia.TipoDenunciaB
import com.sd.clientsd.service.denuncia.ITipoDenunciaService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoDenunciaController {

    /* IOC - Groovy:
    *  Para que esto funcione, los servicios deben ser configurados con el mimo nombre de la clase dentro de
    *  grails-app/conf/spring/resources.groovy
    *
    *  El nombre de la variable tambien debe ser lo mismo en la anotacion de TipoDenunciaServiceImpl:
    *  @Service("tipoDenunciaService")  */

    //services
    def ITipoDenunciaService tipoDenunciaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoDenunciaService.list(params), model:[tipoDenunciaCount: tipoDenunciaService.count()]
    }

    def show(Long id) {
        respond tipoDenunciaService.get(id)
    }

    def create() {
        respond new TipoDenuncia(params)
    }

    def save() {
        def tipoDenunciaInstance = new TipoDenunciaB(params)
        def tipoDenunciaResponse = tipoDenunciaService.save(tipoDenunciaInstance)
        if (!tipoDenunciaResponse.getId()){
            render(view: "create", model: [tipoDenunciaInstance: tipoDenunciaInstance])
            return
        }
        form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenuncia.id])
            redirect tipoDenuncia
        }

        return
    }

    def edit(Long id) {
        respond tipoDenunciaService.get(id)
    }

    def update(TipoDenuncia tipoDenuncia) {
        if (tipoDenuncia == null) {
            notFound()
            return
        }

        try {
            tipoDenunciaService.save(tipoDenuncia)
        } catch (ValidationException e) {
            respond tipoDenuncia.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenuncia.id])
                redirect tipoDenuncia
            }
            '*'{ respond tipoDenuncia, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoDenunciaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
