package com.weathershop.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet wrksheet;
    static Workbook wrkbook =null;
    static Hashtable dict= new Hashtable();

    public ExcelUtil(String ExcelSheetPath) throws BiffException, IOException {
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet("data");

        //Call the Column Dictionary to store column Names
        columnDictionary();
    }

    //Returns the Number of Rows
    public static int rowCount() {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String readCell(int column, int row) {
        return wrksheet.getCell(column,row).getContents();
    }

    public static String readCell(String columnName, int rowNumber) {
        return readCell(getCell(columnName), rowNumber);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void columnDictionary() {
        for(int col=0; col < wrksheet.getColumns(); col++) {
            dict.put(readCell(col,0), col);
        }
    }

    //Read Column Names
    public static int getCell(String colName) {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);
        }
    }

}
