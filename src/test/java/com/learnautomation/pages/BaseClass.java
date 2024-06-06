package com.learnautomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public ExcelDataProvider ex;
    public WebDriver driver;
    public ConfigDataProvider co;
    public ExtentReports reports;
    public ExtentTest logger;

    @BeforeSuite
    public void setUPSuit()
    {
        Reporter.log("**********Startup script started************",true);
        ex =new ExcelDataProvider();
        co=new ConfigDataProvider();

        ExtentHtmlReporter exr=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentTime()+".html"));
        reports=new ExtentReports();
        reports.attachReporter(exr);
        Reporter.log("**********Test can be started************",true);
    }

    @BeforeClass
    public void startup()
    {
        Reporter.log("Strtaed browser***********");
        driver= BrowserFactory.startApplication(driver,co.getBrowser(),co.getStagingURL());
        Reporter.log("browser and application started***********");
    }


    @AfterClass
    public void tearDown()
    {
        BrowserFactory.quiteBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result)
    {

        Reporter.log("test is about to end ***********");
        if(result.getStatus()==ITestResult.FAILURE) {
            //Helper.captureScreenshot(driver);
            try {
                logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
                //logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (result.getStatus()==ITestResult.SUCCESS)
        {
            try {
                logger.pass("Test successfull",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
               // logger.pass("Test successfull",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reports.flush();
    }
}
