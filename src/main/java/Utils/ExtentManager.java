package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    public static ExtentReports GetReportObject() {

        String reportPath = System.getProperty("user.dir") + "/report/Piyush.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        File reportDir = new File(System.getProperty("user.dir") + "/report");

        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        spark.config().setDocumentTitle("Test Result");
        spark.config().setReportName("Amazon Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester Name", "Piyush");
        extent.setSystemInfo("Environment", "QA");
        return extent;
    }
}
