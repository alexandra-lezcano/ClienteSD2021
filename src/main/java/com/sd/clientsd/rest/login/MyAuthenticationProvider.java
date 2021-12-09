package com.sd.clientsd.rest.login;


import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.service.user.IUserService;
import grails.plugin.springsecurity.userdetails.GrailsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class MyAuthenticationProvider implements AuthenticationProvider {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
String username = String.valueOf(auth.getPrincipal());
String password = String.valueOf(auth.getCredentials());

UserB user = getUser(username);

if(user != null){
 if(passwordEncoder.matches(password,user.getPassword())){
     List<GrantedAuthority> authorities = getUserRoles(user);
     if(authorities !=null){
         GrailsUser userDetails = new GrailsUser(username,password,true,true,true,true,authorities,user.getId());
         UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
         token.setDetails(authentication.getDetails());
         return token;
     }else{
         throw new BadCredentialsException("El usuario no tiene ningun rol");
     }
 }else{
         throw new BadCredentialsException("Contraseña incorrecta");
     }

 }
return auth;
}



    private List<GrantedAuthority> getUserRoles(UserB user) {
       return null;
    }

    private UserB getUser(String username) {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}