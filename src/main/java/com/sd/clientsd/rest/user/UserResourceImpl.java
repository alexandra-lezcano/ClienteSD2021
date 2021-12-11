package com.sd.clientsd.rest.user;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.protectionapp.sd2021.dto.user.UserDTO;
import com.protectionapp.sd2021.dto.user.UserResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value = "userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource {
   // private static final String RESOURCE_PATH = Configurations.getUserResource();

    public UserResourceImpl() {
        super(UserDTO.class, "/users");
    }

    @Override
    public UserResult getByPage(Integer pageNum) {
        String path = "/page/"+pageNum;
        return getWebResource().path(path).get(UserResult.class);
    }
}
