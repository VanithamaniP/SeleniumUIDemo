package testcases;

import PageObjects.HomePage;
import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateCenterText extends BaseClass {
    public WebDriver driver;
    @BeforeTest
    public void initTest() throws IOException {
        driver=initializeBrowser();
        driver.get(prop.getProperty("url"));
        System.out.println("Thread ID Is:" +Thread.currentThread().getId());
    }
 @Test
    public void validateText()  {

     HomePage hp=new HomePage(driver);
     Assert.assertEquals(hp.getCenterText().getText(),"FEATURED COURSES12"); //This by @findBy annotations
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
