package com.sd.clientsd.beans.investigacion;

import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.beans.denuncia.DenunciaB;

import java.util.Map;

public class InvestigacionB  extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String descripcion;
    private String fecha_fin;
    private String fecha_inicio;
    private DenunciaB denuncia_id;

    public InvestigacionB() {}

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!= null){
            setId(Integer.valueOf(params.get("id")));
        } else {setId(0);}
        setDescripcion(params.get("descripcion"));
        setFecha_fin(params.get("fecha_fin"));
        setFecha_inicio(params.get("fecha_inicio"));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public DenunciaB getDenuncia_id() {
        return denuncia_id;
    }

    public void setDenuncia_id(DenunciaB denuncia_id) {
        this.denuncia_id = denuncia_id;
    }
}

