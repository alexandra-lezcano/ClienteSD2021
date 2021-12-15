package com.sd.clientsd.rest.login;


import com.sd.clientsd.beans.user.RoleB;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.service.user.IUserService;
import grails.plugin.springsecurity.userdetails.GrailsUser;
import io.micronaut.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
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
            System.out.println(password);
            System.out.println(user);
        if(passwordEncoder.matches(password,user.getPassword())){
            System.out.println(password);

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


    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);

    }


    private List<GrantedAuthority> getUserRoles(UserB user) {
       List<GrantedAuthority> list = new ArrayList<>();
       final List<RoleB> roles = user.getRoles();
       if(roles !=null){
           for(RoleB roleB : roles){
               System.out.println("name"+roleB.getName());
               list.add(new SimpleGrantedAuthority(roleB.getDescription()));
           }
       }

       return list;

    }

    private UserB getUser(String username) {

        UserB userB= userService.getUserByName(username);
        return userB;
    }


}