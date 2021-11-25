package com.sd

import com.sd.clientsd.beans.denuncia.SujetoB
import com.sd.clientsd.service.denuncia.ISujetoService
import com.sd.clientsd.service.denuncia.ITipoSujetoService
import static org.springframework.http.HttpStatus.*

class SujetoController {

    ISujetoService sujetoService
    ITipoSujetoService tipoSujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])
        def sujetos = sujetoService.getAll(page)
        [sujetoInstanceList: sujetos, sujetosTotal: sujetos.size()]
    }

    def show(Long id) {
        SujetoB sujetoB = sujetoService.getById(id)
        [sujetoInstance: sujetoB]
    }

    def create() {
        def page=null ==params['tipo'] ? 1 : Integer.valueOf(params['tipo'])

        def tipoSujetos = tipoSujetoService.getAll(page)

        [tipoSujetoInstanceList: tipoSujetos, tipoSujetosTotal: tipoSujetos.size(),
         tipoSujetoInstance: new TipoSujeto(params), sujetoInstance: new Sujeto(params)]
    }

    def save() {
        def sujeto = new SujetoB(params)
        sujeto.setTipo(tipoSujetoService.getById(Integer.parseInt(params['tipo'])))
        def sujetoInstance = sujetoService.save(sujeto)

        if(!sujetoInstance.getId()){
            render(view: "create", model: [tipoDenunciaInstance: sujetoInstance])
            return
        }
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'sujeto.label', default: 'Sujeto'), sujetoInstance.getId()])
            }
        }
        redirect(action: "index", id: sujetoInstance.getId())
    }

    def edit(Long id) {
        def sujetoInstance = sujetoService.getById(id.toInteger())

        if(sujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def page=null ==params['tipo'] ? 1 : Integer.valueOf(params['tipo'])

        def tipoSujetos = tipoSujetoService.getAll(page)

        [tipoSujetoInstanceList: tipoSujetos, tipoSujetosTotal: tipoSujetos.size(), sujetoInstance: sujetoInstance]
    }

    def update(Long id) {
        def sujetoInstance = sujetoService.delete(id.toInteger())
        if(sujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'sujeto.label', default: 'Sujeto'), id])

        redirect(action: 'list')
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sujetoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sujeto.label', default: 'Sujeto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sujeto.label', default: 'Sujeto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
