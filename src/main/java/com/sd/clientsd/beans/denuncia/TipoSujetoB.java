package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.Map;

public class TipoSujetoB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String _nombre;

    public TipoSujetoB(Map<String,String> params) {super(params);}

    public String getName(){return _nombre;}

    public void setNombre(String nuevo){this._nombre = nuevo; }

    @Override
    protected void create(Map<String, String> params){
        if(!StringUtils.isBlank(params.get("id"))){
            setId(Integer.valueOf(params.get("id")));
        }
    }

}
