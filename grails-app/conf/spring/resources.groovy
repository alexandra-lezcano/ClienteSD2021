import com.sd.SujetoService
import com.sd.clientsd.rest.denuncia.SujetoResourceImpl
import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.rest.denuncia.TipoSujetoResourceImpl
import com.sd.clientsd.service.denuncia.ISujetoService
import com.sd.clientsd.service.denuncia.SujetoServiceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
import com.sd.clientsd.service.denuncia.TipoSujetoServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    tipoDenunciaResource(TipoDenunciaResourceImpl)
    tipoSujetoResource(TipoSujetoResourceImpl)
    sujetoResource(SujetoResourceImpl)

    //services
    tipoDenunciaService(TipoDenunciaServiceImpl)
    tipoSujetoService(TipoSujetoServiceImpl)
    sujetoService(SujetoServiceImpl)
}
