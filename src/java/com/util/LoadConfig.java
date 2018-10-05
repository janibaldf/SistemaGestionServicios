
package com.util;

import com.model.dto.ConfigBean;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadConfig {

    private ConfigBean config;
    private static LoadConfig loadconfig;
   // private static final Logger LOGGER = LogManager.getLogger(LoadConfig.class.getName());

    private LoadConfig() {

        Properties prop = new Properties();
        this.config = new ConfigBean();

        try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(stream);
            this.config.setDBUser(prop.getProperty("dbuser"));
            this.config.setDBPassword(prop.getProperty("dbpassword"));
            this.config.setDBURL(prop.getProperty("dburl"));
            stream.close();
            
          //  LOGGER.debug("Cargando el arhivo de propiedades.");
           // LOGGER.debug(this.config.getAllValues());
            
        } catch (Exception ex) {
            //LOGGER.error("Al cargar el archivo de configurarcion : config.properties");
            //LOGGER.error(ex.toString());
     
        }

    }

    public static LoadConfig getInstance() {
   
        if (loadconfig == null) {
            loadconfig = new LoadConfig();
          
        }
        return loadconfig;
    }

    public ConfigBean getConfiguration() {
        return this.config;
    }
}
