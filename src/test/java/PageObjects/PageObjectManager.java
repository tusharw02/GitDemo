package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPageObjects landingPageObject;
	public OfferPageObject offersPageObject;
	public CheckoutPageObjects checkoutPageObject;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPageObjects getLandingPage() {
		landingPageObject = new LandingPageObjects(driver);
		return landingPageObject;
	}
	
	public OfferPageObject getOffersPage() {
		offersPageObject = new OfferPageObject(driver);
		return offersPageObject;
	}
	
	public CheckoutPageObjects getCheckoutPage() {
		checkoutPageObject = new CheckoutPageObjects(driver);
		return checkoutPageObject;
	}
}
