package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;
    public WebDriver initializeBrowser() throws IOException {
         prop=new Properties();
        FileInputStream fis=new FileInputStream("/Users/vanithamanip/Desktop/IntellijiWorkspace/SeleniumE2EDemo/src/main/java/base/data.properties");
        prop.load(fis);
       String browser= prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();


            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
WebDriverManager.edgedriver().setup();
driver=new EdgeDriver();
        }
        return driver;
    }
    public void generateScreenshot(String methodName,WebDriver driver) throws IOException {
        TakesScreenshot shots=(TakesScreenshot) driver;
        File source=shots.getScreenshotAs(OutputType.FILE);
        String destination=System.getProperty("user.dir")+"/reports/"+methodName+".png";
        FileUtils.copyFile(source,new File(destination));
    }
}
