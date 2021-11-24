package com.sd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SujetoController {

    SujetoService sujetoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sujetoService.list(params), model:[sujetoCount: sujetoService.count()]
    }

    def show(Long id) {
        respond sujetoService.get(id)
    }

    def create() {
        respond new Sujeto(params)
    }

    def save(Sujeto sujeto) {
        if (sujeto == null) {
            notFound()
            return
        }

        try {
            sujetoService.save(sujeto)
        } catch (ValidationException e) {
            respond sujeto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sujeto.label', default: 'Sujeto'), sujeto.id])
                redirect sujeto
            }
            '*' { respond sujeto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sujetoService.get(id)
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
