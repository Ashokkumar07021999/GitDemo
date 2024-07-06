Feature: Seach and place the order for products

@Serachproductandofferspage
Scenario Outline: Search experience for product search in both home and offers page

Given user is on greencart landing page
When user saerched with shortname <Vegetables> and extracted actual name of the product
Then user searched for <Vegetables> same shortname in offers page to check if product exists
And validate product name matches in offers page

Examples:
| Vegetables |
| Tom |
| Beet |