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

    def index() {
        redirect(action: 'list', params:params)
    }

    // todo arreglar la paginacion!
    def list(Integer max) {
        def page=null ==params['id'] ? 1 : Integer.valueOf(params['id'])

        def tipoDenunicas = tipoDenunciaService.getAll(page)

        [tipoDenunciaInstanceList: tipoDenunicas, tipoDenunciasTotal: tipoDenunicas.size()]
    }

    // EL SHOW NO ES NECESARIO SEGUN ALDO
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
        // envia un map a create.gsp
        [tipoDenunciaInstance: new TipoDenuncia(params)]
    }

    def save() {
        def tipoDenuncia = new TipoDenunciaB(params)
        def tipoDenunciaInstance = tipoDenunciaService.save(tipoDenuncia)

        if(!tipoDenunciaInstance.getId()){
            render(view: "create", model: [tipoDenunciaInstance: tipoDenunciaInstance])
            return
        }

        // Muestra un mensajito por defecto
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoDenuncia.label', default: 'TipoDenuncia'), tipoDenunciaInstance.getId()])
            }
        }
        redirect(action: "show", id: tipoDenunciaInstance.getId())
    }

    /* URL: /tipoDenuncia/edit/1
    *  Cuando estoy en la lista y hago click en "edit" la accion automaticamente contruye un url
    *  con el id a ser editado.
    *  Llamo al servicio para obtener el id y devuelvo a la vista los campos que quiero editar
    *  usando  [tipoDenunciaInstance: tipoDenunciaInstance]  */
    def edit(Long id) {
        def tipoDenunciaInstance = tipoDenunciaService.getById(id.toInteger())

        if(tipoDenunciaInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        // <g:form bean="${tipoDenunciaInstance}" method="PUT">
        // aca obtuve el objeto desde mi API
        // con esto lo muestro en el form de editar
        [tipoDenunciaInstance: tipoDenunciaInstance]
    }

    // <g:actionSubmit class="save" value="${message(code: 'default.button.update.label', default: 'update')}" />
    // este boton hace que se llame a la accion update en la parte [default: update]
    def update() {
        // estos parametros son los que obtuve por getById(id) desde el metodo edit
        def tipoDenunciaB = new TipoDenunciaB(params)

        if(tipoDenunciaB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def tipoDenunciaBUpdated = tipoDenunciaService.update(tipoDenunciaB, tipoDenunciaB.getId())
        // todo mostrar un pop up diciendo que se actualizo el bean usar flash message
        redirect(action: 'list')
    }

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
