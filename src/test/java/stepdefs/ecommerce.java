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

import java.util.List;
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

    @Given("^the user is on the (.+) home page$")
    public void the_user_is_on_the_home_page(String website) {
        driver.get(website);
    }

    @When("^the user searches for (.+)$")
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
        driver.get(website + "cart");
        WebElement cartCounter = driver.findElement(By.cssSelector("span[data-qa='cart-counter']"));
        Assert.assertTrue("Cart is not empty", !cartCounter.getText().equals("0"));
    }

    @When("^the user proceeds to checkout and completes the purchase$")
    public void the_user_proceeds_to_checkout_and_completes_the_purchase() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-qa='checkout-button']"));
        checkoutButton.click();

        // Example steps for a typical checkout process
        WebElement shippingAddressInput = driver.findElement(By.cssSelector("input[data-qa='shipping-address']"));
        shippingAddressInput.sendKeys("123 Main St");

        WebElement paymentMethodSelect = driver.findElement(By.cssSelector("select[data-qa='payment-method']"));
        Select paymentMethodDropdown = new Select(paymentMethodSelect);
        paymentMethodDropdown.selectByVisibleText("Credit Card");

        WebElement cardNumberInput = driver.findElement(By.cssSelector("input[data-qa='card-number']"));
        cardNumberInput.sendKeys("4111111111111111");

        WebElement confirmPurchaseButton = driver.findElement(By.cssSelector("button[data-qa='confirm-purchase']"));
        confirmPurchaseButton.click();
    }

    @Then("^the purchase confirmation for the item should be displayed$")
    public void the_purchase_confirmation_for_the_item_should_be_displayed() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector("div[data-qa='purchase-confirmation']"));
        Assert.assertTrue("Purchase confirmation is displayed", confirmationMessage.isDisplayed());
    }

    @Given("^the user has completed orders on (.+)$")
    public void the_user_has_completed_orders_on(String website) {
        driver.get(website + "order-history");
        List<WebElement> orders = driver.findElements(By.cssSelector("div[data-qa='order-history-item']"));
        Assert.assertTrue("User has completed orders", !orders.isEmpty());
    }

    @When("^the user navigates to the order history page$")
    public void the_user_navigates_to_the_order_history_page() {
        WebElement orderHistoryLink = driver.findElement(By.cssSelector("a[data-qa='order-history-link']"));
        orderHistoryLink.click();
    }

    @Then("^the user's past orders should be displayed$")
    public void the_user_s_past_orders_should_be_displayed() {
        WebElement ordersTable = driver.findElement(By.cssSelector("table[data-qa='orders-table']"));
        Assert.assertTrue("Orders table is displayed", ordersTable.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    
    }

}
