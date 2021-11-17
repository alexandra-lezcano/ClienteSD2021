package com.sd.clientsd.service.denuncia;

import com.protectionapp.sd2021.dto.denuncia.TipoSujetoDTO;
import com.protectionapp.sd2021.dto.denuncia.TipoSujetoResult;
import com.sd.clientsd.beans.denuncia.TipoSujetoB;
import com.sd.clientsd.rest.denuncia.ITipoSujetoResource;
import com.sd.clientsd.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tipoSujetoService")
public class TipoSujetoServiceImpl extends BaseServiceImpl<TipoSujetoB, TipoSujetoDTO> implements ITipoSujetoService{

    @Autowired
    private ITipoSujetoResource _tipoSujetoResource;

    @Override
    protected TipoSujetoDTO convertToDTO(TipoSujetoB bean) {
        final TipoSujetoDTO dto = new TipoSujetoDTO();
        dto.setId(bean.getId());
        dto.setNombre(bean.getName());
        return dto;
    }

    @Override
    protected TipoSujetoB convertToBean(TipoSujetoDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("nombre",String.valueOf(dto.getNombre()));
        final TipoSujetoB tipoSujetoB = new TipoSujetoB(params);
        return tipoSujetoB;
    }

    @Override
    public TipoSujetoB save(TipoSujetoB bean) {
        final TipoSujetoDTO tipo = convertToDTO(bean);
        final TipoSujetoDTO dto = _tipoSujetoResource.save(tipo);
        final TipoSujetoB tipoB = convertToBean(dto);
        return tipoB;
    }

    @Override
    public List<TipoSujetoB> getAll(Integer page) {
       final TipoSujetoResult result = _tipoSujetoResource.getAll();
       final List<TipoSujetoDTO> tipos = null == result.getTipoSujetoList() ? new ArrayList<TipoSujetoDTO>():result.getTipoSujetoList();
       final List<TipoSujetoB> tiposB = new ArrayList<>();
       for (TipoSujetoDTO dto : tipos){
           final TipoSujetoB bean = convertToBean(dto);
           tiposB.add(bean);
       }
       return tiposB;
    }

    @Override
    public TipoSujetoB getById(Integer id) {
        final TipoSujetoDTO dto = _tipoSujetoResource.getById(id);
        final TipoSujetoB bean = convertToBean(dto);
        return bean;
    }
}
