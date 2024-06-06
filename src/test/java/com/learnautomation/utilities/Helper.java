package com.learnautomation.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

public class Helper {


    //screenshort/frame/windows/alerts/sync issue/java scipt executor

    public static String captureScreenshot(WebDriver driver)
    {
        TakesScreenshot tr=(TakesScreenshot)driver;
        String filepath=System.getProperty("user.dir")+"/Screenshots/CRM_"+getCurrentTime()+".png";
      File sr=  tr.getScreenshotAs(OutputType.FILE);
        try {
            org.openqa.selenium.io.FileHandler.copy(sr,new File(filepath));
            System.out.println("Screenshot captured successfully");
        } catch (Exception e) {
          System.out.println("While taking screenshot file is not found:"+e.getMessage());
        }
  return filepath;
    }

    public static String getCurrentTime()
    {
        DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date d = new Date();
        return df.format(d);
    }
}

