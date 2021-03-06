package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaResult;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.rest.denuncia.ITipoDenunciaResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tipoDenunciaService")
public class TipoDenunciaServiceImpl extends BaseServiceImpl<TipoDenunciaB, TipoDenunciaDTO> implements ITipoDenunciaService {
    @Autowired
    private ITipoDenunciaResource tipoDenunciaResource;

    @Override
    protected TipoDenunciaDTO convertToDTO(TipoDenunciaB bean) {
        final TipoDenunciaDTO dto = new TipoDenunciaDTO();
        if(bean.getId()!=0){
            dto.setId(bean.getId());
        }

        dto.setTitulo(bean.getTitulo());
        dto.setDescripcion(bean.getDescripcion());
        return dto;
    }

    @Override
    protected TipoDenunciaB convertToBean(TipoDenunciaDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(dto.getId()));
        params.put("titulo", dto.getTitulo());
        params.put("descripcion", dto.getDescripcion());

        final TipoDenunciaB bean = new TipoDenunciaB(params);
        return bean;
    }

    /* En este metodo yo voy a recibir un BEAN de la UI->Controller que debe ser enviado
    * por la red a nuestra API en formato de DTO
    *
    * tipoDenunciaResource.save(dto) hace un POST al endopoint /tipoDenuncias
    * que responde un DTO, el cual enviamos de vualta hacia la Controller->UI como BEAN
    * para ser renderizado. */
    @Override
    public TipoDenunciaB save(TipoDenunciaB bean) {
        final TipoDenunciaDTO dto = convertToDTO(bean);
        final TipoDenunciaDTO tipoDenundiaDto  = tipoDenunciaResource.save(dto);
        final TipoDenunciaB tipoDenunciaB = convertToBean(tipoDenundiaDto);
        return tipoDenunciaB;
    }

    @Override
    public List<TipoDenunciaB> getAll(Integer pageNum) {
        TipoDenunciaResult tipoDenunciaResult = tipoDenunciaResource.getByPage(pageNum);
        List<TipoDenunciaDTO> dtosList = new ArrayList<TipoDenunciaDTO>();

        if(tipoDenunciaResult.getTipoDenuncias()!=null) dtosList = tipoDenunciaResult.getTipoDenuncias();

        System.out.println(tipoDenunciaResult.getTipoDenuncias().get(1).getTitulo());

      // final List<TipoDenunciaDTO> dtosList = null == tipoDenunciaResult.getTipoDenunciasList() ? new ArrayList<TipoDenunciaDTO>() : tipoDenunciaResult.getTipoDenunciasList();
        final List<TipoDenunciaB> beansList = new ArrayList<TipoDenunciaB>();

        dtosList.forEach(tipoDenunciaDTO -> beansList.add(convertToBean(tipoDenunciaDTO)));
        return beansList;
    }

    public List<TipoDenunciaB> getAllNotPaged() {
        final TipoDenunciaResult tipoDenunciaResult = new TipoDenunciaResult();
                //tipoDenunciaResource.getAll();
        final List<TipoDenunciaDTO> dtosList = null == tipoDenunciaResult.getTipoDenuncias() ? new ArrayList<TipoDenunciaDTO>() : tipoDenunciaResult.getTipoDenuncias();
        final List<TipoDenunciaB> beansList = new ArrayList<TipoDenunciaB>();

        dtosList.forEach(tipoDenunciaDTO -> beansList.add(convertToBean(tipoDenunciaDTO)));
        return beansList;
    }

    @Override
    public TipoDenunciaB getById(Integer id) {
        final TipoDenunciaDTO tipoDenunciaDTO = tipoDenunciaResource.getById(id);
        return convertToBean(tipoDenunciaDTO);
    }

    @Override
    public TipoDenunciaB update(TipoDenunciaB bean, Integer id) {
        final TipoDenunciaDTO dto = convertToDTO(bean);
        final TipoDenunciaDTO updated = tipoDenunciaResource.update(dto, id);
        return convertToBean(updated);
    }

    @Override
    public TipoDenunciaB delete(Integer id) {
        System.out.println("Hasta aca llegue...id: "+id);
        final TipoDenunciaDTO deleted = tipoDenunciaResource.delete(id);
        System.out.println("Se borro algo?..."+ deleted.getId());
        return convertToBean(deleted);
    }
}
