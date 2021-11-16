package com.sd.clientsd.rest.base;
import com.protectionapp.sd2021.dto.base.BaseDTO;

/*
* Punto de entrada de comunicacion con nuestra API, los resource son los encargados
* de hacer llamadas a cada uno de nuestros endpoints. Tiene los mismos metodos de
* IBaseService en el API
* */
public interface IBaseResource <DTO extends BaseDTO>{

    public DTO save(DTO dto);
    public DTO getById(Integer id);
    public DTO update(DTO dto, Integer id);
    public DTO delete(Integer id);
}
