package StepDefinition;

import Pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class LoginSteps extends  BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    LoginPage loginPage;
    public static AppiumDriver driver;
    ProductsPageSteps productsPageSteps;
    ProductCheckoutSteps productCheckoutSteps;

    @Before
    public void getSetup() throws IOException {
        driver = super.setup();
        productsPageSteps = new ProductsPageSteps(driver);
        productCheckoutSteps = new ProductCheckoutSteps(driver);
    }

    @Given("application is launched")
    public void applicationIsLaunched() {
            loginPage = new LoginPage(driver);
        }

    @When("I select the standard user for login")
    public void i_select_the_standard_user_for_login() throws InterruptedException {
        loginPage.clickStandardUserLink();

    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String pageTitle = loginPage.validateTitle();
        Assert.assertEquals(pageTitle, "PRODUCTS");
    }

    @When("I select the locked user for login")
    public void i_select_the_locked_user_for_login() throws InterruptedException {
      loginPage.clickLockedUserLink();
    }

    @Then("I should get error for locked user")
    public void i_should_get_error_for_locked_user() {
    Assert.assertEquals(loginPage.validateErrorMessage(), "Sorry, this user has been locked out.");

    }

    @AfterStep
    public void addScreenshot(Scenario scenario){

        //validate if scenario has failed
        if(scenario.isFailed()) {
            logger.info("Step failed. Takeing screenshot");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }

    @After
    public void quitDriver() throws IOException {
        super.clean();
    }



}
