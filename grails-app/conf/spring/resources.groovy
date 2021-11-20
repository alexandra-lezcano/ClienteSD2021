import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult
import com.sd.DepEstadoService
import com.sd.clientsd.rest.CasosDerivados.DepEstadoResourceImpl
import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.rest.location.CityResourceImpl
import com.sd.clientsd.service.casosDerivados.DepEstadoServiceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
import com.sd.clientsd.service.location.CityServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    depEstadoResource(DepEstadoResourceImpl)
    tipoDenunciaResource(TipoDenunciaResourceImpl)
    cityResource(CityResourceImpl)

    //services
    cityService(CityServiceImpl)
    depEstadoService(DepEstadoServiceImpl)
    tipoDenunciaService(TipoDenunciaServiceImpl)
}
