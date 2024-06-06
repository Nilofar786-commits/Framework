package com.learnautomation.utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    public ExcelDataProvider()
    {

        try{
            File fs=new File("C://Users//mosin//IdeaProjects//HybridFramework//TestData//Data.xlsx");

            FileInputStream fis=new FileInputStream(fs);
            wb =new XSSFWorkbook(fis);
        }
        catch (Exception e)
        {
            System.out.println("Unable to read data:"+e.getMessage());
        }
    }
    public String getStringData(String sheetname,int row,int col)
    {
       return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();

    }
    public String getNumericData(int sheetinx,int row,int col)
    {
       return wb.getSheetAt(sheetinx).getRow(row).getCell(col).getStringCellValue();
    }


}
