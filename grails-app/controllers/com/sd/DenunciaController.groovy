package com.sd
import com.sd.clientsd.beans.denuncia.DenunciaB
import com.sd.clientsd.service.denuncia.IDenunciaService
import com.sd.clientsd.service.denuncia.ISujetoService
import com.sd.clientsd.service.denuncia.ITipoDenunciaService
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.service.location.INeighborhoodService
import com.sd.clientsd.utils.config.Configurations

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class DenunciaController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();

    IDenunciaService denunciaService
    ICityService cityService
    INeighborhoodService neighborhoodService;
    ISujetoService sujetoService;
    ITipoDenunciaService tipoDenunciaService;

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer max){
        def page = null == params['page'] ? 0 : Integer.valueOf(params['page'])
        def denuncias = denunciaService.getAll(page)
        def prev = page - 1;
        def sig = page -1;
        if(sig <= ELEMS_PAGINATION){sig = -1}
        [denunciaInstanceList: denuncias, denunciasTotal: denuncias.size(), sig: sig, prev: prev]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        def cities = cityService.getAllNotPaged()
        def barrios = neighborhoodService.getAllByCity()
        def sujetos = sujetoService.newList();
        def tipos = tipoDenunciaService.getAllNotPaged();
        def denunciaInstance = new Denuncia(params);
        [denunciaInstance        : denunciaInstance, cityInstanceList: cities,
         sujetoInstance          : new Sujeto(params), sujetoInstanceList: sujetos,
         neighborhoodInstanceList: barrios, tipoDenunciaInstanceList: tipos]
    }

    def updateNeighborhood(Integer city){
        def barrios = neighborhoodService.getAllByCity(city)
        render (g.select(id:"neighborhoods", name:"neighborhood", from:barrios, optionKey: 'id', optionValue:'name'))
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        def denuncia = new DenunciaB(params)
        def denunciaInstance = denunciaService.save(denuncia)
        if(!denunciaInstance.getId()){
            render(view: "create", model:[denunciaInstance: denunciaInstance])
            return
        }
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'denuncia.label', default:'Denuncia'),denunciaInstance.getId()])
            }
            redirect(action: 'list')
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Long id) {
        def denunciaInstance = denunciaService.getById(id.toInteger())

        if (denunciaInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [denunciaInstance: denunciaInstance]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update(Denuncia denuncia) {
        def denunciaB = new DenunciaB(params)

        if (denunciaB==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        def denunciaBUpdated = denunciaService.update(denunciaB, denunciaB.getId())
        redirect(action: 'list')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])

    def delete(Long id) {
        def denunciaInstance = denunciaService.delete(id.toInteger())

        if (denunciaInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'denuncia.label', default: 'Denuncia'), id])

        redirect(action: 'list')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'denuncia.label', default: 'Denuncia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
