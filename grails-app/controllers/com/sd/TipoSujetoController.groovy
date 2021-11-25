package com.sd

import com.sd.clientsd.beans.denuncia.TipoSujetoB
import com.sd.clientsd.service.denuncia.ITipoSujetoService
import static org.springframework.http.HttpStatus.*

class TipoSujetoController {

    ITipoSujetoService tipoSujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def tipoSujetos = tipoSujetoService.getAll(page)

        [tipoSujetoInstanceList: tipoSujetos, tipoSujetosTotal: tipoSujetos.size()]

    }

    def show(Long id) {
        TipoSujetoB tipoSujetoB = tipoSujetoService.getById(id)
        [tipoSujetoInstance: tipoSujetoB]
    }

    def create() {
        [tipoSujetoInstance: new TipoSujeto(params)]
    }

    def save() {
        def tipoSujeto = new TipoSujetoB(params)
        def tipoSujetoInstance = tipoSujetoService.save(tipoSujeto)

        if(!tipoSujetoInstance.getId()){
            render(view: "create", model: [tipoSujetoInstance: tipoSujetoInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoSujeto.label', default: 'TipoSujeto'), tipoSujetoInstance.getId()])
            }
        }
        redirect(action: "list", id: tipoSujetoInstance.getId())
    }

    def edit(Long id) {
        def tipoSujetoInstance = tipoSujetoService.getById(id.toInteger())

        if(tipoSujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [tipoSujetoInstance: tipoSujetoInstance]
    }

    def update() {
        def tipoSujetoB = new TipoSujetoB(params)
        if(tipoSujetoB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        def tipoSujetoBUpdated = tipoSujetoService.update(tipoSujetoB, tipoSujetoB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def tipoSujetoInstance = tipoSujetoService.delete(id.toInteger())
        System.out.println("Se borro "+tipoSujetoInstance.id+" "+tipoSujetoInstance.titulo)

        if(tipoSujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'tipoSujeto.label', default: 'TipoSujeto'), id])

        redirect(action: 'list')
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
