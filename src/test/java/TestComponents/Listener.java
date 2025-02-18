package TestComponents;
import Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        extent = ExtentManager.GetReportObject();
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
            extentTest.get().log(Status.PASS," Test is successfully Pass");
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
       extentTest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        String ScreenShotPath= null;
        try {
            ScreenShotPath = TakeScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(ScreenShotPath, result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context)
    {
            if(extent!=null)
            {
                extent.flush();
            }
        }
    }
