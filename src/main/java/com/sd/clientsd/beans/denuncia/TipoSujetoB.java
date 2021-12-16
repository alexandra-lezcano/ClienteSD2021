package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class TipoSujetoB extends BaseBean {
    private static final long serilVersionUID = 1L;
    private String titulo;

    public TipoSujetoB(Map<String, String> params ){super(params);}
    public TipoSujetoB(String titulo) {this.titulo = titulo;}


    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id")&& params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        } else{
            setId(0);
        }
        setTitulo(params.get("titulo"));
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
}
