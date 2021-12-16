package com.sd.clientsd.service.login;


import com.sd.clientsd.service.login.IAuthService;
import grails.plugin.springsecurity.userdetails.GrailsUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl  implements IAuthService {
    @Override
    public String getUsername() {
        if(SecurityContextHolder.getContext().getAuthentication()!= null) {
        GrailsUser grailsUser = (GrailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return grailsUser.getUsername();
}return null;
    }

    @Override
    public String getPassword() {
        if(SecurityContextHolder.getContext().getAuthentication()!= null) {
        GrailsUser grailsUser = (GrailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return grailsUser.getPassword();
    }return null;
}}
