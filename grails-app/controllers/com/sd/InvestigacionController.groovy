package com.sd

import com.sd.clientsd.beans.investigacion.InvestigacionB
import com.sd.clientsd.beans.location.NeighborhoodB
import com.sd.clientsd.service.denuncia.IDenunciaService
import com.sd.clientsd.service.investigacion.IInvestigacionService
import com.sd.clientsd.utils.config.Configurations
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvestigacionController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();
    IInvestigacionService investigacionService
    IDenunciaService denunciaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer max) {
        def page= null == params['page'] ? 0 : Integer.valueOf(params['page'])
        def investigaciones = investigacionService.getAll(page);
        def prev = page - 1
        def sig = page + 1
        if(investigaciones.size() < ELEMS_PAGINATION) {sig = -1}
        [investigacionesInstanceList: investigaciones, investigacionesTotal: investigaciones.size(),
         prev: prev, sig: sig]
    }


    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def create() {
        [investigacionInstance: new Investigacion(params)]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def save() {
        def investigacion = new InvestigacionB(params)
        investigacion.setDenuncia_id(denunciaService.getById(Integer.parseInt(params['denuncia_id'])))

        def investigacionInstance = investigacionService.save(investigacion)
        if(!investigacionInstance.getId()){
            render(view:'create', model:[investigacionInstance: investigacionInstance])
            return
        }

        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'investigacion.label', default: 'Investigacion'), investigacionInstance.getId()])
            }
        }
        redirect(action: "list")
    }

    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def edit(Long id) {
        def investigacionInstance = investigacionService.getById(id.toInteger())

        if(investigacionInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        [investigacionInstance: investigacionInstance]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def update(Investigacion investigacion) {
        def investigacionB = new InvestigacionB(params)

        if(investigacionB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        investigacionB.setDenuncia_id(investigacionService.getById(Integer.parseInt(params['investigacion_id'])))

        def investigacionBUpdated = investigacionService.update(investigacionB, investigacionB.getId())
        redirect(action: 'list')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_TSOCIAL', 'ROLE_USER'])
    def delete(Long id) {
        def investigacionInstance = investigacionService.delete(id.toInteger())


        if(investigacionInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'investigacion.label', default: 'Investigacion'), id])

        redirect(action: 'list')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'investigacion.label', default: 'Investigacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
