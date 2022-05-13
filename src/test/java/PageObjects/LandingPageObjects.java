package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {
	
	public WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By product = By.xpath("//h4[@class='product-name']");
	By topDealsBtn = By.xpath("//a[contains(text(),\"Top Deals\")]");
	By increment = By.xpath("//a[@class=\"increment\"]");
	By addToCartBtn = By.xpath("//button[@type=\"button\" and text()=\"ADD TO CART\"]");
	
	public void landingPagesearch(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String landingPagegetProduct() {
		return driver.findElement(product).getText();
	}
	
	public void landingPagetopDealsBtnClick() {
		driver.findElement(topDealsBtn).click();
	}
	
	public void incrementClick() {
		driver.findElement(increment).click();
	}
	
	public void addToCartBtnClick() {
		driver.findElement(addToCartBtn).click();
	}
	

	
}
