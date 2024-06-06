package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
    Properties pro;
    public ConfigDataProvider()
    {

        try {
            File scr=new File("./Configuration/Config.properties");
            FileInputStream fis=new FileInputStream(scr);
            pro=new Properties();
            pro.load(fis);

        }
        catch (Exception e)
        {
            System.out.println("Exception is:"+e.getMessage());
        }
    }

    public String getDataFromConfig(String keyTOSreach)
    {
        return pro.getProperty(keyTOSreach);
    }
    public String getBrowser()
    {
    return pro.getProperty("Browser");
    }
    public String getStagingURL()
    {
return pro.getProperty("Testenv");
    }

}
