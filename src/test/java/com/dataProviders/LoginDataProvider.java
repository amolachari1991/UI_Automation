package com.dataProviders;

import com.google.gson.Gson;
import com.pojo.TestData;
import com.pojo.User;
import com.utility.CsvReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File loginDataPath = new File(".//testData//loginData.json");
        FileReader fileReader = new FileReader(loginDataPath);
        TestData data = gson.fromJson(fileReader, TestData.class);

        List <Object[]> dataToReturn = new ArrayList<Object[]>();
        for(User user : data.getData()){
            dataToReturn.add(new Object[]{user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "loginCSVDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CsvReaderUtility.csvFileReader("loginData");
    }

    @DataProvider(name = "loginExcelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcel("loginData");
    }
}
