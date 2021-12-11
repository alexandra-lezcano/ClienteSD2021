package com.sd

import com.sd.clientsd.beans.denuncia.DenunciaEstadoB
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.service.denuncia.IDenunciaEstadoService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DenunciaEstadoController {

    IDenunciaEstadoService denunciaEstadoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 0 : Integer.valueOf(params['id'])
        def estados = denunciaEstadoService.getAll(page)
        [denunciaEstadoInstanceList: estados, denunciaEsdatoTotal: estados.size()]
    }

    def create() {
        [denunciaEsdatoInstance: new DenunciaEstado(params)]
    }

    def save() {
        def denunciaEstado = new DenunciaEstadoB(params)
        def denunciaEstadoInstance = denunciaEstadoService.save(denunciaEstado)

        if(!denunciaEsdatoInstance.getId()){
            render(view: "create", model: [denunciaEstadoInstance: denunciaEstadoInstance])
            return
        }

        // Muestra un mensajito por defecto
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'denunciaEstado.label', default: 'DenunciaEstado'), denunciaEsdatoInstance.getId()])
            }
        }
        redirect(action: "list")
    }

    def edit(Long id) {
        def denunciaEstadoInstance = denunciaEstadoService.getById(id.toInteger())

        if(denunciaEstadoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [denunciaEsdadoInstance: denunciaEstadoInstance]
    }

    def update(DenunciaEstado denunciaEstado) {
        def denunciaEstadoB = new DenunciaEstadoB(params)

        if(denunciaEstadoB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def denunciaEstadoBUpdated = denunciaEstadoService.update(denunciaEstadoB, denunciaEstadoB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def denunciaEstadoInstance = denunciaEstadoService.delete(id.toInteger())
        if(denunciaEstadoInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'denunciaEstado.label', default: 'DenunciaEstado'), id])

        redirect(action: 'list')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
