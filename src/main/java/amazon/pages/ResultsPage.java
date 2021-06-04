package amazon.pages;

import static amazon.DriverFactory.getDriverInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {

	private WebDriver driver = getDriverInstance();
	private static String price;

	private ResultsPage() {

	}

	public static ResultsPage getResultsPage() {
		return new ResultsPage();
	}

	public static String getPrice() {
		return price;
	}

	public ResultsPage collectFirstItemPrice() {

		WebElement priceElement = driver.findElement(By.xpath("(//span[@class='a-price'])[1]"));
		price = priceElement.getText().replace("\n", ".");
		System.out.println("Initial captured book price = " + price);
		return this;
	}

	public ResultsPage clickFirstItem() {
		driver.findElement(By.xpath("(//span[@class='a-price'])[1]")).click();
		return this;
	}

}
