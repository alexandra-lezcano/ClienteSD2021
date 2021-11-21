package com.sd.clientsd.utils.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    private static String BASE_URL;
    private static String TIPO_DENUNCIA_RESOURCE;
    private static String USER_RESOURCE;


    static {
        try {
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            BASE_URL = properties.getProperty("base.url");
            TIPO_DENUNCIA_RESOURCE = properties.getProperty("resource.tipoDenuncia");
            USER_RESOURCE = properties.getProperty("resource.user");

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
}
