package com.learnautomation.testcases;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTestCRM extends BaseClass {


    @Test
    public void loginApp() throws InterruptedException
    {
       logger=reports.createTest("logintoCRM");
        //ex.getStringData("Login",0,0);
        System.out.println("Title:"+driver.getTitle());

         LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);

         logger.info("Starting application");
         loginPage.loginTOCRM(ex.getStringData("Login",0,0),ex.getStringData("Login",0,1));
         logger.pass("login successfully");
        Helper.captureScreenshot(driver);

    }

}
