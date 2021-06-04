package amazon.pages;

import static amazon.DriverFactory.getDriverInstance;
import static amazon.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCart {

	private WebDriver driver = getDriverInstance();
	private WebDriverWait wait = getDriverWaitInstance();
	private String shopingCartItemPrice;

	private ShoppingCart() {
	}

	public static ShoppingCart getShoppingCartPage() {
		return new ShoppingCart(); // returns the class object
	}

	public ShoppingCart collectShopingCartItemPrice() {
		shopingCartItemPrice = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]"))).getText();
		System.out.println("Captured shopping cart book price = " + shopingCartItemPrice);
		return this;
	}

	public ShoppingCart verifyItemPrice() {
		Assert.assertTrue(shopingCartItemPrice.equals(ResultsPage.getPrice()), "Price is not equal");
		System.out.println("Shopping cart item price = " + shopingCartItemPrice + " equal to price from step3 = " + ResultsPage.getPrice());
		return this;
	}

	public void  clickProceedToCheckout() {
		WebElement proceedToCheckout = driver.findElement(By.id("hlb-ptc-btn-native"));
		proceedToCheckout.click();
		System.out.println("I don't have Amazon account so no results from checkout page!!!");
	}
}
