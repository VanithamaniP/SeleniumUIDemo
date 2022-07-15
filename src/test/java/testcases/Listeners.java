package testcases;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {
    public WebDriver driver;
    @Override
    public void onTestFailure(ITestResult result) {
        try {
             driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
                    get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            generateScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
