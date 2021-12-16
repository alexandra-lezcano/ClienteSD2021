package com.sd

import com.sd.clientsd.beans.CasosDerivados.DepEstadoB
import com.sd.clientsd.service.casosDerivados.IDepEstadoService
import com.sd.clientsd.utils.config.Configurations
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepEstadoController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();

    IDepEstadoService depEstadoService

    static allowedMethods = [save: "POST", update: "PUT"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {

        redirect(action: 'list', params:params)

    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer max) {
        def page=null ==params['id'] ? 0 : Integer.valueOf(params['id'])
        def searchString = null
        searchString = null == params['find'] ? null : params['find']
        def depEstado = null;
        if(!searchString.equals("") || null == searchString) {
            depEstado = depEstadoService.getAll(page)
        } else {
            depEstado = depEstadoService.getAllByName(searchString, page)
        }
        def prev = page -1
        def sig = page +1
        if(sig <= ELEMS_PAGINATION){sig = -1}
        [ depEstadoInstanceList: depEstado, depEstadoTotal: depEstado.size(), sig: sig, prev: prev, find: searchString]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def updateTable(String find){
        def page=null ==params['id'] ? 0 : Integer.valueOf(params['id'])
        def searchString = find
        def depEstado = null;
        if(searchString.equals("")) {
            depEstado = depEstadoService.getAll(page)
        } else {
            depEstado = depEstadoService.getAllByName(searchString, page)
        }
        def prev = page -1
        def sig = page +1
        if(sig <= ELEMS_PAGINATION){sig = -1}
        render(template: 'table', model:[depEstadoInstanceList: depEstado, depEstadoTotal: depEstado.size(), sig: sig, prev: prev, find: searchString])
    }


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        DepEstadoB depEstadoB = depEstadoService.getById(id);
        [depEstadoInstance: depEstadoB]
        //respond depEstadoService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {


        [depEstadoInstance: new DepEstado(params) ]

      //  respond new DepEstado(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {


        def depEstado = new DepEstadoB(params)
        def depEstadoInstance= depEstadoService.save(depEstado)

        if(!depEstadoInstance.getId()){
            render(view: "create", model: [depEstadoInstance: depEstadoInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'depEstado.label', default: 'depEstado'), depEstadoInstance.getId()])
            }
        }
        redirect(action: "list")

        /*
        if (depEstado == null) {
            notFound()
            return
        }

        try {
            depEstadoService.save(depEstado)
        } catch (ValidationException e) {
            respond depEstado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), depEstado.id])
                redirect depEstado
            }
            '*' { respond depEstado, [status: CREATED] }
        }*/
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Long id) {
        def depEstadoInstance= depEstadoService.getById(id.toInteger())

        if(depEstadoInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [depEstadoInstance: depEstadoInstance]

        //respond depEstadoService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update(DepEstado depEstado) {

        def depEstadoB = new DepEstadoB(params)


        if(depEstadoB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def depEstadoBUpdated = depEstadoService.update(depEstadoB, depEstadoB.getId())

        redirect(action: 'list')


    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def delete(Long id) {
        def depEstadoInstance = depEstadoService.delete(id.toInteger())


        if(depEstadoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'depEstado.label', default: 'DepEstado'), id])

        redirect(action: 'list')



    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'depEstado.label', default: 'DepEstado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
