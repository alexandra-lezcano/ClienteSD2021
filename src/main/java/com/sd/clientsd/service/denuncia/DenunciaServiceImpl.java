package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.DenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.DenunciaResult;
import com.protectionapp.sd2021.dto.denuncia.SujetoDto;
import com.sd.clientsd.beans.denuncia.DenunciaB;
import com.sd.clientsd.beans.denuncia.DenunciaEstadoB;
import com.sd.clientsd.beans.denuncia.SujetoB;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.rest.denuncia.IDenunciaResource;
import com.sd.clientsd.rest.denuncia.ISujetoresource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import com.sd.clientsd.service.casosDerivados.ICasosDerivadosService;
import com.sd.clientsd.service.location.ICityService;
import com.sd.clientsd.service.location.INeighborhoodService;
import com.sd.clientsd.service.user.IUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("denunciaService")
public class DenunciaServiceImpl extends BaseServiceImpl<DenunciaB, DenunciaDTO> implements IDenunciaService {

    @Autowired
    private IDenunciaResource denunciaResource;
    @Autowired
    private ICityService cityService;
    @Autowired
    private IDenunciaEstadoService denunciaEstadoService;
    @Autowired
    private INeighborhoodService neighborhoodService;
    @Autowired
    private ITipoSujetoService tipoSujetoService;


    @Override
    protected DenunciaDTO convertToDTO(DenunciaB bean) {
        final DenunciaDTO dto = new DenunciaDTO();
        if(bean.getId()!=0){dto.setId(bean.getId());}
        dto.setDescripcion(bean.getDescripcion());
        dto.setCodigo(bean.getCodigo());
        dto.setFecha(bean.getFecha());
        dto.setCity_id(bean.getCity().getId());
        dto.setNeighborhood_id(bean.getNeighborhood().getId());

        // guarda un estado por defecto
        // tira unauthorized
        /*if(denunciaEstadoService.getById(1)!=null){
            dto.setEstado_id(1);
        }*/

       // dto.setUser_id(bean.getId());

        return dto;
    }

    @Override
    protected DenunciaB convertToBean(DenunciaDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("descripcion", String.valueOf(dto.getDescripcion()));
        params.put("codigo",String.valueOf(dto.getCodigo()));
        params.put("fecha", String.valueOf(dto.getFecha()));
        final DenunciaB bean = new DenunciaB(params);

        final CityB city = cityService.getById(dto.getCity_id());
        final NeighborhoodB neighborhood = neighborhoodService.getById(dto.getNeighborhood_id());
        //final DenunciaEstadoB estado = denunciaEstadoService.getById(dto.getEstado_id());
        //final UserB user = userService.getById(dto.getUser_id());

        bean.setCity(city);
        bean.setNeighborhood(neighborhood);
       // bean.setEstado(estado);
       // bean.setUser(user);

        /*todo hacer lista de sujetos y tipos de denuncia*/

        return bean;
    }

    @Override
    public DenunciaB save(DenunciaB bean) {
        final DenunciaDTO dto= convertToDTO(bean);
        final DenunciaDTO denuncia= denunciaResource.save(dto);

        final DenunciaB denunciaB=convertToBean(denuncia);
        return denunciaB;
    }

    @Override
    public List<DenunciaB> getAll(Integer page) {
        DenunciaResult denunciaResult = denunciaResource.getByPage(page);
        List<DenunciaDTO> dtosList = new ArrayList<DenunciaDTO>();

        if(denunciaResult.getDenuncias()!=null) dtosList = denunciaResult.getDenuncias();
        final List<DenunciaB> beansList = new ArrayList<DenunciaB>();

        dtosList.forEach(denunciaDTO -> beansList.add(convertToBean(denunciaDTO)));
        return beansList;

    }

    @Override
    public List<DenunciaB> getAll(Integer page, Integer size) {
        DenunciaResult denunciaResult = denunciaResource.getByPage(page, size);
        List<DenunciaDTO> dtosList = new ArrayList<DenunciaDTO>();

        if(denunciaResult.getDenuncias()!=null) dtosList = denunciaResult.getDenuncias();
        final List<DenunciaB> beansList = new ArrayList<DenunciaB>();

        dtosList.forEach(denunciaDTO -> beansList.add(convertToBean(denunciaDTO)));
        return beansList;
    }

    @Override
    public List<DenunciaB> getAll() {
        DenunciaResult denunciaResult = denunciaResource.getByPage();
        List<DenunciaDTO> dtosList = new ArrayList<DenunciaDTO>();

        if(denunciaResult.getDenuncias()!=null) dtosList = denunciaResult.getDenuncias();
        final List<DenunciaB> beansList = new ArrayList<DenunciaB>();

        dtosList.forEach(denunciaDTO -> beansList.add(convertToBean(denunciaDTO)));
        return beansList;
    }

    @Override
    public DenunciaB getById(Integer id) {
        final DenunciaDTO dto= denunciaResource.getById(id);
        return convertToBean(dto);
    }

    @Override
    public DenunciaB update(DenunciaB bean, Integer id) {
        final DenunciaDTO dto= convertToDTO(bean);
        final DenunciaDTO nuevo= denunciaResource.update(dto,id);
        return convertToBean(nuevo);
    }


    @Override
    public DenunciaB delete(Integer id) {
        final DenunciaDTO c= denunciaResource.delete(id);
        return convertToBean(c);
    }

    protected SujetoDto convertSujetoToDTO(SujetoB bean) {
        final SujetoDto dto = new SujetoDto();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }
        dto.setNombre(bean.getNombre());
        dto.setTipo_id(bean.getTipo().getId());
        dto.setDireccion(bean.getDireccion());
        dto.setCi(bean.getCi());
        dto.setTelefono(bean.getTelefono());
        dto.setCorreo(bean.getCorreo());
        return dto;
    }

    protected SujetoB convertSujetoToBean(SujetoDto dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("nombre", dto.getNombre());
        params.put("ci", dto.getCi());
        params.put("direccion", dto.getDireccion());
        params.put("telefono",dto.getTelefono());
        params.put("correo", dto.getTelefono());
        final SujetoB bean = new SujetoB(params);
        bean.setTipo(tipoSujetoService.getById(dto.getTipo_id()));
        return bean;
    }
}