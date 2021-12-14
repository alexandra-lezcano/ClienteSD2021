package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB;
import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.beans.user.UserB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class DenunciaB extends BaseBean{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String descripcion;
    private Date fecha;
    private DenunciaEstadoB estado;
    private CasoDerivadoB caso;
    private CityB city;
    private NeighborhoodB neighborhood;
    private UserB user;

    public DenunciaB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        if (params.containsKey("id")&& params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        } else {
            setId(0);
        }
        setCodigo(params.get("codigo"));
        setDescripcion(params.get("descripcion"));
        try {
            setFecha(format.parse(params.get("fecha")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CasoDerivadoB getCaso() {
        return caso;
    }

    public void setCaso(CasoDerivadoB caso) {
        this.caso = caso;
    }

    public DenunciaEstadoB getEstado() {
        return estado;
    }

    public void setEstado(DenunciaEstadoB estado) {
        this.estado = estado;
    }

    public CityB getCity() {
        return city;
    }

    public void setCity(CityB city) {
        this.city = city;
    }

    public NeighborhoodB getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodB neighborhood) {
        this.neighborhood = neighborhood;
    }

    public UserB getUser() {
        return user;
    }

    public void setUser(UserB user) {
        this.user = user;
    }
}
