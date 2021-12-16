package com.sd.clientsd.service.user;

import com.protectionapp.sd2021.dto.user.RoleDTO;
import com.protectionapp.sd2021.dto.user.UserDTO;
import com.sd.clientsd.beans.user.RoleB;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.rest.user.IRoleResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleB, RoleDTO> implements IRoleService {

    @Qualifier("roleResource")
    @Autowired
    private IRoleResource roleResource;
    @Qualifier("userService")
    @Autowired
    private IUserService userService;
    @Override
    protected RoleDTO convertToDTO(RoleB bean) {
        final RoleDTO dto= new RoleDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());

return dto;
    }

    @Override
    protected RoleB convertToBean(RoleDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("description",dto.getDescription());
        final RoleB bean = new RoleB(params);

        return bean;

    }

    @Override
    public RoleB save(RoleB bean) {
        return null;
    }

    @Override
    public List<RoleB> getAll(Integer page) {
        return null;
    }

    @Override
    public List<RoleB> getAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<RoleB> getAll() {
        return null;
    }

    @Override
    public RoleB getById(Integer id) {
        final RoleDTO dto = roleResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    public RoleB update(RoleB bean, Integer id) {
        return null;
    }

    @Override
    public RoleB delete(Integer id) {
        return null;
    }
}
