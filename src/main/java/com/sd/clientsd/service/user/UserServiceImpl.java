package com.sd.clientsd.service.user;

import com.protectionapp.sd2021.dto.user.UserDTO;
import com.protectionapp.sd2021.dto.user.UserResult;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.rest.user.IUserResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements IUserService {
   @Autowired
   private IUserResource userResource;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected UserDTO convertToDTO(UserB bean) {
        final UserDTO dto = new UserDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setName(bean.getName());
        dto.setSurname(bean.getSurname());
        dto.setUsername(bean.getUsername());
        dto.setCn(bean.getCn());
        dto.setAddress(bean.getAddress());
        dto.setEmail(bean.getEmail());
        dto.setPhone(bean.getPhone());
//        dto.setCityId(bean.getCityId());

        return dto;
    }

    @Override
    protected UserB convertToBean(UserDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("surname", dto.getSurname());
        params.put("username", dto.getUsername());
        params.put("cn", String.valueOf(dto.getCn()));
        params.put("address", dto.getAddress());
        params.put("email", dto.getEmail());
        params.put("phone", String.valueOf(dto.getPhone()));
     //  params.put("cityId", String.valueOf(dto.getCityId()));

        final UserB bean = new UserB(params);
        return bean;
    }

    @Override
    public UserB save(UserB bean) {
        final UserDTO dto = convertToDTO(bean);
        final UserDTO userDTO = userResource.save(dto);
        final UserB userB = convertToBean(userDTO);

        return userB;
    }

    @Override
    public List<UserB> getAll(Integer page) {
        final UserResult userResult = userResource.getByPage(page);
        List<UserDTO> userDTOS = new ArrayList<>();
        if(userResult.getUsers()!=null) userDTOS = userResult.getUsers();

        final List<UserB> beansList = new ArrayList<>();
        userDTOS.forEach(userDTO -> beansList.add(convertToBean(userDTO)));

        return beansList;
    }

    @Override
    public UserB getById(Integer id) {
        logger.info("Obtener usuario "+id);
        final UserDTO dto = userResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    public UserB update(UserB bean, Integer id) {
        logger.info("Actualizar usuario "+id);
        final UserDTO dto = convertToDTO(bean);
        final UserDTO updatedDto = userResource.update(dto, id);
        return convertToBean(dto);
    }

    @Override
    public UserB delete(Integer id) {
        logger.info("Eliminar usuario "+id);
        final UserDTO deleted = userResource.delete(id);
        return convertToBean(deleted);
    }
}
