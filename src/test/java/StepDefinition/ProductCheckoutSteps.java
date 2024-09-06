package StepDefinition;

import Pages.LoginPage;
import Pages.ProductCheckoutPage;
import Pages.ProductsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class ProductCheckoutSteps {
    private static final Logger logger = LogManager.getLogger(ProductCheckoutSteps.class);
    static AppiumDriver driver;
    ProductCheckoutPage productCheckoutPage;
   public ProductCheckoutSteps(){

    }
    public ProductCheckoutSteps(AppiumDriver driver){
        this.driver = driver;
    }

    @And("I enter firstname, lastname and zipcode")
    public void iEnterFirstnameLastnameAndZipcode() {
        productCheckoutPage = new ProductCheckoutPage(driver);
        productCheckoutPage.enterFirstName();
        productCheckoutPage.enterLastname();
        productCheckoutPage.enterZipcode();
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        productCheckoutPage.clickContinueBtn();
    }

    @When("i click on finish")
    public void iClickOnFinish() {
        productCheckoutPage.swipeDown();
    }

    @Then("order confirmation page should appear")
    public void orderConfirmationPageShouldAppear() {
       Assert.assertEquals(productCheckoutPage.validateOrderIsConfirmed(), "THANK YOU FOR YOU ORDER");
    }
}
