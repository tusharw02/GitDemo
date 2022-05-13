Feature: Search and add product to cart

@searchProduct
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenKart Landing page
When User searchd with short name <VegName> extracted actual name of product
Then User search for <VegName> short name on offers page
And Validate product name in offers page matches with lanidng page

Examples:
| VegName	|
|	Tom			|
|	Beet		|