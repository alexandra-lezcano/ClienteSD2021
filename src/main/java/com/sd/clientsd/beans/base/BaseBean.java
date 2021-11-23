package com.sd.clientsd.beans.base;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;

/*
*  Base Bean tiene id y el metodo para que todos sus hijos creen un
*  Hash de parametros. La vista se alimanta y maneja de Beans
* */
public abstract class BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    public BaseBean(Map<String, String> params){
        create(params);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected abstract void create(Map<String,String> params) ;
}
