package com.sd.clientsd.rest.investigacion;

import com.protectionapp.sd2021.dto.investigacion.InvestigacionDTO;
import com.protectionapp.sd2021.dto.investigacion.InvestigacionResult;
import com.sd.clientsd.rest.base.BaseResourceImpl;
import com.sd.clientsd.utils.config.Configurations;
import org.springframework.stereotype.Repository;

@Repository(value="investigacionResource")
public class InvestigacionResourceImpl extends BaseResourceImpl<InvestigacionDTO> implements IInvestigacionResource {

    private static final String RESOURCE_PATH = Configurations.getInvestigacionResource();

    public InvestigacionResourceImpl() {
        super(InvestigacionDTO.class, RESOURCE_PATH);
    }

    @Override
    public InvestigacionResult getAll(){return getWebResource().get(InvestigacionResult.class);}

    @Override
    public InvestigacionResult getByPage(Integer pageNum){
        InvestigacionResult iResult = new InvestigacionResult();
        if(getWebResource()!=null){
            Class<InvestigacionResult> iResultClass = InvestigacionResult.class;
            String path = "/page/"+pageNum;
            iResult = getWebResource().path(path).get(iResultClass);
        }
        return iResult;
    }



}
