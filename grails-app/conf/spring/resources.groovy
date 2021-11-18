import com.protectionapp.sd2021.dto.casosDerivados.DepEstadoResult
import com.sd.DepEstadoService
import com.sd.clientsd.rest.CasosDerivados.DepEstadoResourceImpl
import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.service.casosDerivados.DepEstadoServiceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    depEstadoResource(DepEstadoResourceImpl)
    tipoDenunciaResource(TipoDenunciaResourceImpl)

    //services
    depEstadoService(DepEstadoServiceImpl)
    tipoDenunciaService(TipoDenunciaServiceImpl)
}
