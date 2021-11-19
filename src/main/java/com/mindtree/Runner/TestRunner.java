package com.mindtree.Runner;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mindtree.PageObject._002_SortingFeaturePO;
import com.mindtree.PageObject._003_NavigatingMenuOptionsPO;
import com.mindtree.PageObject._004_SearchProductPO;
import com.mindtree.PageObject._005_AddToCartPO;
import com.mindtree.PageObject._006_AddGiftCardPO;
import com.mindtree.PageObject._007_ContactUsPO;
import com.mindtree.PageObject._008_WishListPO;
import com.mindtree.PageObject._009_CartPO;
import com.mindtree.PageObject._010_AboutUsPO;
import com.mindtree.Utilities.BrowserConnection;
import com.mindtree.Utilities.ExcelUtility;
import com.mindtree.Utilities.ReadPropertyFile;

public class TestRunner {
	static WebDriver driver;
	public static Logger Log = LogManager.getLogger(BrowserConnection.class.getName());

	// LOADING THE BROWSER
	@Test(priority = 1)
	public static void loadBrowser() throws IOException, InterruptedException {
		ReadPropertyFile readOB = new ReadPropertyFile();
		BrowserConnection.intializeDriver();
		driver = BrowserConnection.getDriver();
		Log.info("Chrome Browser is launching...");
		driver.get(readOB.geturl());
		Log.info("Opened the Website URL!");
		Thread.sleep(2000);
	}

	// TESTING THE SORTING FEATURE
	@Test(priority = 2)
	public static void sortingFeature() throws InterruptedException {
		// User clicked on the option Personalized Gifts
		WebElement ele = _002_SortingFeaturePO.personalizedGifts(driver);
		ele.click();
		Log.info("Clicked on the Personalized Gifts options");

		// Validate if it is the Personalized Gifts page
		WebElement t = _002_SortingFeaturePO.pageTitle(driver);
		String title = t.getText();
		Log.info("Verify if it is the desired page...");
		Thread.sleep(2000);
		if (title.equalsIgnoreCase("Personalized Gifts")) {
			Log.info("Welcome to Personalized gifts");
		} else {
			Log.info("Wrong Page");
		}

		// Select Best selling from Sort By feature
		Thread.sleep(2000);
		WebElement s = _002_SortingFeaturePO.sortBy(driver);
		Log.info("Selecting the Sort By feature");
		Select elements = new Select(s);
		elements.selectByIndex(2);
		Log.info("Selected the option Best Selling");

		// Validate the first Product
		Log.info("Verifying first product Personalized Moon Lamp");
		WebElement pro = _002_SortingFeaturePO.firstProduct(driver);
		String protitle = pro.getText();
		if (protitle.contains("Personalized Moon Lamp")) {
			Log.info("First product is Personalized Moon Lamp");
		} else {
			Log.info("Product not found");
		}
	}

	// NAVIGATING THROUGH THE MENU OPTIONS
	@Test(priority = 3)
	public static void navigatingTheMenus() throws InterruptedException {
		// User hover on option Gifts

		Thread.sleep(2000);
		WebElement ele = _003_NavigatingMenuOptionsPO.gifts(driver);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Log.info("Hovering the Gifts option");

		// Select the option Gifts for Guys

		WebElement subMenu = _003_NavigatingMenuOptionsPO.subMenu(driver);
		action.moveToElement(subMenu).perform();
		WebElement guys = _003_NavigatingMenuOptionsPO.guys(driver);
		action.moveToElement(guys).click().build().perform();
		Log.info("Clicking the Guys for Gifts Option");
		Thread.sleep(2000);

		// Verify it is the Gifts for Guys page

		WebElement t = _003_NavigatingMenuOptionsPO.title1(driver);
		String title = t.getText();
		Log.info("Verify if it is the Gifts for Guys page!");
		if (title.contains("Gifts For Guys")) {
			Log.info("It is the Gifts for guys Page");
		} else {
			Log.info("It is the wrong page");
		}
		Thread.sleep(2000);

		// User select the option Christmas Gifts

		WebElement ele1 = _003_NavigatingMenuOptionsPO.Christmas(driver);
		ele1.click();
		Log.info("Clicked the Christmas Gifts options");
		Thread.sleep(2000);

		// Verify it is the Christmas Gifts Page

		WebElement t2 = _003_NavigatingMenuOptionsPO.title2(driver);
		String title2 = t2.getText();
		Log.info("Verify if it is the Christmas Gifts page!");
		if (title2.contains("Christmas Gifts")) {
			Log.info("It is the Christmas Gifts Page");
		} else {
			Log.info("It is the wrong page");
		}
		Thread.sleep(2000);
	}

	// TO SEARCH A PRODUCT
	@Test(priority = 4)
	public static void searchProduct() throws InterruptedException {
		// Write in the Search bar and Search

		WebElement search = _004_SearchProductPO.searchBar(driver);
		search.click();
		search.sendKeys("harry potter");
		search.sendKeys(Keys.ENTER);
		Log.info("Searching for harry potter product");
		Thread.sleep(2000);

		// Print the first Search result containing the Search keyword

		WebElement product = _004_SearchProductPO.product(driver);
		String title = product.getText();
		Log.info("First Product Title: " + title);
		if (title.contains("Harry Potter")) {
			Log.info("The Product Contains the Keyword SEARCH SUCCESSFUL");
		} else {
			Log.info("Product not found");
		}
		Thread.sleep(2000);
	}

