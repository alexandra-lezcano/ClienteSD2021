package com.sd
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.service.location.ICityService
import static org.springframework.http.HttpStatus.*

class CityController {

    ICityService cityService

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        redirect(action: 'list', params:params)
    }

    def show(Long id) {
        CityB cityB = cityService.getById(id.toInteger())
        def neighborhoods = cityB.getNeighborhoodBList()
        [cityInstance: cityB, neighborhoodInstanceList: neighborhoods]
    }

    def list(Integer max) {
        def page=null ==params['id'] ? 0 : Integer.valueOf(params['id'])

        def cities = cityService.getAll(page)

        [cityInstanceList: cities, citiesTotal: cities.size()]
    }

    def create() {
        [cityInstance: new City(params)]
    }

    def save() {
        def city = new CityB(params)
        def cityInstance = cityService.save(city)

        if(!cityInstance.getId()){
            render(view: "create", model: [cityInstance: cityInstance])
            return
        }

        // Muestra un mensajito por defecto
        withFormat{
            html{
                flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'Ciudad'), cityInstance.getId()])
            }
        }
        redirect(action: "list")
    }

    def edit(Long id) {
        def cityInstance = cityService.getById(id.toInteger())

        if(cityInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }
        [cityInstance: cityInstance]
    }

    def update(City city) {
        def cityB = new CityB(params)

        if(cityB == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        def cityBUpdated = cityService.update(cityB, cityB.getId())
        redirect(action: 'list')
    }

    def delete(Long id) {
        def cityInstance = cityService.delete(id.toInteger())
        System.out.println("Se borro "+cityInstance.id+" "+cityInstance.titulo)

        if(cityInstance == null){
            render status: NOT_FOUND
            redirect(action: "create")
            return
        }

        flash.message = message(code: 'default.deleted.message',  args: [message(code: 'city.label', default: 'City'), id])

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
