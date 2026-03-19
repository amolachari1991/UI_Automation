package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvReaderUtility {
    public static Iterator<User> csvFileReader(String filename) {
        File csvFilePath = new File(System.getProperty("user.dir")+"\\testData\\"+filename+".csv");
        FileReader csvFileToRead = null;
        CSVReader csvReader;
        String[] line;
        User user;
        List<User> userList = null;
        try {
            csvFileToRead = new FileReader(csvFilePath);
            csvReader = new CSVReader(csvFileToRead);
            csvReader.readNext();
            userList = new ArrayList<>();
            while ((line = csvReader.readNext()) != null) {
                user = new User(line[0],line[1] );
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList.iterator();
    }
}
