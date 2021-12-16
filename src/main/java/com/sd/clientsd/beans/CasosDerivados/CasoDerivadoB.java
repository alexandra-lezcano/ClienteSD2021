package com.sd.clientsd.beans.CasosDerivados;


import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.beans.user.UserB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class CasoDerivadoB extends BaseBean {
    private static final long serialVersionUID = 1L;


    Date date;
    String description;
    UserB userB;
    Set<DepEstadoB> depEstadoBSet;
    public CasoDerivadoB(Map<String, String> params) {
        super(params);
    }


    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else{
            setId(0);
        }

        setDescription(params.get("description"));

      //  setTrabajador_social_id(Integer.valueOf(params.get("trabajador_social_id")));


    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserB getUserB() {
        return userB;
    }

    public void setUserB(UserB userB) {
        this.userB = userB;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }


    public Set<DepEstadoB> getDepEstadoBSet() {
        return depEstadoBSet;
    }

    public void setDepEstadoBSet(Set<DepEstadoB> depEstadoBSet) {
        this.depEstadoBSet = depEstadoBSet;
    }
}
