package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoDenunciaDTO;
import com.sd.clientsd.beans.denuncia.TipoDenunciaB;
import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl;
import com.sd.clientsd.service.base.BaseServiceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TipoDenunciaServiceImpl extends BaseServiceImpl<TipoDenunciaB, TipoDenunciaDTO> implements ITipoDenunciaService {
    //resoruces
    private TipoDenunciaResourceImpl tipoDenunciaResource;

    @Override
    protected TipoDenunciaDTO convertToDTO(TipoDenunciaB bean) {
        final TipoDenunciaDTO dto = new TipoDenunciaDTO();
        dto.setId(bean.getId());
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
    public List<TipoDenunciaB> getAll(Integer page) {
        return null;
    }

    @Override
    public TipoDenunciaB getById(Integer id) {
        return null;
    }
}
