package com.sd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CasosDerivadosController {

    CasosDerivadosService casosDerivadosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond casosDerivadosService.list(params), model:[casosDerivadosCount: casosDerivadosService.count()]
    }

    def show(Long id) {
        respond casosDerivadosService.get(id)
    }

    def create() {
        respond new CasosDerivados(params)
    }

    def save(CasosDerivados casosDerivados) {
        if (casosDerivados == null) {
            notFound()
            return
        }

        try {
            casosDerivadosService.save(casosDerivados)
        } catch (ValidationException e) {
            respond casosDerivados.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'casosDerivados.label', default: 'CasosDerivados'), casosDerivados.id])
                redirect casosDerivados
            }
            '*' { respond casosDerivados, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond casosDerivadosService.get(id)
    }

    def update(CasosDerivados casosDerivados) {
        if (casosDerivados == null) {
            notFound()
            return
        }

        try {
            casosDerivadosService.save(casosDerivados)
        } catch (ValidationException e) {
            respond casosDerivados.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'casosDerivados.label', default: 'CasosDerivados'), casosDerivados.id])
                redirect casosDerivados
            }
            '*'{ respond casosDerivados, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        casosDerivadosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'casosDerivados.label', default: 'CasosDerivados'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'casosDerivados.label', default: 'CasosDerivados'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
