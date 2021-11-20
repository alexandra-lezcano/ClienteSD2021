package com.sd

import com.sd.clientsd.beans.denuncia.TipoSujetoB
import com.sd.clientsd.service.denuncia.ITipoSujetoService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoSujetoController {

    ITipoSujetoService tipoSujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        //params.max = Math.min(max ?: 10, 100)
        //respond tipoSujetoService.list(params), model:[tipoSujetoCount: tipoSujetoService.count()]

        //todo ver esto!!
        def tipoSujetos = tipoSujetoService.getAllNotPage();
        [tipoSujetoInstanceList: tipoSujetos, tipoSujetosTotal: tipoSujetos.size()]
    }

    def show(Long id) {
        //respond tipoSujetoService.get(id)
        TipoSujetoB tipoSujetoB = tipoSujetoService.getById(id)
        [tipoSujetoInstanceList: tipoSujetoB]
    }

    def create() {
        //respond new TipoSujeto(params)
        [tipoSujetoInstance: new TipoSujeto(params)]
    }

    def save() {
        def tipoSujeto = new TipoSujetoB(params)
        def tipoSujetoInstance = tipoSujetoService.save(tipoSujeto)
        if(!tipoSujetoInstance.getId()){
            render(view: "create", model: [tipoDenunciaInstance: tipoSujetoInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args:[message(code: 'tipoSujeto.label', default: 'tipoSujeto'), tipoSujetoInstance.getId()])
            }
        }
        redirect(action: 'index', id: tipoSujetoInstance.getId())
    }

    def edit(Long id) {
        //respond tipoSujetoService.get(id)
        def tipoSujetoInstance = tipoSujetoService.getById(id.toInteger())
        if(tipoDenunciaInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [tipoSujetoInstance: tipoSujetoInstance]
    }

    def update() {
        def tipoSujetoB = new TipoSujeto(params)
        def tipoSujetoBUpdated = tipoSujetoService.update(tipoSujetoB, tipoSujetoB.getId())
        redirect(action: 'show', id: tipoSujetoBUpdated.getId())
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoSujetoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoSujeto.label', default: 'TipoSujeto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoSujeto.label', default: 'TipoSujeto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
