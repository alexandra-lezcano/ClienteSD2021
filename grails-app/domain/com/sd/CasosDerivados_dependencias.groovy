package com.sd

import com.sd.clientsd.beans.CasosDerivados.CasoDerivadoB
import com.sd.clientsd.beans.CasosDerivados.DepEstadoB

class CasosDerivados_dependencias {

    DepEstado depEstado;
    CasosDerivados casoDerivado;


    static constraints = {
    }


    @Override
    boolean equals(other) {
        if (other instanceof CasosDerivados_dependencias) {
            other.casoDerivado.id == casoDerivado?.id && other.depEstado.id == casoDerivado?.id
        }
    }





}
