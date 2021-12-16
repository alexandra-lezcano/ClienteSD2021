package com.sd.clientsd.beans.denuncia;

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB;
import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.beans.location.NeighborhoodB;
import com.sd.clientsd.beans.user.UserB;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class DenunciaB extends BaseBean{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String descripcion;
    private String fecha;
    private DenunciaEstadoB estado;
    private CasoDerivadoB caso;
    private CityB city;
    private NeighborhoodB neighborhood;
    private UserB user;
    private List<SujetoB> sujetos;

    public DenunciaB(){};
    public DenunciaB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params) {
        if (params.containsKey("id")&& params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        } else {
            setId(0);
        }
        setDescripcion(params.get("descripcion"));
        setFecha(); // guarda la fecha de la denuncia realizada
        setCodigo();
        this.sujetos = new ArrayList<>();
    }

    /*To-do: hacer que tipo sujeto y tipo denuncia sean unicamente strings!!!
    * luego implementar el metodo para guardar denuncia*/
    public void saveSujeto(Map<String, String> data){
        SujetoB sujeto = new SujetoB(data);
        sujeto.setTipo(new TipoSujetoB(data.get("tipo")));

        System.out.println(sujeto);
        this.sujetos.add(sujeto);
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        String codigo = RandomStringUtils.random(8, "012345678ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    // fecha de la denuncia realizada
    public void setFecha() {

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

    public List<SujetoB> getSujetos() {
        return sujetos;
    }

    public void setSujetos(List<SujetoB> sujetos) {
        this.sujetos = sujetos;
    }
}
