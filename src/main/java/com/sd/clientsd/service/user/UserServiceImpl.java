package com.sd.clientsd.service.user;

import com.protectionapp.sd2021.dto.user.UserDTO;
import com.protectionapp.sd2021.dto.user.UserResult;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.rest.location.ICityResource;
import com.sd.clientsd.rest.user.IUserResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.service.location.ICityService;
import com.sd.clientsd.service.location.INeighborhoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements IUserService {
   @Autowired
   private IUserResource userResource;

   @Autowired
   private ICityService cityService;

   @Autowired
   private INeighborhoodService neighborhoodService;

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
        if(bean.getCity()!=null) dto.setCityId(bean.getCity().getId());
        if(bean.getNeighborhoods()!=null){
            final Set<Integer> neighborhoodIds = new HashSet<>();
            bean.getNeighborhoods().forEach(neighborhoodB -> neighborhoodIds.add(neighborhoodB.getId()));
            dto.setNeighborhoodIds(neighborhoodIds);
        }

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

        final UserB bean = new UserB(params);

        if(dto.getCityId()!=null) bean.setCity(cityService.getById(dto.getCityId()));
        if(dto.getNeighborhoodIds()!=null){
            final List<NeighborhoodB> neighborhoodBList = new ArrayList<>();
            dto.getNeighborhoodIds().forEach(neighborhoodId -> neighborhoodBList.add(neighborhoodService.getById(neighborhoodId)));
            bean.setNeighborhoods(neighborhoodBList);
        }

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
        logger.info("Test GETALL - ");
        final UserResult userResult = userResource.getByPage(page);
        List<UserDTO> userDTOS = new ArrayList<>();
        if(userResult.getUsers()!=null) userDTOS = userResult.getUsers();

        final List<UserB> beansList = new ArrayList<>();
        userDTOS.forEach(userDTO -> beansList.add(convertToBean(userDTO)));
        logger.info("USUER LIST - 0 "+beansList.get(0).getName());
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
