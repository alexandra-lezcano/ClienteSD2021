package com.sd

import com.sd.clientsd.beans.denuncia.TipoSujetoB
import com.sd.clientsd.service.denuncia.ITipoSujetoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException

import static org.springframework.http.HttpStatus.*

class TipoSujetoController {

    def ITipoSujetoService tipoSujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: "list", params: params)
    }

    def list(Integer max){
        def tipos = tipoSujetoService.getAll(1)
        [tipoSujetoInstanceList: tipos, tipoSujetoInstanceTotal: tipos.size()]
    }

    def show(Long id) {
        def tipoSujetoInstance = tipoSujetoService.getById(id.intValue())
        if(!tipoSujetoInstance){
            flash.message = message(code:"default.not.found.message", args:[
                    message(code: "tipoSujeto.label", default:"TipoSujeto"),id
            ])
            redirect(action: "list")
            return
        }
        [tipoSujetoInstance: tipoSujetoInstance]
    }

    def create() {
        [tipoSujetoInstance: new TipoSujetoB(params)]
    }

    def save(TipoSujeto tipoSujeto) {
        def tipoSujetoInstance = new TipoSujetoB(params);
        def newTipoSujeto = tipoSujetoService.save(tipoSujetoInstance)
        if(!newTipoSujeto?.getId()){
            render(view: "create", model:[tipoSujetoInstance: tipoSujetoInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args:[
                message(code: 'tipoSujeto.label', default: 'TipoSujeto'),newTipoSujeto.getId()
        ])
        redirect(action: "show", id: newTipoSujeto.getId())
    }

    def edit(Long id) {
        def tipoSujetoInstance = TipoSujeto.get(id);
        if(!tipoSujetoInstance){
            flash.message=message(code:'default.not.found.message', args:[
                    message(code: "tipoSujeto.label", default: "TipoSujeto"),id
            ])
            redirect(action: "list")
            return
        }
        [tipoSujetoInstance: tipoSujetoInstance]
    }

    def update(TipoSujeto tipoSujeto) {
        def tipoSujetoInstance = TipoSujeto.get(id)
        if(!tipoSujetoInstance){
            flash.message=message(code:'default.not.found.message', args:[
                    message(code: "tipoSujeto.label", default: "TipoSujeto"),id
            ])
            redirect(action: "list")
            return
        }
        if(version!=null){
            if(tipoSujetoInstance.version>version){
                tipoSujetoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                        message(code:"tipoSujeto.label", default:"TipoSujeto")] as Object [],getIndices(),"Otro usuario edito esto mientras editabas")
                render(view: "edit", model: [tipoSujetoInstance: tipoSujetoInstance])
                return
            }
        }
        tipoSujetoInstance.properties = params

        if(!tipoSujetoInstance.save(flush:true)){
            render(view:"edit", model:[tipoSujetoInstance: tipoSujetoInstance])
            return
        }

        (flash.message = message(code: "default.updated.message", args: [
                message(code: "tipoSujeto.label", default: "TipoSujeto"),
                tipoSujetoInstance.id
        ]))
        redirect (action:"show", id:tipoSujetoInstance.id)
    }

    def delete(Long id) {
        def tipoSujetoInstance = TipoSujeto.get(id)
        if (!tipoSujetoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'tipoSujeto.label', default: 'TipoSujeto'),
                    id
            ])
            redirect(action: "list")
            return
        }

        try {
            tipoSujetoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'tipoSujeto.label', default: 'Country'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'tipoSujeto.label', default: 'Country'),
                    id
            ])
            redirect(action: "show", id: id)
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
