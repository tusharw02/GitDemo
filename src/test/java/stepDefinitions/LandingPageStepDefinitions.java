package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LandingPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.TestContextSetup;

public class LandingPageStepDefinitions {

	TestContextSetup contextSetup;
	LandingPageObjects lpage;
	
	public LandingPageStepDefinitions(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
		this.lpage = contextSetup.pageObjManager.getLandingPage();
	}
	
	@Given("User is on GreenKart Landing page")
	public void user_is_on_green_kart_landing_page() {
		
//		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver2021\\chromedriver.exe");
//		contextSetup.driver = new ChromeDriver();
//		contextSetup.driver.manage().window().maximize();
//		contextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		contextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				
	}
	
	@When("^User searchd with short name (.+) extracted actual name of product$")
	public void user_searchd_with_short_name_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
	//	LandingPageObjects lpage = new LandingPageObjects(contextSetup.driver);
		Thread.sleep(1000);
		lpage.landingPagesearch(shortName);
		Thread.sleep(1000);
		//contextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		contextSetup.landingPageProductName = lpage.landingPagegetProduct().split("-")[0].trim();
		//contextSetup.landingPageProductName = contextSetup.driver.findElement(By.xpath("//h4[@class='product-name' and contains(text(),'Tom')]")).getText().split("-")[0].trim();		
	}
	
	@And("^User will add (.+) items of this products in to the cart$")
	public void user_will_add_items_of_this_products_in_to_the_cart(int itemQty) {
		
		for(int i=1;i<itemQty;i++) {
			lpage.incrementClick();
		}
		
		lpage.addToCartBtnClick();		
		
	}
}
