package com.sd.clientsd.service.login;


import com.sd.clientsd.service.login.IAuthService;
import grails.plugin.springsecurity.userdetails.GrailsUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl  implements IAuthService {
    @Override
    public String getUsername() {

        GrailsUser grailsUser = (GrailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return grailsUser.getUsername();
    }

    @Override
    public String getPassword() {
        GrailsUser grailsUser = (GrailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(grailsUser.getPassword()+"constraseña");
        return grailsUser.getPassword();
    }
}
