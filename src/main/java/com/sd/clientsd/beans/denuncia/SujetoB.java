package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.service.denuncia.ITipoSujetoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SujetoB extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String ci;
    private String telefono;
    private String correo;
    private String direccion;
    private TipoSujetoB tipo;
    private DenunciaB denuncia;

    public SujetoB(){}
    public SujetoB(TipoSujetoB tipo){this.tipo = tipo;}
    public SujetoB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id")&& params.get("id")!= null){
            setId(Integer.valueOf(params.get("id")));
        } else {setId(0);}
        setCi(params.get("ci"));
        setNombre(params.get("nombre"));
        setCorreo(params.get("correo"));
        setDireccion(params.get("direccion"));
        setTelefono(params.get("telefono"));
    }

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

    public TipoSujetoB getTipo() {
        return tipo;
    }

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

    public void setTipo(TipoSujetoB tipo) {
        this.tipo = tipo;
    }

    public DenunciaB getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(DenunciaB denuncia) {
        this.denuncia = denuncia;
    }

    @Override
    public String toString() {
        return "SujetoB{" +
                "id" + getId() +
                "nombre='" + nombre + '\'' +
                ", ci='" + ci + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipo=" + tipo.getTitulo() +
                '}';
    }
}
