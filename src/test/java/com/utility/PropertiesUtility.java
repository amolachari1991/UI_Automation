package com.utility;

import com.constants.Environments;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
    public static String readProperty(Environments env, String property) {
        Properties properties = new Properties();
        File environmentFilePath = new File(".//environments//" + env + ".properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(environmentFilePath);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(property.toUpperCase());
    }
}
