package com.sd

import com.sd.clientsd.beans.denuncia.TipoDenunciaB
import com.sd.clientsd.service.denuncia.ITipoDenunciaService
import static org.springframework.http.HttpStatus.*

class TipoDenunciaController {

    /* IOC - Groovy:
    *  Para que esto funcione, los servicios deben ser configurados con el mimo nombre de la clase dentro de
    *  grails-app/conf/spring/resources.groovy
    *
    *  El nombre de la variable tambien debe ser lo mismo en la anotacion de TipoDenunciaServiceImpl:
    *  @Service("tipoDenunciaService")  */

    //services
    ITipoDenunciaService tipoDenunciaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)
       // redirect(action: 'list', params:params)
      //  def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])
       // def page = 1
        def tipoDenunicas = tipoDenunciaService.getAllNotPaged()
        [tipoDenunciaInstanceList: tipoDenunicas, tipoDenunciasTotal: tipoDenunicas.size()]
    }


    def show(Integer id) {
        TipoDenunciaB tipoDenunciaB = tipoDenunciaService.getById(id)
        [tipoDenunciaInstance: tipoDenunciaB]
    }

    /* URL: /tipoDenuncia
    *  VIEW:
    *       ATRIBUTOS: <g:textField name="titulo" value="${tipoDenunciaInstance?.titulo}"/>
    *       ACCION:
    *       <g:submitButton
    *           name="create"
    *
    *       DETALLES DE AL ACCION:
    *       name: metodo del bean a ser invocado
    *
    * Cuando estoy en create.gsp:
    * 1- obtiene todos los atributos del bean atravez de value= ${Objeto.?atributo}
    * 2- al apretar el boton de guardar llamar al metodo en ObjetoB, en este caso create
    * con los atributos seteados en objetoInstance
    * 3- invocar al metodo "save" detro del controlador
    *   */
    def create() {
        // envia un map al create view
        [tipoDenunciaInstance: new TipoDenuncia(params)]
    }

    def save() {
        def tipoDenuncia = new TipoDenunciaB(params)
        def tipoDenunciaInstance = tipoDenunciaService.save(tipoDenuncia)

        if(!tipoDenunciaInstance.getId()){
            render(view: "create", model: [tipoDenunciaInstance: tipoDenunciaInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenunciaInstance.getId()])
            }
        }
        redirect(action: "show", id: tipoDenunciaInstance.getId())
    }

    /* URL: /tipoDenuncia/edit/1
    *  VIEW: <g:form resource="${tipoDenunciaInstance}" method="PUT">
    *  CONTROLLER:  [tipoDenunciaInstance: tipoDenunciaInstance]
    *
    * Hipotesis: edit confirma si el objeto existe, luego delega la
    * tarea de actualizar el objeto al metodo update */
    def edit(Long id) {
        def tipoDenunciaInstance = tipoDenunciaService.getById(id.toInteger())

        if(tipoDenunciaInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [tipoDenunciaInstance: tipoDenunciaInstance]
    }

    def update() {
       // def tipoDenunciaB = tipoDenunciaService.getById(id.toInteger())
        def tipoDenunciaB = new TipoDenunciaB(params)
        def tipoDenunciaBUpdated = tipoDenunciaService.update(tipoDenunciaB, tipoDenunciaB.getId())
        redirect(action: "show", id: tipoDenunciaBUpdated.getId())
    }

    // que hace g:link
    // como paso el bean a update?
    // porque solo funciona editar sobre un objeto recien creado? ( parece que
    // acceder directamente desde el url no anda, solo haciendo click en botones)

    def delete(Long id) {

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
