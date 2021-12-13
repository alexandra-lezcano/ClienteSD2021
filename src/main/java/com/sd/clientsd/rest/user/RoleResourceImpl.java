package com.sd.clientsd.rest.user;

import com.protectionapp.sd2021.dto.user.RoleDTO;
import com.protectionapp.sd2021.dto.user.RoleResult;
import com.protectionapp.sd2021.dto.user.UserDTO;
import com.protectionapp.sd2021.dto.user.UserResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;


@Repository(value = "roleResource")
public class RoleResourceImpl extends BaseResourceImpl<RoleDTO> implements IRoleResource {

        private static final String RESOURCE_PATH = "/role";


    public RoleResourceImpl() {
        super(RoleDTO.class,  RESOURCE_PATH);
    }


    public RoleResult getByPage() {
        RoleResult roleResult = new RoleResult();

        if(getWebResource()!=null){
            Class<RoleResult> roleResultClass = RoleResult.class;
            String path = "/page/";
            roleResult = getWebResource().path(path).get(roleResultClass);
        }

        return roleResult;
    }

}