import com.sd.SujetoService
import com.sd.clientsd.rest.CasosDerivados.CasosDerivadosResourceImpl
import com.sd.clientsd.rest.denuncia.SujetoResourceImpl

import com.sd.clientsd.rest.CasosDerivados.DepEstadoResourceImpl
import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.rest.denuncia.TipoSujetoResourceImpl
import com.sd.clientsd.rest.location.NeighborhoodResourceImpl
import com.sd.clientsd.service.denuncia.ISujetoService
import com.sd.clientsd.service.casosDerivados.CasosDerivadosServiceImpl
import com.sd.clientsd.service.denuncia.SujetoServiceImpl
import com.sd.clientsd.rest.location.CityResourceImpl
import com.sd.clientsd.service.casosDerivados.DepEstadoServiceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
import com.sd.clientsd.service.location.INeighborhoodService
import com.sd.clientsd.service.location.NeighborhoodServiceImpl
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import com.sd.clientsd.service.denuncia.TipoSujetoServiceImpl
import com.sd.clientsd.service.location.CityServiceImpl

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    depEstadoResource(DepEstadoResourceImpl)
    tipoDenunciaResource(TipoDenunciaResourceImpl)
    cityResource(CityResourceImpl)
    tipoSujetoResource(TipoSujetoResourceImpl)
    sujetoResource(SujetoResourceImpl)
    neighborhoodResource(NeighborhoodResourceImpl)
    casosDerivadosResource(CasosDerivadosResourceImpl)

    //services
    cityService(CityServiceImpl)
    depEstadoService(DepEstadoServiceImpl)
    casoDerivadoService(CasosDerivadosServiceImpl)
    tipoDenunciaService(TipoDenunciaServiceImpl)
    tipoSujetoService(TipoSujetoServiceImpl)
    sujetoService(SujetoServiceImpl)
    neighborhoodService(NeighborhoodServiceImpl)
  
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('es');
    }

}
