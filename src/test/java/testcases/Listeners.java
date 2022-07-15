package testcases;

import base.BaseClass;
import base.ReportGeneration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static base.ReportGeneration.extent;

public class Listeners extends BaseClass implements ITestListener {
    public WebDriver driver;
    ExtentReports extent= ReportGeneration.generateReport();
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
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test Started");
        ExtentTest test= extent.createTest(result.getMethod().getMethodName());

    }
}
