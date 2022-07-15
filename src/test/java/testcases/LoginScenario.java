package testcases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import base.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginScenario extends BaseClass {
    LoginPage lp;
    @BeforeTest
    public void initTest() throws IOException {
        driver=initializeBrowser();
        driver.get(prop.getProperty("url"));
        HomePage hp=new HomePage(driver);

         lp=  hp.getLoginLink();
        System.out.println("Thread ID Is:" +Thread.currentThread().getId());
    }
    @Test(dataProvider = "getData")
    public void navigatingHomePage(String email,String password)  {


        lp.getEmail().sendKeys(email);
        lp.getPassword().sendKeys(password);
        lp.getLoginButton().click();

    }
    @DataProvider
    public Object[][] getData()
    {
        //Row --> how iteration
        //Column --> how many values each iteration
        Object[][] data=new Object[2][2];
        data[0][0]="test1@gmail.com";
        data[0][1]="test1";

                //2nd iteration
        data[1][0]="test2@gmail.com";
        data[1][1]="test2";
        return data;
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    //Pom -- BY locators and FindBy
    //Data Privided
    //TestNG

}
