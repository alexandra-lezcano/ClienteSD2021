package com.sd

import com.sd.clientsd.beans.denuncia.SujetoB
import com.sd.clientsd.service.denuncia.ISujetoService
import static org.springframework.http.HttpStatus.*

class SujetoController {

    ISujetoService sujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def show(Long id) {
        SujetoB SujetoB = sujetoService.getById(id)
        [sujetoInstance: sujetoB]
    }

    def create() {
        [sujetoInstance: new Sujeto(params)]
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def sujetos = sujetoService.getAll(page)

        [sujetoInstanceList: sujetos, sujetosTotal: sujetos.size()]
    }

    def save() {
        def sujeto = new SujetoB(params)
        def sujetoInstance = sujetoService.save(sujeto)
        if(!sujetoInstance.getId()){
            render(view: "create", model: [sujetoInstance: sujetoInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'sujeto.label', default: 'sujeto'), sujetoInstance.getId()])
            }
        }
        redirect(action: "index", id: sujeto.getId())
    }

    def edit(Long id) {
        def sujetoInstance = sujetoService.getById(id.toInteger())

        if(sujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [sujetoInstance: sujetoInstance]
    }

    def update() {
        def sujetoB = new SujetoB(params)

        if(sujetoB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def sujetoBUpdated = sujetoService.update(sujetoB, sujetoB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def sujetoInstance = sujetoService.delete(id.toInteger())

        if(sujetoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'sujeto.label', default: 'Sujeto'), id])

        redirect(action: 'list')
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
