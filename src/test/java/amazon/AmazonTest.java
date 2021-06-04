package amazon;

import org.testng.annotations.Test;

import amazon.pages.ItemPage;
import amazon.pages.HomePage;
import amazon.pages.ShoppingCart;
import amazon.pages.ResultsPage;
import amazon.pages.utils.FieldEntries;
import static amazon.pages.HomePage.getHomePage;
import static amazon.pages.ResultsPage.getResultsPage;
import static amazon.pages.ItemPage.getItemPage;
import static amazon.pages.ShoppingCart.getShoppingCartPage;

public class AmazonTest extends BaseTestClass {

	HomePage homePage = getHomePage();
	ResultsPage resultsPage = getResultsPage();
	ItemPage itemPage = getItemPage();
	ShoppingCart shoppingCart = getShoppingCartPage();

	@Test
	public void DemoEquifaxAmazon() {

		// homePage
		homePage.searchForBook(FieldEntries.QATESTINGFORBEGINNERS).clickSearch();

		// resultsPage
		resultsPage.collectFirstItemPrice().clickFirstItem();

		// FirstItemPage
		itemPage.collectItemPrice().verifyItemPrice().clickAddToCart();
		
		//ShoppingCart
		shoppingCart.collectShopingCartItemPrice().verifyItemPrice().clickProceedToCheckout();
		
	}

}
