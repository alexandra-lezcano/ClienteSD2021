import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    tipoDenunciaResource(TipoDenunciaResourceImpl)

    //services
    tipoDenunciaService(TipoDenunciaServiceImpl)
}
