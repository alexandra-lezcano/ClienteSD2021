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
        UserResult userResult = new UserResult();

        if(getWebResource()!=null){
            Class<UserResult> userResultClass = UserResult.class;
            String path = "/page/"+pageNum;
            userResult = getWebResource().path(path).get(userResultClass);
        }

        return userResult;
    }

    @Override
    public UserResult getByPage(Integer page, Integer size) {
        UserResult userResult = new UserResult();

        if(getWebResource()!=null){
            Class<UserResult> userResultClass = UserResult.class;
            String path = "/page/"+page+"/"+size;
            userResult = getWebResource().path(path).get(userResultClass);
        }

        return userResult;
    }

    @Override
    public UserResult getByPage() {
        UserResult userResult = new UserResult();

        if(getWebResource()!=null){
            Class<UserResult> userResultClass = UserResult.class;
            String path = "/page/";
            userResult = getWebResource().path(path).get(userResultClass);
        }

        return userResult;
    }
}
