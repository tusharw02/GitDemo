package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import PageObjects.CheckoutPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.TestContextSetup;

public class CheckoutPageStepDefinitions {

	TestContextSetup contextSetup;
	CheckoutPageObjects checkPage;
	String cartProdName;
	String cartProQty;
	String checkoutPageProdName;
	String checkoutPageProdQty;
	
	
	public CheckoutPageStepDefinitions(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
		this.checkPage = contextSetup.pageObjManager.getCheckoutPage();
	}
	
	

    @And("^User will verify added vegitable and (.+) in Cart and he will proceed to checkout$")
    public void user_will_veriy_added_vegitable_and_qty_in_cart_and_he_will_proceed_to_checkout(int itemsqty) throws Throwable {
        
    	checkPage.cartClick();
    	cartProdName = checkPage.getCartProductName().split("-")[0].trim();
    	cartProQty = checkPage.getCartProductQty().split(" ")[0].trim();
    	
    	if(contextSetup.landingPageProductName.equalsIgnoreCase(cartProdName)) {
    		
    		System.out.println("Product name are matching from Landing page and cart");
    		
    		if(itemsqty==Integer.parseInt(cartProQty)) {
    			System.out.println("Product quantity are matching from Landing page and cart");
    		}else {
    			System.out.println("Product quantity are not matching from Landing page and cart");
    		}
    	}else {
    		System.out.println("Product name are not matching from Landing page and cart");
    	}
    	
    	Assert.assertEquals(contextSetup.landingPageProductName,cartProdName);
    	Assert.assertEquals(itemsqty, Integer.parseInt(cartProQty));
    	checkPage.proceedToCheckoutBtnClick();
    	Thread.sleep(1000);
    	
    }
    
    @Then("^user should be able to see same vegitable and (.+) on checkout page$")
    public void user_should_be_able_to_see_same_and_on_checkout_page(int itemsqty) throws Throwable {
		
    	Thread.sleep(1000);
    	checkoutPageProdName = checkPage.getCheckoutProdtName().split("-")[0].trim(); 
    	checkoutPageProdQty = checkPage.getCheckoutProdQty();
    	
    	if(contextSetup.landingPageProductName.equalsIgnoreCase(checkoutPageProdName)) {
    		
    		System.out.println("Product name are matching from Landing page and checkout page");
    		
    		if(itemsqty == Integer.parseInt(checkoutPageProdQty)) {
    			System.out.println("Product quantity are matching from Landing page and checkout page");
    		}else {
    			System.out.println("Product quantity are not matching from Landing page and checkout page");
    		}
    	}else {
    		System.out.println("Product name are not matching from Landing page and checkout page");
    	}
    	
    	Assert.assertEquals(contextSetup.landingPageProductName,checkoutPageProdName);
    	Assert.assertEquals(itemsqty, Integer.parseInt(checkoutPageProdQty));
    }
    
    @And("Verify Apply promo code and Palce Order button and user should be able to place order")
    public void verify_Apply_promo_code_and_Palce_Order_button_and_user_should_be_able_to_place_order() throws InterruptedException {
    	Assert.assertTrue(checkPage.promoBtnIsDisplayed());
    	Assert.assertTrue(checkPage.plcaeOrderBtnIsDisplayed());
    	if(checkPage.plcaeOrderBtnIsDisplayed()==true) {
    		checkPage.plcaeOrderBtnclick();
    	}
    	
    	Select s = new Select(checkPage.staticDropDown());
    	s.selectByVisibleText("India");
    	checkPage.checkBox();
    	checkPage.proceedBtnClick();
    	Thread.sleep(1000);
    	
    }
	
}
