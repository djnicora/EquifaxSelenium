package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

	private static WebDriver driver;
	private static WebDriverWait wait;

	private DriverFactory() {

	}

	public static WebDriver getDriverInstance() {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		return driver;
	}

	public static WebDriverWait getDriverWaitInstance() {

		if (wait == null) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/browserDrivers/chromedriver.exe");
			wait = new WebDriverWait(driver, 10);

		}
		return wait;
	}

}
