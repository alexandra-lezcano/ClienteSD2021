import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl

// Place your Spring DSL code here
beans = {
    //resources
    tipoDenunciaResource(TipoDenunciaResourceImpl)

    //services
    tipoDenunciaService(TipoDenunciaServiceImpl)
}
