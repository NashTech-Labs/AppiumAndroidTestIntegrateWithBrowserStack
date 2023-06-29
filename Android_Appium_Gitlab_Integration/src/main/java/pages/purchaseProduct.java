package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.LaunchEmulator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class purchaseProduct extends LaunchEmulator {
    WebDriverWait wait;
    By TestUserName = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By TestUserPassword = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public purchaseProduct(AndroidDriver driver) {
        LaunchEmulator.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loginUser(String userName, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestUserName));
        LaunchEmulator.driver.findElement(TestUserName).sendKeys(userName);
        LaunchEmulator.driver.findElement(TestUserPassword).sendKeys(password);
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }


    public void scrollDown() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * .6);
        int endYCoordinate = (int) (height * .2);
        action.press(PointOption.point(middleOfX, startYCoordinate)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    public void isLoginButtonDisplay() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

}