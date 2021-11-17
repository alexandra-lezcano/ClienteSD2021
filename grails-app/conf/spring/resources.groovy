import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.rest.denuncia.TipoSujetoResourceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
import com.sd.clientsd.service.denuncia.TipoSujetoServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    tipoDenunciaResource(TipoDenunciaResourceImpl)
    tipoSujetoResource(TipoSujetoResourceImpl)

    //services
    tipoDenunciaService(TipoDenunciaServiceImpl)
    tipoSujetoService(TipoSujetoServiceImpl)

}
