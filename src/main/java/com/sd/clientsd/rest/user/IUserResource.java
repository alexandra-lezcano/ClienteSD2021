package com.sd.clientsd.rest.user;

import com.protectionapp.sd2021.dto.user.UserDTO;
import com.protectionapp.sd2021.dto.user.UserResult;
import com.sd.clientsd.rest.base.IBaseResource;

public interface IUserResource  extends IBaseResource<UserDTO> {
    public UserResult getByPage(Integer pageNum);
}
