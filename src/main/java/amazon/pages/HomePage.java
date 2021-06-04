package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.pages.utils.FieldEntries;

import static amazon.DriverFactory.getDriverInstance;
import static amazon.DriverFactory.getDriverWaitInstance;;

public class HomePage {

	private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();
    
    WebElement searchField;

    private HomePage() {
        // hide it
    }

    public static HomePage getHomePage() {
        return new HomePage(); 
    }

    public HomePage searchForBook(FieldEntries value) {
    	searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
    	searchField.sendKeys(value.toString());
    	return this;
    }
    
    public void clickSearch() {
    	searchField.sendKeys(Keys.ENTER);
    }

}
