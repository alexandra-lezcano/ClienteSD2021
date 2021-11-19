package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class SujetoB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String ci;
    private String telefono;
    private String correo;
    private String direccion;
    private Integer tipo;
   // private Integer denuncia;

    public SujetoB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id")&& params.get("id")!= null){
            setId(Integer.valueOf(params.get("id")));
        } else {setId(0);}
        setCi(params.get("ci"));
        setCorreo(params.get("correo"));
        setDireccion(params.get("direccion"));
        setTipo(Integer.valueOf(params.get("tipo")));
        setTelefono(params.get("telefono"));
        //setDenuncia(Integer.valueOf(params.get("denuncia")));
    }

    //public Integer getDenuncia(){return denuncia;}

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getTipo() {
        return tipo;
    }

   // public void setDenuncia(Integer denuncia){this.denuncia = denuncia;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
