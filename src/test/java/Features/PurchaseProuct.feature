Feature: Purchase Item


  @AddToCart
  Scenario: User add a product into cart
    Given user Login with standard credentials and navigates to homepage
    When Select a product
    Then click on add to cart button to add the product into cart

  @Checkout
  Scenario: checkout the product from cart
    Given click on checkout button to continue the purchase process
    When add the customer detail
    Then click on finish button and get the conformation message