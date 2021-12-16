package com.sd.clientsd.rest.CasosDerivados;


import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosDTO;
import com.protectionapp.sd2021.dto.casosDerivados.CasosDerivadosResult;
import com.sd.clientsd.beans.denuncia.DenunciaB;
import com.sd.clientsd.beans.user.UserB;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.rest.login.MyAuthenticationProvider;
import com.sd.clientsd.service.login.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="casosDerivadosResource")
public class CasosDerivadosResourceImpl  extends BaseResourceImpl<CasosDerivadosDTO> implements ICasosDerivadosResource {
    public CasosDerivadosResourceImpl() {
        super(CasosDerivadosDTO.class, "/casosDerivados");
    }

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    IAuthService authService;
    @Override
    public CasosDerivadosResult getAll() {
        setWebResourceBasicAuthFilter();
        return getWebResource().get(CasosDerivadosResult.class);
    }

    @Override
    public CasosDerivadosResult getByPage(Integer pageNum) {
        setWebResourceBasicAuthFilter();
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/"+pageNum;
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

    @Override
    public CasosDerivadosResult getByPage(Integer page, Integer size) {
        setWebResourceBasicAuthFilter();
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/"+page+"/"+size;
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

   @Override
    public CasosDerivadosResult getByPageUser(Integer page, Integer id) {
        setWebResourceBasicAuthFilter();
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/user/"+page+"/"+id;
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

    @Override
    public CasosDerivadosResult getByPage() {
        setWebResourceBasicAuthFilter();
        CasosDerivadosResult casosDerivadosResult = new CasosDerivadosResult();
        if(getWebResource()!=null){
            Class<CasosDerivadosResult> casosDerivadosResultClass = CasosDerivadosResult.class;
            String path = "/page/";
            casosDerivadosResult = getWebResource().path(path).get(casosDerivadosResultClass);
        }
        return casosDerivadosResult;
    }

    @Override
    public CasosDerivadosDTO save(CasosDerivadosDTO  dto){
        setWebResourceBasicAuthFilter();
        //return getWebResource().entity(dto).post(getDtoClass()); // tira error, pide que haga cast a DTO

        UserB user= myAuthenticationProvider.getUser(authService.getUsername());

        CasosDerivadosDTO nuevo =   getWebResource().entity(dto).post(CasosDerivadosDTO.class);

        nuevo.setUser(user.getId());
        update(nuevo,getWebResource().entity(dto).post(CasosDerivadosDTO.class).getId());
        return getWebResource().entity(dto).post(CasosDerivadosDTO.class);

    }




}

