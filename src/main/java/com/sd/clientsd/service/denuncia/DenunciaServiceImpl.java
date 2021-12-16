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
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    private ISujetoService sujetoService;


    @Override
    protected DenunciaDTO convertToDTO(DenunciaB bean) {
        final DenunciaDTO dto = new DenunciaDTO();
        if(bean.getId()!=0){dto.setId(bean.getId());}
        dto.setDescripcion(bean.getDescripcion());
        dto.setCodigo(bean.getCodigo());
        dto.setFecha(bean.getFecha());
        dto.setCity_id(bean.getCity().getId());
        dto.setNeighborhood_id(bean.getNeighborhood().getId());

        System.out.println("[TEST] Convertir bean a DTO--->");

        Set<Integer> sujetoIds = new HashSet<>();
        if(bean.getSujetos()!=null){
            bean.getSujetos().forEach(sujetoB -> sujetoIds.add(sujetoB.getId()));
        }
        dto.setSujeto_ids(sujetoIds);

       /* if(denunciaEstadoService.getById(1)!=null){
            dto.setEstado_id(1);
        }*/
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

        bean.setCity(city);
        bean.setNeighborhood(neighborhood);
       // bean.setEstado(estado);

        /*todo hacer lista de sujetos y tipos de denuncia*/

        System.out.println("[TEST] DENTRO DE CONVERT TO DTO ");
        List<SujetoB> sujetos = new ArrayList<>();
        if(dto.getSujeto_ids()!=null){
            dto.getSujeto_ids().forEach(sujetoId -> sujetos.add(sujetoService.getById(sujetoId)));
        }
        bean.setSujetos(sujetos);

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

    @Override
    public DenunciaB saveCabeceraDetalle(DenunciaB denuncia) {
        List<SujetoB> sujetoBList = denuncia.getSujetos();
        denuncia.setSujetos(null);

        //guardar denuncia primero - obtener primary key
        DenunciaB savedDenuncia = save(denuncia);

        List<SujetoB> savedSujetosB = new ArrayList<>();
        // guardar los detalles segundo - utilizando la denuncia creada
        sujetoBList.forEach(sujetoB -> {
            sujetoB.setDenuncia(savedDenuncia);
            savedSujetosB.add(sujetoService.save(sujetoB));
        });
        System.out.println("[TEST] ID YA EXISTE \n"+savedSujetosB.get(1).toString());
        savedDenuncia.setSujetos(savedSujetosB);

        return savedDenuncia;
    }
}