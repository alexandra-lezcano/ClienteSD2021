package com.sd

import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.beans.user.UserB
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.service.location.INeighborhoodService
import com.sd.clientsd.service.user.IUserService
import com.sd.clientsd.utils.config.Configurations
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class UserController {
    private static final Integer ELEMS_PAGINATION = Configurations.getElemsPagination();

    IUserService userService
    ICityService cityService
    INeighborhoodService neighborhoodService

    static allowedMethods = [save: "POST", update: "PUT"]

    // tiene que estar vacio el metodo


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() {
       //params.max = Math.min(max ?: 10, 100)
        //respond userService.list(params), model:[userCount: userService.count()]
        redirect(action: 'list', params:params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list(Integer id){
        def page=null ==params['page'] ? 0 : Integer.valueOf(params['page'])
        def users = userService.getAll(page)
        def prev = page -1;
        def sig = page +1;
        if(users.size() < ELEMS_PAGINATION){sig = -1}
        [userInstanceList: users, usersTotal: users.size(), prev: prev, sig: sig]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        def userB = userService.getById(id.toInteger())
        def neighborhoods = userB.getNeighborhoods()
        [userInstance: userB, neighborhoodInstanceList: neighborhoods]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        def cities = cityService.getAllNotPaged();
        [userInstance: new Users(), cityInstanceList: cities]
    }

    // todo tolerancia a fallos

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        def userB = new UserB(params);
        userB.setUsername(userB.getEmail())

        CityB city = cityService.getById(Integer.valueOf(params.get("cityId")));
        userB.setCity(city)
        userB.setNeighborhoods(city.getNeighborhoodBList())

        def user = userService.save(userB)

        if (!user.getId()) {
            respond notFound(), view: 'create'
            return
        }

        // creo que no hace falta redireccionar a ningun lado :p
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'Usuario'), user.getId()])
            }
        }

        redirect(action: "list")
    }

    // todo tolerancia a fallos
    /*IMPORTANTE - el g:form debe ser BEAN no RESOURCE porque sino te redirecciona mal
    * <g:form bean="${userInstance}" method="PUT"> */

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Long id) {
        def userInstance = userService.getById(id.toInteger())

        if (userInstance == null) {
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def cities = cityService.getAllNotPaged()

        [userInstance: userInstance, cityInstanceList: cities]
    }

    /* <g:actionSubmit class="save"
                       value="${message(code: 'default.button.update.label')}"
                       action="update"/>

    Note to self: la accion debe dirigirme a este metodo, value uso solo para
    mostrar el boton en es */

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update() {
        def userInstance = new UserB(params);
        System.out.println(params)
        if (userInstance == null) {
            render status: NOT_FOUND
            redirect(action: "list")
            return
        }

        CityB city = cityService.getById(Integer.valueOf(params.get("cityId")));
        userInstance.setCity(city)
        userInstance.setNeighborhoods(city.getNeighborhoodBList())

        def userBUpdated = userService.update(userInstance, userInstance.getId())
        System.out.println("Se actualizo user con id -- "+userInstance.getId());
        redirect(action: 'list')
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        def userInstance = userService.delete(id.toInteger())
        System.out.println("Se borro user con id -- "+userInstance.getId());
        redirect(action: 'list')
    }

    // intento fallido de mostrar el g select para que un usuario pueda elegir en cuantos barrios de su ciudad trabaja
    def findNeighborhoodsByCity() {
        System.out.println("params desde findNeigh -> "+ params)
        System.out.println("params desde findNeigh -> "+ params.get("cityId"))

        def city = cityService.getById(Integer.valueOf(params.get("cityId")));
        def neighborhoodInstanceList = city.getNeighborhoodBList();

       String contenido = g.render(template: 'neighborhoodsSelection', bean: [userInstance: neighborhoodInstanceList])
       //render (template: 'neighborhoodsSelection', var: neighborhoodInstanceList) // intentar con var en el futuro
       //render { div(id: "myDiv", "some text inside the div") }
        render contenido
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
