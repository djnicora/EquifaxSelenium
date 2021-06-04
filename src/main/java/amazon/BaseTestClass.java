package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import static amazon.DriverFactory.getDriverInstance;
import static amazon.DriverFactory.getDriverWaitInstance;

public class BaseTestClass {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://amazon.com";

    @BeforeSuite
    public void startUpBrowser() {
        driver = getDriverInstance();
        wait = getDriverWaitInstance();
    }

    @BeforeTest
    public void goToHomePage() {
        driver.get(url);
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.close();
    }

}
