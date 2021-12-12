package com.sd

import com.sd.clientsd.beans.denuncia.TipoSujetoB
import com.sd.clientsd.service.denuncia.ITipoSujetoService
import com.sd.clientsd.utils.config.Configurations

import static org.springframework.http.HttpStatus.*

class TipoSujetoController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();
    ITipoSujetoService tipoSujetoService

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {

        def page=null ==params['page'] ? 0 : Integer.valueOf(params['page'])

        def tipoSujetos = tipoSujetoService.getAll(page)
        def prev = page -1;
        def sig = page+1;
        if(tipoSujetos.size() < ELEMS_PAGINATION){sig = -1}
        [tipoSujetoInstanceList: tipoSujetos, tipoSujetosTotal: tipoSujetos.size(), prev: prev, sig:sig]

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
