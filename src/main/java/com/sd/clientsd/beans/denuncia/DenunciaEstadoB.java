package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class DenunciaEstadoB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String nombre;

    public DenunciaEstadoB (Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params){
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else {
            setId(0);
        }
        setNombre(params.get("nombre"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
