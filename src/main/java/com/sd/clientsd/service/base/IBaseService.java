package com.sd.clientsd.service.base;

import com.protectionapp.sd2021.dto.base.BaseDTO;
import com.sd.clientsd.beans.base.BaseBean;

import java.text.ParseException;
import java.util.List;

/* Beans son objetos que creamos nosotros */
public interface IBaseService <BEAN extends BaseBean, DTO extends BaseDTO>{
    public BEAN save(BEAN bean) throws ParseException;
    public List<BEAN> getAll(Integer page);
    public BEAN getById(Integer id) throws ParseException;
    public BEAN update(BEAN bean, Integer id) throws ParseException;
    public BEAN delete(Integer id) throws ParseException;
}
