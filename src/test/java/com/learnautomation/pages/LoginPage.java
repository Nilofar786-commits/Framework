package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(name="email") WebElement username;
    @FindBy(xpath = "//input[@name='password']") WebElement password;
    @FindBy(xpath = "//div[text()='Login']") WebElement loginbtn;


    public void loginTOCRM(String uname,String pass) throws InterruptedException {
        Thread.sleep(2000);
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginbtn.click();
    }

}
