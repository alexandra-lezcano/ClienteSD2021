package com.sd.clientsd.beans.CasosDerivados;

import com.sd.clientsd.beans.base.BaseBean;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.Map;

public class DepEstadoB extends BaseBean {
    String nombre;
    String descripcion;

    public DepEstadoB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setNombre(params.get("nombre"));
        setDescripcion(params.get("description"));


    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
