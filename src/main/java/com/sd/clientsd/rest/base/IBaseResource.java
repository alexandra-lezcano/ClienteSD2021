package com.sd.clientsd.rest.base;
import com.protectionapp.sd2021.dto.base.BaseDTO;
import com.protectionapp.sd2021.dto.base.BaseResult;
import org.springframework.data.domain.Pageable;

/*
* Punto de entrada de comunicacion con nuestra API, los resource son los encargados
* de hacer llamadas a cada uno de nuestros endpoints. Tiene los mismos metodos de
* IBaseService !
* */
public interface IBaseResource <DTO extends BaseDTO, R extends BaseResult>{

    public DTO save(DTO dto);
    public DTO getById(Integer id);
    public DTO update(DTO dto, Integer id);
    public DTO delete(Integer id);
    public R getAll(Pageable pageable);

}
