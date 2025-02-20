package TestComponents;

import PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    public  WebDriver driver;
    public LandingPage lp;

    public WebDriver Setup() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Global.properties");
        prop.load(fis);
        String browser = prop.getProperty("Browser");
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            System.getProperty("webdriver.gecko.driver","//Users//ahlawat//Downloads//geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        return driver;
    }
    public String TakeScreenshot(String Methodname, WebDriver driver) throws IOException {
        TakesScreenshot ScreenShot = ((TakesScreenshot)driver);
        File src = ScreenShot.getScreenshotAs(OutputType.FILE);

        String ScreenshotPath = System.getProperty("user.dir")+"/report"+Methodname+".png";
        File file = new File(ScreenshotPath);
        FileUtils.copyFile(src, file);
        return ScreenshotPath;
    }

    @BeforeClass
    public LandingPage Wakeup() throws IOException {
        driver = Setup();
        lp = new LandingPage(driver);
        lp.LaunchAmazon();
        return lp;
    }

    @AfterClass
    public void TearDown()
    {
        driver.close();
    }

}
