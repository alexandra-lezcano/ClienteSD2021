package com.sd

import com.sd.clientsd.beans.denuncia.SujetoB
import com.sd.clientsd.service.denuncia.ISujetoService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SujetoController {

    ISujetoService sujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def sujetos = sujetoService.getAllNotPage()
        [sujetosInstanceList: sujetos, sujetosTotal: sujetos.size()]
    }

    def show(Long id) {
        SujetoB sujetoB = sujetoService.getById(id)
        [sujetoInstance: sujetoB]
    }

    def create() {
        [sujetoInstance: new Sujeto(params)]
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
        def sujetoB = new SujetoB(params)
        def sujetoBUpdated = sujetoService.update(sujetoB, sujetoB.getId())
        redirect(action: "index", id: sujetoBUpdated.getId())
    }

    def update(Sujeto sujeto) {
        if (sujeto == null) {
            notFound()
            return
        }

        try {
            sujetoService.save(sujeto)
        } catch (ValidationException e) {
            respond sujeto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sujeto.label', default: 'Sujeto'), sujeto.id])
                redirect sujeto
            }
            '*'{ respond sujeto, [status: OK] }
        }
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
