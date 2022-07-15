package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGeneration {
    public static ExtentReports extent;
    public static ExtentReports generateReport()
    {
        String path=System.getProperty("user.dir")+"/Reports/ReportIndex.html";

        System.out.println("Inside the generate Report");
        ExtentSparkReporter reportConfig=new ExtentSparkReporter(path);
        reportConfig.config().setDocumentTitle("Selenium E2E Project");
        reportConfig.config().setReportName("Demo E2E");
        extent=new ExtentReports();
        extent.attachReporter(reportConfig);
        return extent;
    }
}
