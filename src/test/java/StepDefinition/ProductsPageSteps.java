package StepDefinition;

import Pages.LoginPage;
import Pages.ProductsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class ProductsPageSteps  {
    private static final Logger logger = LogManager.getLogger(ProductsPageSteps.class);
    static AppiumDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
   public ProductsPageSteps(){

    }
    public ProductsPageSteps(AppiumDriver driver){
        this.driver = driver;
    }

    @Given("user is logged into application")
    public void userIsLoggedIntoApplication() {
        loginPage = new LoginPage(driver);
        loginPage.clickStandardUserLink();
        loginPage.clickLoginBtn();
        String pageTitle = loginPage.validateTitle();
        Assert.assertEquals(pageTitle, "PRODUCTS");

    }

    @When("I click on list view")
    public void i_click_on_list_view() {
        productsPage = new ProductsPage(driver);
        productsPage.clickSwitchViewIcon();
        System.out.println("I am in products");
    }

    @Then("products should be displayed in a list")
    public void products_should_be_displayed_in_a_list() {
        productsPage.validateListViewIconAvailable();

    }

    @When("I click on Add to cart button")
    public void I_click_on_Add_to_cart_button() {
        productsPage = new ProductsPage(driver);
        productsPage.clickAddToCart();
    }

    @And("click on cart icon")
    public void clickOnCartIcon() {
       productsPage.clickCartIcon();
    }

    @Then("product should be added to cart")
    public void products_should_be_added_to_cart() {
        Assert.assertEquals(productsPage.validateItemAddedToCart(), "1");

    }


    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
       productsPage.clickChekcoutBtn();
    }
}
