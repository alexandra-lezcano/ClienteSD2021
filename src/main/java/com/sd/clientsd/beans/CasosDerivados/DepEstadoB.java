package com.sd.clientsd.beans.CasosDerivados;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class DepEstadoB extends BaseBean {

String nombre;
String descripcion;
    public DepEstadoB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else{
            setId(0);
        }
        setNombre(params.get("nombre"));
        setDescripcion(params.get("descripcion"));
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
