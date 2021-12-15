package com.sd.clientsd.service.user;

import com.protectionapp.sd2021.dto.user.UserDTO;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.service.base.IBaseService;

public interface IUserService extends IBaseService<UserB, UserDTO> {

    public UserB getUserByName(String username);
}
