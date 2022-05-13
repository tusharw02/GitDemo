package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPageObjects {

	public WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By cart = By.xpath("//a[@class='cart-icon']/img");
	By cartProductName = By.xpath("(//div[@class='product-info']/p[@class='product-name'])[1]");
	By cartProductQty = By.xpath("(//div[@class='product-total']/p[@class='quantity'])[1]");
	By proceedToCheckoutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By checkoutProdtName = By.xpath("//div[@class='products']//td[2]/p");
	By checkoutProdQty = By.xpath("//div[@class='products']//td[3]/p");
	By promoBtn = By.xpath("//button[@class='promoBtn']");
	By plceOrderBtn = By.xpath("//button[text()='Place Order']");
	By staticDropDown = By.tagName("select");
	By checkBox = By.xpath("//input[@type='checkbox']");
	By proceedBtn = By.xpath("//button[text()='Proceed']");
	
	
	public void cartClick() {
		driver.findElement(cart).click();
	}
	
	public String getCartProductName() {
		 return driver.findElement(cartProductName).getText();
	}
	
	public String getCartProductQty() {
		return driver.findElement(cartProductQty).getText();
	}
	
	public void proceedToCheckoutBtnClick() {
		driver.findElement(proceedToCheckoutBtn).click();
	}
	
	public String getCheckoutProdtName() {
		return driver.findElement(checkoutProdtName).getText();
	}
	
	public String getCheckoutProdQty() {
		return driver.findElement(checkoutProdQty).getText();
	}
	
	public boolean promoBtnIsDisplayed() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean plcaeOrderBtnIsDisplayed() {
		return driver.findElement(plceOrderBtn).isDisplayed();
	}
	
	public void plcaeOrderBtnclick() {
		driver.findElement(plceOrderBtn).click();
	}
	
	public WebElement staticDropDown() {
		return driver.findElement(staticDropDown);
	}
	
	public void checkBox() {
		driver.findElement(checkBox).click();
	}
	
	public void proceedBtnClick() {
		driver.findElement(proceedBtn).click();
	}
	
}
