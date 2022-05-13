Feature: Add product into the cart and place order for products

@placeOrder
Scenario Outline: Search Product, add into cart and proceed to checkout

Given User is on GreenKart Landing page
When User searchd with short name <VegName> extracted actual name of product
And User will add <ItemsQty> items of this products in to the cart
And User will verify added vegitable and <ItemsQty> in Cart and he will proceed to checkout
Then user should be able to see same vegitable and <ItemsQty> on checkout page
And Verify Apply promo code and Palce Order button and user should be able to place order


Examples:
| VegName	|	ItemsQty	|
|	Tom			|			4				|
|	Beet		|			5				|