package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);
    AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")
    WebElement listViewIcon;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='+'])[1]")
    WebElement listViewPlusIcon;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
    WebElement addtoCart;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    WebElement cartIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    WebElement cartTitle;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='1'])[2]")
    WebElement cartQuantity;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='CHECKOUT'])")
    WebElement checkoutBtn;


    public ProductsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickSwitchViewIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(listViewIcon));
        listViewIcon.click();
    }

    public void validateListViewIconAvailable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(listViewPlusIcon));
        listViewPlusIcon.isDisplayed();
    }
    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(addtoCart));
        addtoCart.click();
        logger.info("clicked add to cart");
    }

    public void clickCartIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
        logger.info("clicked cart icon");
    }

    public String validateItemAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(cartQuantity));
        return cartQuantity.getText();
    }
    public void clickChekcoutBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
        logger.info("clicked checkout button");
    }

}
