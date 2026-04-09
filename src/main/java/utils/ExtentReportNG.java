package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
    public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Path where report will be saved
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
            
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Checkout Flow Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("QA Engineer", "Ezhilarasi");
            extent.setSystemInfo("Environment", "Windows 11 / Chrome 146");
        }
        return extent;
    }
}