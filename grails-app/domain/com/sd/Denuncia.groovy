package com.sd

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB
import com.sd.clientsd.beans.denuncia.DenunciaEstadoB
import com.sd.clientsd.beans.location.CityB
import com.sd.clientsd.beans.location.NeighborhoodB
import com.sd.clientsd.beans.user.UserB

class Denuncia {
    String codigo
    String descripcion 
    Date fecha
    CasoDerivadoB caso_derivado
    CityB city
    DenunciaEstadoB denuncia_estado
    NeighborhoodB neighborhood
    UserB user

    static constraints = {
    }
}
