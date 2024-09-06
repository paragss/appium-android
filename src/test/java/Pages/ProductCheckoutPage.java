package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.Synchronized;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class ProductCheckoutPage {
    private static final Logger logger = LogManager.getLogger(ProductCheckoutPage.class);
    AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    WebElement firstName;
    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc='test-Last Name'])")
    WebElement  lastName;
    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc='test-Zip/Postal Code'])")
    WebElement zipCode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    WebElement continueBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    WebElement finishBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    WebElement orderConfirmation;


    public  ProductCheckoutPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("parag");
        logger.info("Entered first name");

    }

    public void enterLastname(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys("dwivedi");
        logger.info("Entered last name");
    }
    public void enterZipcode(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(zipCode));
        zipCode.sendKeys("452016");
        logger.info("Entered zipcode");
    }

    public void clickContinueBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
        logger.info("clicked continue button");
    }


    public String validateOrderIsConfirmed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(orderConfirmation));
        return orderConfirmation.getText();
    }
    public void swipeDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //android.widget.TextView[@text='CHECKOUT: OVERVIEW']")));
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 470, 1821))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 536, 669))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
      wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
        logger.info("clicked finish button");

    }





}
