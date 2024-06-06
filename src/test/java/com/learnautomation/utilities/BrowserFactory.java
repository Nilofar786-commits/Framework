package com.learnautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver,String browsername,String appurl)
    {


        if (browsername.equalsIgnoreCase("Edge")) {
            EdgeOptions options=new EdgeOptions();
            options.addArguments("--REmote-allow-origins=*");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
          //System.setProperty("WebDriver.edge.driver","C://Users//mosin//IdeaProjects//HybridFramework//Drivers//msedgedriver.exe");
           System.setProperty("webdriver.edge.driver","C://Nilofar//msedgedriver.exe");
            driver=new EdgeDriver(options);

        }
        else if (browsername.equalsIgnoreCase("Chrome"))
        {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--REmote-allow-origins=*");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            System.setProperty("WebDriver.chrome.driver","./Drivers/msedgedriver.exe");
            driver=new ChromeDriver(options);
        }
        else if (browsername.equalsIgnoreCase("IE"))
        {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--REmote-allow-origins=*");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            System.setProperty("WebDriver.ie.driver","./Drivers/msedgedriver.exe");
            driver=new InternetExplorerDriver();
        }
        else
        {
            System.out.println("We do not support this browser");
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    public static void quiteBrowser(WebDriver driver)
    {
        driver.quit();
    }
}
