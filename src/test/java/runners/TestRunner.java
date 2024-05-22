package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:cucumber-reports.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
