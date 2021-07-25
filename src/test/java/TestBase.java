import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void SetUp(@Optional("Chrome") String browser) {
        switch (browser) {
            case "Firefox" -> {
                //Get path to geckodriver.exe from config.properties file
                try {
                    InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
                    Properties prop = new Properties();

                    // load a properties file
                    prop.load(inputStream);

                    // get path property
                    String path_to_geckodriver = prop.getProperty("path_to_geckodriver");
                    // set path to geckodriver.exe
                    System.setProperty("webdriver.gecko.driver", path_to_geckodriver);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                driver = new FirefoxDriver();
            }
            case "Chrome" -> driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
