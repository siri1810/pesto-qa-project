package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.UUID;

public class ecommerce {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Given("^the user is on the (.+) registration page$")
    public void the_user_is_on_the_registration_page(String website) {
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(website + "signup");
    }

    @When("^the user attempts to register with valid details$")
    public void the_user_attempts_to_register_with_valid_details() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        String uniqueEmail = "testuser_" + UUID.randomUUID().toString() + "@example.com";
        
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameInput.sendKeys("Test User");

        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        emailInput.sendKeys(uniqueEmail);

        WebElement signupButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signupButton.click();

        WebElement passwordInput = driver.findElement(By.cssSelector("input[data-qa='password']"));
        passwordInput.sendKeys("TestPassword123");

        WebElement firstNameInput = driver.findElement(By.cssSelector("input[data-qa='first_name']"));
        firstNameInput.sendKeys("Test");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input[data-qa='last_name']"));
        lastNameInput.sendKeys("User");

        WebElement addressInput = driver.findElement(By.cssSelector("input[data-qa='address']"));
        addressInput.sendKeys("123 Main St");

        new Select(driver.findElement(By.cssSelector("select[data-qa='country']"))).selectByVisibleText("United States");

        WebElement stateInput = driver.findElement(By.cssSelector("input[data-qa='state']"));
        stateInput.sendKeys("SomeState");

        WebElement cityInput = driver.findElement(By.cssSelector("input[data-qa='city']"));
        cityInput.sendKeys("SomeCity");

        WebElement zipcodeInput = driver.findElement(By.cssSelector("input[data-qa='zipcode']"));
        zipcodeInput.sendKeys("12345");

        WebElement mobileNumberInput = driver.findElement(By.cssSelector("input[data-qa='mobile_number']"));
        mobileNumberInput.sendKeys("123-456-7890");

        WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        createAccountButton.click();
    }

    @When("^the user clicks on the continue button$")
    public void the_user_clicks_on_the_continue_button() {
        WebElement continueButton = driver.findElement(By.cssSelector("button[data-qa='continue-button']"));
        continueButton.click();
    }

    @Given("^the user is on the (.+) home page$")
    public void the_user_is_on_the_home_page(String website) {
        driver.get(website);
    }

    @When("^the user searches for \"([^\"]*)\"$")
    public void the_user_searches_for(String product) {
        WebElement searchInput = driver.findElement(By.cssSelector("input[data-qa='search-box']"));
        searchInput.sendKeys(product);
        WebElement searchButton = driver.findElement(By.cssSelector("button[data-qa='search-button']"));
        searchButton.click();
    }

    @When("^the user adds the first result to the cart$")
    public void the_user_adds_the_first_result_to_the_cart() {
        WebElement firstProductAddToCartButton = driver.findElement(By.cssSelector("button[data-qa='add-to-cart-first-product']"));
        firstProductAddToCartButton.click();
    }

    @Then("^the item should be added to the shopping cart$")
    public void the_item_should_be_added_to_the_shopping_cart() {
        WebElement cartCounter = driver.findElement(By.cssSelector("span[data-qa='cart-counter']"));
        Assert.assertTrue("Cart is not empty", cartCounter.getText().equals("1"));
    }

    @Given("^the user has an item in the (.+) shopping cart$")
    public void the_user_has_an_item_in_the_shopping_cart(String website) {
        // Code to ensure there is an item in the shopping cart
        // This could be a combination of the steps above or a direct navigation to a page with an item already in the cart
    }

    @When("^the user proceeds to checkout and completes the purchase$")
    public void the_user_proceeds_to_checkout_and_completes_the_purchase() {
        // Code to navigate to checkout and complete the purchase
        // This would involve filling out payment and shipping details and submitting the order
    }

    @Then("^the purchase confirmation for the item should be displayed$")
    public void the_purchase_confirmation_for_the_item_should_be_displayed() {
        // Code to assert that the purchase confirmation is displayed
        // This could be checking for a specific element or text on the confirmation page
    }

    @Given("^the user has completed orders on (.+)$")
    public void the_user_has_completed_orders_on(String website) {
        // Code to ensure the user has completed orders on the specified website
        // This could be a setup step where you create an order history for the user
    }

    @When("^the user navigates to the order history page$")
    public void the_user_navigates_to_the_order_history_page() {
        // Code to navigate to the order history page
        // This would be finding and clicking on the link or button that takes the user to their order history
    }

    @Then("^the user's past orders should be displayed$")
    public void the_user_s_past_orders_should_be_displayed() {
        // Code to assert that the user's past orders are displayed
        // This could be checking for the presence of order elements or specific order details
    }

    @After
    public void cleanUp() {
        // Check if the driver is not null (initialized) and close it
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Handle any exceptions that may occur during quitting the driver
                e.printStackTrace();
            }
        }
    }
}
