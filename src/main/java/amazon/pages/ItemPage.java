package amazon.pages;

import static amazon.DriverFactory.getDriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemPage {

	private WebDriver driver = getDriverInstance();
	private String itemPagePrice;

	private ItemPage() {
		// hide it
	}

	public static ItemPage getItemPage() {
		return new ItemPage(); // returns the class object
	}

	/*
	 * Returning the methods like this makes us able to implements the pattern
	 * method chaining
	 */
	public ItemPage collectItemPrice() {
		itemPagePrice = driver.findElement(By.xpath("//span[@id='newBuyBoxPrice']")).getText().replace("\n", ".");
		System.out.println("Captured in Item book price = " + itemPagePrice);
		return this;
	}

	public ItemPage verifyItemPrice() {
		Assert.assertTrue(itemPagePrice.equals(ResultsPage.getPrice()), "Price is not equal");
		System.out.println("Item price = " + itemPagePrice + " equal to price from step3 = " + ResultsPage.getPrice());
		return this;
	}

	public void clickAddToCart() {
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();
	}

}
