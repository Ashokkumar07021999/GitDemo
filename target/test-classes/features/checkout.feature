Feature: place the order for products

@placingorder
Scenario Outline: Search experience for product search in both home and offers page

Given user is on greencart landing page
When user saerched with shortname <Vegetables> and extracted actual name of the product
Then added "3" items to the selected product to the cart
Then user proceeds to cehckout and validate the <Vegetables> items in the checkout page
And verify user has ability to enter the promo code and place the order

Examples:
| Vegetables |
| Tomato |
