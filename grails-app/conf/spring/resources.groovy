import com.sd.clientsd.rest.denuncia.TipoDenunciaResourceImpl
import com.sd.clientsd.service.denuncia.TipoDenunciaServiceImpl
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// Place your Spring DSL code here
//resources.groovy contains spring bean definitions
beans = {
    //resources
    tipoDenunciaResource(TipoDenunciaResourceImpl)

    //services
    tipoDenunciaService(TipoDenunciaServiceImpl)

    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('es');
    }
}
