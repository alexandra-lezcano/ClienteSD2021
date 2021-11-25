package com.sd

import com.sd.clientsd.beans.user.UserB
import com.sd.clientsd.service.user.IUserService
import static org.springframework.http.HttpStatus.*

class UserController {

    IUserService userService

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
        [userInstance: new User(params)]
    }

    // todo tolerancia a fallos
    // todo - crear usuario con todos los fk de las demas tablas
    // investigar cual es la dif entre respond y redirect
    def save() {
        def userB = new UserB(params);
        userB.setUsername(userB.getEmail())
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

        [userInstance: userInstance]
    }

    // todo - actualizar usuario con todos los fk de las demas tablas
    /* <g:actionSubmit class="save"
                       value="${message(code: 'default.button.update.label')}"
                       action="update"/>

    Note to self: la accion debe dirigirme a este metodo, value uso solo para
    mostrar el boton en es */
    def update() {
        def userInstance = new UserB(params);

        if (userInstance == null) {
            render status: NOT_FOUND
            redirect(action: "list")
            return
        }

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
