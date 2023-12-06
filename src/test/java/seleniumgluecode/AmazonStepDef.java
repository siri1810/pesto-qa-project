package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonStepDef {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the {string} registration page")
    public void the_user_is_on_the_registration_page(String website) {
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(website + "/register"); // Adjust this based on the website's registration page URL pattern
    }

    @When("the user attempts to register with valid details")
    public void the_user_attempts_to_register_with_valid_details() {
        // Locate the email input field and enter a valid email address
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("valid@example.com");

        // Locate the password input field and enter a valid password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("validPassword");

        // Locate the submit button and click it to submit the form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }


    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        // Wait for the success message to be visible and then check its text
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));
        assert successMessage.getText().contains("Registration successful");
    }

    @Given("the user is on the {string} homepage")
    public void the_user_is_on_the_homepage(String website) {
        // Navigate to the given website's homepage
        driver.get(website);
    }


    @When("the user searches for {string}")
    public void the_user_searches_for(String product) {
        // Locate the search input field, enter the product name, and submit the search
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys(product);

        // Locate the search button and click it to initiate the search
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @Then("the search results should be displayed")
    public void the_search_results_should_be_displayed() {
        // Wait for the search results to be visible and then check that they are displayed
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        assert results.isDisplayed();
    }


    @Given("the user searches for {string} on {string}")
    public void the_user_searches_for_on(String product, String website) {
        the_user_is_on_the_homepage(website);
        the_user_searches_for(product);
    }

    @When("the user adds the first result to the cart")
    public void the_user_adds_the_first_result_to_the_cart() {
        // Locate the "Add to Cart" button for the first search result and click it
        WebElement firstResultAddButton = driver.findElement(By.cssSelector("#results .item:first-child .add-to-cart"));
        firstResultAddButton.click();
    }

    @Then("the item should be added to the shopping cart")
    public void the_item_should_be_added_to_the_shopping_cart() {
        // Wait for the cart count to be visible and then verify that it indicates one item in the cart
        WebElement cartCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-count")));
        assert cartCount.getText().equals("1");
    }


    @Given("the user has an item in the {string} shopping cart")
    public void the_user_has_an_item_in_the_shopping_cart(String website) {
        the_user_searches_for_on("Selenium WebDriver", website);
        the_user_adds_the_first_result_to_the_cart();
    }

    @When("the user proceeds to checkout and completes the purchase")
    public void the_user_proceeds_to_checkout_and_completes_the_purchase() {
        // Locate the checkout button and click it to proceed to the checkout page
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        // Locate the button to complete the purchase and click it
        WebElement completePurchaseButton = driver.findElement(By.id("completePurchase"));
        completePurchaseButton.click();
    }

    @Then("the purchase confirmation for the item should be displayed")
    public void the_purchase_confirmation_for_the_item_should_be_displayed() {
        // Wait for the purchase confirmation message to be visible and then verify its text
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
        assert confirmationMessage.getText().contains("Purchase complete");
    }

    @Given("the user has completed orders on {string}")
    public void the_user_has_completed_orders_on(String website) {
        // Implement steps to ensure the user has completed orders
        // This might involve logging into the user's account and checking the order history
        // As this is a precondition, it might need to be set up manually or through other automated steps
    	 WebElement orderHistoryLink = driver.findElement(By.id("orderHistory"));
    	    orderHistoryLink.click();

    	    // Verify that there are completed orders
    	    // Replace 'ordersList' with the actual ID or selector for the list of completed orders
    	  WebElement ordersList = driver.findElement(By.id("ordersList"));
    	  assert ordersList.isDisplayed(); // Verify that the orders list is displayed
    	
    }


    @When("the user navigates to the order history page")
    public void the_user_navigates_to_the_order_history_page() {
        // Implement navigation to the order history page
        // Example:
        WebElement orderHistoryLink = driver.findElement(By.id("orderHistory"));
        orderHistoryLink.click();
    }


    @Then("the user's past orders should be displayed")
    public void the_user_s_past_orders_should_be_displayed() {
        // Wait for the list of orders to be visible and then verify that it is displayed
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders")));
        assert ordersList.isDisplayed();
    }

    // Close the browser after each scenario
    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
