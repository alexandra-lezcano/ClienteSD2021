package com.sd.clientsd.utils.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    private static String TIPO_SUJETO_RESOURCE;
    private static String NEIGHBORHOOD_RESOURCE;
    private static String CITY_RESOURCE;
    private static String BASE_URL;
    private static String TIPO_DENUNCIA_RESOURCE;
    private static String USER_RESOURCE;
    private static String SUJETO_RESOURCE;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            BASE_URL = properties.getProperty("base.url");
            TIPO_DENUNCIA_RESOURCE = properties.getProperty("resource.tipoDenuncia");
            USER_RESOURCE = properties.getProperty("resource.user");
            CITY_RESOURCE = properties.getProperty("resource.city");
            NEIGHBORHOOD_RESOURCE = properties.getProperty("resource.neighborhood");
            TIPO_SUJETO_RESOURCE = properties.getProperty("resource.tipoSujeto");
            SUJETO_RESOURCE = properties.getProperty("resource.sujeto");
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
}
