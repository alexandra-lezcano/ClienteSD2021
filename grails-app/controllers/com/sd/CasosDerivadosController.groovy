package com.sd

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB
import com.sd.clientsd.service.casosDerivados.ICasosDerivadosService
import com.sd.clientsd.service.casosDerivados.IDepEstadoService
import com.sd.clientsd.utils.config.Configurations
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class CasosDerivadosController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();

    ICasosDerivadosService casoDerivadoService
    IDepEstadoService depEstadoService
    static allowedMethods = [save: "POST", update: "PUT"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {

        redirect(action: 'list', params:params)

    }
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer max) {
        def page= null == params['page'] ? 0 : Integer.valueOf(params['page'])

        def casosDerivados =  casoDerivadoService.getAll(page)
        def prev = page - 1;
        def sig = page + 1;
        if(casosDerivados.size() < ELEMS_PAGINATION){sig = -1}
        def depEstado =  depEstadoService.getAll(page)

        [ depEstadoInstanceList: depEstado, depEstadoTotal: depEstado.size()
        ,casosDerivadosInstanceList: casosDerivados, casosDerivadosTotal: casosDerivados.size(),
        sig: sig, prev: prev]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        CasoDerivadoB casosDerivadosB = casoDerivadoService.getById(id);
        [casosDerivadosInstance: casosDerivadosB]
        //respond depEstadoService.get(id)
    }
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {

        def depEstados= depEstadoService.getAllNotPaged()
        def depEstadoNuevo = casoDerivadoService.newLista();
        [depEstadoInstanceList: depEstados,depEstadoNewLista:depEstadoNuevo, depEstadoInstance: new DepEstado(params), casosDerivadosInstance: new CasosDerivados(params)]
        //  respond new DepEstado(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {


        def casosDerivados = new CasoDerivadoB(params)
        Set<DepEstadoB> dependencias= new HashSet<DepEstadoB>();
       for (String d: params['depEstadoBSet']){
           dependencias.add(depEstadoService.getById(Integer.parseInt(d)))

       }

        casosDerivados.setDepEstadoBSet(dependencias)


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
        redirect(action: "list")


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

        def casosDerivadosInstance = casoDerivadoService.update(casosDerivadosB, casosDerivadosB.getId())

        redirect(action: 'list')


    }

    def delete(Long id) {
        System.out.print(id)
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
