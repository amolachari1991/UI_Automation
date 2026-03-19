package com.utility;

import com.constants.Environments;
import com.google.gson.Gson;
import com.pojo.EnvConfigration;
import com.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {

    public static Environment jsonReader(Environments environments) {

        Gson gson = new Gson();
        File jsonFilePath = new File(".//environments//config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        EnvConfigration envConfigration = gson.fromJson(fileReader, EnvConfigration.class);
        Environment environment = envConfigration.getEnvironments().get(environments.toString());
        return environment;
    }
}
