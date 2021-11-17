package com.sd

import com.sd.clientsd.beans.denuncia.TipoDenunciaB
import com.sd.clientsd.service.denuncia.ITipoDenunciaService
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
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
    ITipoDenunciaService tipoDenunciaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)
       // redirect(action: 'list', params:params)
      //  def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])
        def page = 1
        def tipoDenunicas = tipoDenunciaService.getAll(page)
        [tipoDenunciaInstanceList: tipoDenunicas, tipoDenunciasTotal: tipoDenunicas.size()]
    }


    def show(Integer id) {
        def idtest = 1
        TipoDenunciaB tipoDenunciaB = tipoDenunciaService.getById(idtest)
        [tipoDenunciaInstance: tipoDenunciaB]
    }

    def create() {
        [tipoDenunciaInstance: new TipoDenuncia(params)]
    }

    def save() {
        def tipoDenuncia = new TipoDenunciaB(params)
        def tipoDenunciaInstance = tipoDenunciaService.save(tipoDenuncia)

        flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenunciaInstance.getId()])

        if(!tipoDenunciaInstance.getId()){
            render(view: "create", model: [tipoDenunciaInstance: tipoDenunciaInstance])
            return
        }

        redirect(action: "show", id: tipoDenunciaInstance.getId())
    }

    def edit(Long id) {
        def tipoDenunciaInstance = tipoDenunciaService.getById(id.toInteger())

        if(!tipoDenunciaInstance){
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'),
                    id])
            redirect(action: "index")
            return
        }

        [tipoDenunciaInstance: tipoDenunciaInstance]
    }

    def update(TipoDenuncia tipoDenuncia) {

    }

    def delete(Long id) {

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
