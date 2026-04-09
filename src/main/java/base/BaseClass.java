package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;

    @BeforeClass
    public void setup() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        prop.load(fis);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    public String captureScreenshot(String testName) {
        String timeStamp = new java.text.SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
         File folder = new File(System.getProperty("user.dir") + "/screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
          String fileName = testName + "_" + timeStamp + ".png";
        String destination = System.getProperty("user.dir") + "/screenshots/" + fileName;
        
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
             return "screenshots/" + fileName; 
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}