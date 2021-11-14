package com.sd

class TipoDenuncia {
    String titulo;
    String descripcion;

    // se definen aca relaciones entre objetos:
    // belongsTo = {denuncia:Denuncia}
    static constraints = {
        // y restricciones como:
        // name blank:false, size:3..50
    }
}
