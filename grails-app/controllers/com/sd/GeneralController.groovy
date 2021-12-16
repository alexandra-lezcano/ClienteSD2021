package com.sd

import com.sd.clientsd.beans.user.UserB
import com.sd.clientsd.rest.login.MyAuthenticationProvider
import com.sd.clientsd.service.denuncia.IDenunciaEstadoService
import com.sd.clientsd.service.login.IAuthService
import grails.plugin.springsecurity.annotation.Secured

class GeneralController {

    IAuthService authService
    MyAuthenticationProvider myAuthenticationProvider


    def index() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def header() {

        Boolean auth = myAuthenticationProvider.getUser(authService.getUsername());
        UserB user = myAuthenticationProvider.getUser(authService.getUsername());
Boolean admin = false;
        myAuthenticationProvider.getUser(authService.getUsername()).roles.forEach(
                { r ->
                    if (r.description == 'ROLE_ADMIN') {
admin = true;
                        //System.out.print("soy admin")
                    } else {
                        redirect(action: 'headerTS')
                        //System.out.print("no soy admin")
                    }
                }
        );
render(template:'header',model: [auth:auth,admin:admin])
    }

    @Secured(['ROLE_ADMIN'])
    def Admin() {


    }
}