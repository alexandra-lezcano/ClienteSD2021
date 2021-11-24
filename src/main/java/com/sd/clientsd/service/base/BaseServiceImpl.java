package com.sd.clientsd.service.base;

import com.protectionapp.sd2021.dto.base.BaseDTO;
import com.sd.clientsd.beans.base.BaseBean;

import java.text.ParseException;

/* Los servicios procesan DTOs recibidos del API (atraves de nuestros BaseResource) para
* poder ser mostrados en la UI (la capa de controllers y vistas de grails)
* Los domains creados por Grails son lo mismo que nuestros Beans programados? */
public abstract class BaseServiceImpl <BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN,DTO>{

    public BaseServiceImpl(){}
    protected abstract DTO convertToDTO(BEAN bean);
    protected abstract BEAN convertToBean(DTO dto) ;
}