	// ADD TO CART
	@Test(priority = 5)
	public static void addToCart() throws InterruptedException {
		// User click the Secret Santa Gifts and click the first product

		WebElement secretSanta = _005_AddToCartPO.secretSanta(driver);
		secretSanta.click();
		Log.info("Clicked Secret Santa Gifts Option");
		WebElement firstPro = _005_AddToCartPO.firstProduct(driver);
		firstPro.click();
		Log.info("Clicked the first product");
		Thread.sleep(2000);

		// Click Add To Cart button

		WebElement addButton = _005_AddToCartPO.addButton(driver);
		addButton.click();
		Log.info("Clicked the Add To Cart Button");
		Thread.sleep(2000);

		// Click on the Continue Shopping Button

		WebElement conShop = _005_AddToCartPO.conShop(driver);
		conShop.click();
		Log.info("Click the Continue Shopping to Shop more");
		Thread.sleep(2000);
	}

	// ADD GIFT CARD
	@Test(priority = 6)
	public static void addGiftCard() throws InterruptedException {
		// User clicked the Gift Card option

		WebElement giftCard = _006_AddGiftCardPO.giftCard(driver);
		giftCard.click();
		Log.info("Clicked the gift card option");

		// User select the value of Gift card option

		WebElement value = _006_AddGiftCardPO.value(driver);
		value.click();
		Log.info("Clicked the 2000 Gift card option");

		// User clicked the Add To Card button

		WebElement addButton = _006_AddGiftCardPO.addButton(driver);
		addButton.click();
		Log.info("Clicked the Add to Cart button..The Gift card added");
		Thread.sleep(2000);

		// User Clicked the Continue Shopping button

		WebElement conShop = _006_AddGiftCardPO.conShop(driver);
		conShop.click();
		Log.info("Clicked on the Continue Shopping button for more shopping");
		Thread.sleep(2000);
	}

	// CONTACT US PAGE
	@Test(priority = 7)
	public static void contactUs() throws InterruptedException, IOException {
		// User clicked the Contact us option

		WebElement contact = _007_ContactUsPO.contact(driver);
		contact.click();
		Log.info("Clicked the Contact us page option");

		// User entered the name, email, message
		
		ArrayList<String> data = ExcelUtility.getData();
		/*for(int i = 0; i < data.size(); i++) {   
		    System.out.print(data.get(i));
		} */ 
		WebElement userName = _007_ContactUsPO.name(driver);
		WebElement userEmail = _007_ContactUsPO.email(driver);
		WebElement userMsg = _007_ContactUsPO.msg(driver);
		Log.info("Entering the details: ");
		userName.sendKeys(data.get(0));
		Log.info(data.get(0));
		userEmail.sendKeys(data.get(1));
		Log.info(data.get(1));
		userMsg.sendKeys(data.get(2));
		Log.info(data.get(2));
		Thread.sleep(2000);

		// Click on the Submit button and verify submission

		WebElement submit = _007_ContactUsPO.btn(driver);
		submit.click();
		Log.info("Clicked the submit button");
		Thread.sleep(2000);
		Log.info("Successfully contacted");
	}

	// WISHLIST FEATURE
	@Test(priority = 8)
	public static void wishList() throws InterruptedException {
		// User clicked the Top50 option

		WebElement ele = _008_WishListPO.top50(driver);
		ele.click();
		Log.info("Clicked the top 50 option");

		// User clicked the first product

		WebElement pro = _008_WishListPO.firstProduct(driver);
		pro.click();
		Log.info("Clicked the first product");
		Thread.sleep(4000);

		// click the Add to Wishlist feature

		WebElement btn = _008_WishListPO.wishBtn(driver);
		btn.click();
		Log.info("Wish List button clicked");
		Thread.sleep(2000);

		//Checked if the item is present
		
		WebElement text = driver.findElement(By.xpath("//*[@id='swym-notification-title']/a/span"));
	    String notification = text.getText();
	    if(notification.contains("The item has been added to your wishlist")) {
	    	Log.info("Got the Successfully added to wishlist Message");
	    }else {
	    	Log.info("Not Added to Wish list");
	    }
	}
	
	//CHECK CART FOR ITEMS
	@Test(priority = 9)
	public static void cart() throws InterruptedException {
		//User clicked the Cart option
		
		Thread.sleep(2000);
		WebElement cart = _009_CartPO.cart(driver);
		cart.click();
		Log.info("Clicked the cart option");
		
		//Verify the Cart
		
		WebElement cartHeader = _009_CartPO.cartHeader(driver);
		String heading = cartHeader.getText();
		if (heading.contains("Shopping Cart (0 items)")) {
			Log.info("Cart is Empty");
		} else {
			Log.info("Cart has some items");
		}

		Thread.sleep(2000);
		WebElement conShop = _009_CartPO.conShop(driver);
		conShop.click();
		Log.info("Back to Shopping");
		Thread.sleep(2000);
	}
	
	//ABOUT US PAGE
	@Test(priority = 10)
	public static void aboutUs() throws InterruptedException{
		//User clicked the About Us option
		
		WebElement aboutUs = _010_AboutUsPO.aboutUs(driver);
	    aboutUs.click();
	    Log.info("About Us page opened");
	    
	    //Verify it is the About us page
	    
	    WebElement t = _010_AboutUsPO.title(driver);
		String title = t.getText();
		if(title.contains("About us")) {
			Log.info("It is the the About us page");
		}else {
			Log.info("It is wrong page");
		}
		Thread.sleep(2000);
	}

}







