package com.sd.clientsd.beans.CasosDerivados;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Date;
import java.util.Map;

public class CasoDerivadoB extends BaseBean {
    private static final long serialVersionUID = 1L;
    Date date;
    String description;
    Integer trabajador_social_id;
    public CasoDerivadoB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {

    }
}
