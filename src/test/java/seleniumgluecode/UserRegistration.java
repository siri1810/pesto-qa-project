//package seleniumgluecode;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class UserRegistration {
//    WebDriver driver;
//
//    @Given("the user is on the Amazon.in homepage")
//    public void the_user_is_on_the_Amazon_in_homepage() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.amazon.in");
//    }
//
//    @When("the user clicks on the sign-in button")
//    public void the_user_clicks_on_the_sign_in_button() {
//        WebDriverWait wait = new WebDriverWait(driver, 10); // wait for a maximum of 10 seconds
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList"))).click();    	
////        driver.findElement(By.id("nav-link-accountList")).click();
//    }
//
//    @Then("the user should be directed to the sign-in page")
//    public void the_user_should_be_directed_to_the_sign_in_page() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
//    }
//
//    @When("the user clicks on the create your Amazon account button")
//    public void the_user_clicks_on_the_create_your_amazon_account_button() {
//        driver.findElement(By.id("createAccountSubmit")).click();
//    }
//
//    @Then("the user should see the registration form")
//    public void the_user_should_see_the_registration_form() {
//        Assert.assertTrue(driver.findElement(By.id("ap_register_form")).isDisplayed());
//    }
//
//    // Placeholder step for educational purposes only
//    @When("the user enters a new valid email, password, and name")
//    public void the_user_enters_a_new_valid_email_password_and_name() {
//        // Code to enter email, password, and name
//    }
//
//    // Placeholder step for educational purposes only
//    @When("the user submits the registration form")
//    public void the_user_submits_the_registration_form() {
//        // Code to submit the form
//    }
//
//    // Placeholder step for educational purposes only
//    @Then("the user should be asked for OTP verification")
//    public void the_user_should_be_asked_for_otp_verification() {
//        // Code to handle OTP verification
//    }
//
//    // Placeholder step for educational purposes only
//    @When("the user enters an email that is already in use")
//    public void the_user_enters_an_email_that_is_already_in_use() {
//        // Code to enter an already used email
//    }
//
//    // Placeholder step for educational purposes only
//    @Then("the user should see an error message about the email already in use")
//    public void the_user_should_see_an_error_message_about_the_email_already_in_use() {
//        // Code to verify the error message
//    }
//
//    @io.cucumber.java.After
//    public void tearDown() {
//        driver.quit();
//    }
//}
