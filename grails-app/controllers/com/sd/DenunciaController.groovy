package com.sd
import com.sd.clientsd.beans.denuncia.DenunciaB
import com.sd.clientsd.service.denuncia.IDenunciaService
import com.sd.clientsd.service.denuncia.ISujetoService
import com.sd.clientsd.service.denuncia.ITipoDenunciaService
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.service.location.INeighborhoodService
import static org.springframework.http.HttpStatus.*

class DenunciaController {

    IDenunciaService denunciaService
    ICityService cityService
    INeighborhoodService neighborhoodService;
    ISujetoService sujetoService;
    ITipoDenunciaService tipoDenunciaService;

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def list(Integer max){
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def denuncias = denunciaService.getAll(page)
        [denunciaInstanceList: denuncias, denunciasTotal: denuncias.size()]
    }

    def create() {
        def cities = cityService.getAllNotPaged()
        def city_id = 1;
        def barrios = neighborhoodService.getAllByCity(city_id)
        def sujetos = sujetoService.newList();
        def tipos = tipoDenunciaService.getAllNotPaged();
        [denunciaInstance        : new Denuncia(params), cityInstanceList: cities,
         sujetoInstance          : new Sujeto(params), sujetoInstanceList: sujetos,
         neighborhoodInstanceList: barrios, city_id: city_id,
         tipoDenunciaInstanceList: tipos]
    }

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

    def edit(Long id) {
        def denunciaInstance = denunciaService.getById(id.toInteger())

        if (denunciaInstance==null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [denunciaInstance: denunciaInstance]
    }

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
