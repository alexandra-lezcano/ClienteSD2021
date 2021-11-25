package com.sd

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB
import com.sd.clientsd.service.casosDerivados.ICasosDerivadosService

import static org.springframework.http.HttpStatus.*

class CasosDerivadosController {


    ICasosDerivadosService casoDerivadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {

        redirect(action: 'list', params:params)

    }
    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def casosDerivados =  casoDerivadoService.getAll(page)

        [ casosDerivadosInstanceList: casosDerivados, casosDerivadosTotal: casosDerivados.size()]
    }


    def show(Long id) {
        CasoDerivadoB casosDerivadosB = casoDerivadoService.getById(id);
        [casosDerivadosInstance: casosDerivadosB]
        //respond depEstadoService.get(id)
    }

    def create() {

        [casosDerivadosInstance: new CasosDerivados(params) ]
        //  respond new DepEstado(params)
    }

    def save() {


        def casosDerivados = new CasoDerivadoB(params)
        def casosDerivadosInstance= casoDerivadoService.save(casosDerivados)

        if(!casosDerivadosInstance.getId()){
            render(view: "create", model: [casosDerivadosInstance: casosDerivadosInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'casosDerivados.label', default: 'casosDerivados'), casosDerivadosInstance.getId()])
            }
        }
        redirect(action: "list", id: casosDerivadosInstance.getId())


    }

    def edit(Long id) {
        def casosDerivadosInstance= casoDerivadoService.getById(id.toInteger())

        if(casosDerivadosInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [casosDerivadosInstance: casosDerivadosInstance]


    }

    def update(CasosDerivados casosDerivados) {

        def casosDerivadosB = new CasoDerivadoB(params)


        if(casosDerivadosB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def casosDerivadosBUpdated = casoDerivadoService.update(casosDerivadosB, casosDerivadosB.getId())

        redirect(action: 'list')


    }

    def delete(Long id) {
        def casosDerivadosInstance = casoDerivadoService.delete(id.toInteger())


        if(casosDerivadosInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'casosDerivados.label', default: 'CasosDerivados'), id])

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
