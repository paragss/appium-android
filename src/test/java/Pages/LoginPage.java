package Pages;

import StepDefinition.BaseTest;
import Utility.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    HelperMethods helperMethods;
    AppiumDriver driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='standard_user']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='IntegerA']")
    WebElement standardUser;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='locked_out_user']")
    WebElement lockedUser;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOGIN']")
    WebElement loginBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    WebElement productTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sorry, this user has been locked out.']")
    WebElement errorContent;
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickStandardUserLink()  {
        logger.info("Clicking on standard user");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(standardUser));
        standardUser.click();
        logger.info("Label attribute " + standardUser.getAttribute("label"));
        logger.info("Clicked on standard user");

    }

    public void clickLockedUserLink()  {
        logger.info("Clicking on locked user");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(lockedUser));
        lockedUser.click();
        logger.info("Clicked on locked user");
    }

    public void clickLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
        logger.info("Clicked on login button");
    }

    public String validateTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public String validateErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
        wait.until(ExpectedConditions.visibilityOf(errorContent));
        return errorContent.getText();
    }

}
