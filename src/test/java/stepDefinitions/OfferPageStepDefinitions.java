package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LandingPageObjects;
import PageObjects.OfferPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.TestContextSetup;



public class OfferPageStepDefinitions {

	public String OfferPageProductName;
	TestContextSetup contextSetup;
	
	
	public OfferPageStepDefinitions(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
	}
	
	
	
	@Then("^User search for (.+) short name on offers page$")
	public void user_search_for_same_short_name_on_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
	
		switchToOffersPage();
		
		OfferPageObject offerPage = contextSetup.pageObjManager.getOffersPage();
	//	OfferPageObject offerPage = new OfferPageObject(contextSetup.driver);
		Thread.sleep(2000);
		offerPage.offerPageSearch(shortName);
		Thread.sleep(2000);
	//	contextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		
		OfferPageProductName = offerPage.offerPageGetProductName();
	//	OfferPageProductName = contextSetup.driver.findElement(By.xpath("//table[@class='table table-bordered']//td[text()='Tomato']")).getText();
	}
	
	public void switchToOffersPage() {
		LandingPageObjects lPage = contextSetup.pageObjManager.getLandingPage();
	//	LandingPageObjects lPage = new LandingPageObjects(contextSetup.driver);
		
		lPage.landingPagetopDealsBtnClick();
		//	contextSetup.driver.findElement(By.xpath("//a[contains(text(),\"Top Deals\")]")).click();
		
		contextSetup.genericUtils.switchWindowToChild();
	}
	
	@Then("Validate product name in offers page matches with lanidng page")
	public void validate_product_name_in_offers_page_matches_with_lanidng_page() {
	    if(contextSetup.landingPageProductName.equalsIgnoreCase(OfferPageProductName)) {
	    	System.out.println("Both product names are matching");
	    }
	    else {
	    	System.out.println("Both product names are not matching");
	    }
		
		Assert.assertEquals(contextSetup.landingPageProductName, OfferPageProductName);

	  
	}
}
