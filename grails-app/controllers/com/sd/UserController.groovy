package com.sd

import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.beans.user.UserB
import com.sd.clientsd.service.location.ICityService
import com.sd.clientsd.service.user.IUserService
import static org.springframework.http.HttpStatus.*

class UserController {

    IUserService userService
    ICityService cityService

    static allowedMethods = [save: "POST", update: "PUT"]

    // tiene que estar vacio el metodo
    def index() {
       //params.max = Math.min(max ?: 10, 100)
        //respond userService.list(params), model:[userCount: userService.count()]
        redirect(action: 'list', params:params)
    }

    def list(Integer max){
        def page=null ==params['id'] ? 0 : Integer.valueOf(params['id'])
        def users = userService.getAll(page)
        [userInstanceList: users, usersTotal: users.size()]
    }

    def show(Long id) {
        //respond userService.get(id)
        UserB userB = userService.getById(id.toInteger())
        [userInstance: userB]
    }

    /*Alex: hasta ahora no entiendo si esto es necesario o no, siempre muestro
    * lo que esta en mi vista con los beans que yo cree */
    def create() {
        def cities = cityService.getAllNotPaged();
        [userInstance: new User(), cityInstanceList: cities]
       // [userInstance: new User(params), cityInstanceList: cities]
        // come back here,how do I use the create method with BEANS instead of DOMAINS
        // how to use tags / g select or something that lets me render a template of neighList from City controller?
        // can i easily bring the city object  after the selection with its attributes
        // en el getall ya tengo una lista de beans city, ahora necesito acceder a los
        // atributos de ese city
    }

    // todo tolerancia a fallos
    // todo - crear usuario con todos los fk de las demas tablas
    // investigar cual es la dif entre respond y redirect
    def save() {
        def userB = new UserB(params);
        userB.setUsername(userB.getEmail())

        CityB city = cityService.getById(Integer.valueOf(params.get("cityId")));
        userB.setCity(city)

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

    // todo - actualizar usuario con todos los fk de las demas tablas
    /* <g:actionSubmit class="save"
                       value="${message(code: 'default.button.update.label')}"
                       action="update"/>

    Note to self: la accion debe dirigirme a este metodo, value uso solo para
    mostrar el boton en es */
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

        def userBUpdated = userService.update(userInstance, userInstance.getId())
        System.out.println("Se actualizo user con id -- "+userInstance.getId());
        redirect(action: 'list')
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        def userInstance = userService.delete(id.toInteger())
        System.out.println("Se borro user con id -- "+userInstance.getId());
        redirect(action: 'list')
    }

    def findNeighborhoodsByCity() {
        System.out.println("params desde findNeigh -> "+ params)
        System.out.println("params desde findNeigh -> "+ params.get("cityId"))

        def city = cityService.getById(Integer.valueOf(params.get("cityId")));
        def neighborhoodInstanceList = city.getNeighborhoodBList();
        render(template: 'neighborhoodsSelection', collection: neighborhoodInstanceList)
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
