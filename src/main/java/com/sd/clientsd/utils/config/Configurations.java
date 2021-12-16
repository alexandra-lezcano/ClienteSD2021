package com.sd.clientsd.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    public static final String CACHE_NAME = "cliente-cache";
    private static String DENUNCIA_RESOURCE;
    private static String DENUNCIA_ESTADO_RESOURCE;
    private static String TIPO_SUJETO_RESOURCE;
    private static String NEIGHBORHOOD_RESOURCE;
    private static String CITY_RESOURCE;
    private static String BASE_URL;
    private static String TIPO_DENUNCIA_RESOURCE;
    private static String USER_RESOURCE;
    private static String SUJETO_RESOURCE;
    private static Integer ELEMS_PAGINATION;
    private static String DEPESTADO_RESOURCE;
    private static Integer TIPO_DENUNCIANTE_ID;
    private static Integer TIPO_VICTIMA_ID;
    private static Integer TIPO_VICTIMARIO_ID;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("./grails-app/conf/config.properties");
            properties.load(inputStream);

            BASE_URL = properties.getProperty("base.url");
            TIPO_DENUNCIA_RESOURCE = properties.getProperty("resource.tipoDenuncia");
            USER_RESOURCE = properties.getProperty("resource.user");
            CITY_RESOURCE = properties.getProperty("resource.city");
            NEIGHBORHOOD_RESOURCE = properties.getProperty("resource.neighborhood");
            TIPO_SUJETO_RESOURCE = properties.getProperty("resource.tipoSujeto");
            SUJETO_RESOURCE = properties.getProperty("resource.sujeto");
            DENUNCIA_ESTADO_RESOURCE = properties.getProperty("resource.estadoDenuncia");
            DENUNCIA_RESOURCE = properties.getProperty("resource.denuncia");
            DEPESTADO_RESOURCE=properties.getProperty("resource.depEstado");
            TIPO_DENUNCIANTE_ID=Integer.parseInt(properties.getProperty("tipo.denunciante.id"));
            TIPO_VICTIMA_ID=Integer.parseInt(properties.getProperty("tipo.victima.id"));
            TIPO_VICTIMARIO_ID=Integer.parseInt(properties.getProperty("tipo.victimario.id"));

            ELEMS_PAGINATION = Integer.parseInt(properties.getProperty("global.pagination"));


        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Something went wrong at configuration initialization.");
            System.err.println(e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getTipoDenunciaResource() {
        return TIPO_DENUNCIA_RESOURCE;
    }
    public static String getUserResource() {
        return USER_RESOURCE;
    }

    public static String getCityResource() {
        return CITY_RESOURCE;
    }

    public static String getNeighborhoodResource() {return NEIGHBORHOOD_RESOURCE;}

    public static String getTipoSujetoResource() {return TIPO_SUJETO_RESOURCE;}

    public static String getSujetoResource(){return SUJETO_RESOURCE;}

    public static String gerDenunciaEstadoResource() {return DENUNCIA_ESTADO_RESOURCE;}

    public static String getDenunciaResource() { return DENUNCIA_RESOURCE;}

    public static Integer getElemsPagination(){ return ELEMS_PAGINATION;}

    public static String getDepestadoResource(){return DEPESTADO_RESOURCE;}

    public static Integer getTipoDenuncianteId(){ return TIPO_DENUNCIANTE_ID; }

    public static Integer getTipoVictimaId(){ return TIPO_VICTIMA_ID; }

    public static Integer getTipoVictimarioId(){ return TIPO_VICTIMARIO_ID; }
}
