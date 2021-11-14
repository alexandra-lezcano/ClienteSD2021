package com.sd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CiudadController {

    CiudadService ciudadService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ciudadService.list(params), model:[ciudadCount: ciudadService.count()]
    }

    def show(Long id) {
        respond ciudadService.get(id)
    }

    def create() {
        respond new Ciudad(params)
    }

    def save(Ciudad ciudad) {
        if (ciudad == null) {
            notFound()
            return
        }

        try {
            ciudadService.save(ciudad)
        } catch (ValidationException e) {
            respond ciudad.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ciudad.label', default: 'Ciudad'), ciudad.id])
                redirect ciudad
            }
            '*' { respond ciudad, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ciudadService.get(id)
    }

    def update(Ciudad ciudad) {
        if (ciudad == null) {
            notFound()
            return
        }

        try {
            ciudadService.save(ciudad)
        } catch (ValidationException e) {
            respond ciudad.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ciudad.label', default: 'Ciudad'), ciudad.id])
                redirect ciudad
            }
            '*'{ respond ciudad, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ciudadService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ciudad.label', default: 'Ciudad'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ciudad.label', default: 'Ciudad'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
