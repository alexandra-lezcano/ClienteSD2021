package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class TipoDenunciaB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String descripcion;
    // private Set<DenunciaB> denuncias;

    public TipoDenunciaB(Map<String, String> params) {
        super(params);
    }
    /* Inicializar los parametros del Bean */
    @Override
    protected void create(Map<String, String> params) {
        if(!params.get("id").isEmpty() && params.get("id") !=null){
            setId(Integer.valueOf(params.get("id")));
        }
        setTitulo(params.get("titulo"));
        setDescripcion(params.get("desripcion"));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
