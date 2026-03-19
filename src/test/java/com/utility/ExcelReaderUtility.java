package com.utility;

import com.pojo.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcel(String sheetName) {
        File excelPath = new File(".//testData//"+sheetName+".xlsx");
        XSSFWorkbook workbook = null;
        XSSFSheet sheet;
        Iterator<Row> rowInterator;
        List<User> userList;
        try {
            workbook = new XSSFWorkbook(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet("loginData");
        rowInterator = sheet.iterator();
        rowInterator.next();
        userList = new ArrayList<>();
        while ( rowInterator.hasNext()){
            Row row = rowInterator.next();
            Cell firstCell = row.getCell(0);
            Cell secondCell = row.getCell(1);
            User user = new User(firstCell.toString(), secondCell.toString());
            userList.add(user);
        }
        return userList.iterator();
    }
}
