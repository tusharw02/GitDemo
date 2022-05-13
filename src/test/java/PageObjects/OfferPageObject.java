package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPageObject {

	public WebDriver driver;
	
	public OfferPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By offerPageSearch = By.xpath("//input[@id='search-field']");
	By offerPageGetProductName = By.xpath("//table[@class='table table-bordered']//td[1]");
	

	
	public void offerPageSearch(String name) {
		driver.findElement(offerPageSearch).sendKeys(name);
	}
	
	public String offerPageGetProductName() {
		return driver.findElement(offerPageGetProductName).getText();
	}
	
}
