package com.sd.clientsd.beans.location;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class CityB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String descripcion;

    public CityB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else{
            setId(0);
        }
        setNombre(params.get("name"));
        setDescripcion(params.get("description"));
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
