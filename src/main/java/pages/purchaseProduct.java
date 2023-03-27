package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.LaunchEmulator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class purchaseProduct extends LaunchEmulator {
    WebDriverWait wait;
    By TestUserName = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By TestUserPassword = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By clickOnLoginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    By selectProduct = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]");
    By capturePrice = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
    By AddToCart = By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]");
    By clickOnCart = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    By ProductName = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    By ClickOnCheckout = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");
    By AddFirstName = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By AddLastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By AddZipcode = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By ClickOnContinue = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView");
    By ClickOnFinish = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView");
    By GetMessage = By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
    By productDetails = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");

    public purchaseProduct(AndroidDriver driver) {
        LaunchEmulator.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void LoginUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestUserName));
        LaunchEmulator.driver.findElement(TestUserName).sendKeys("standard_user");
        LaunchEmulator.driver.findElement(TestUserPassword).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnLoginButton)).click();
    }

    public void selectProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectProduct)).click();

    }

    public void GetProductDetails() {
        String ProductName = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).getText();
        System.out.printf("Product Name is: " + ProductName);
//        String GetProductPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(capturePrice)).getText();
//        System.out.printf("Price of product is:" + GetProductPrice);
    }

    public void AddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCart)).click();
    }

    public void scrollDown() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * .6);
        int endYCoordinate = (int) (height * .2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    public void GoToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCart)).click();
        String ProductNameFromCart = driver.findElement(ProductName).getText();
        Assert.assertEquals(ProductNameFromCart, "Sauce Labs Backpack");
    }

    public void ClickOnCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnCheckout));
        driver.findElement(ClickOnCheckout).click();
    }

    public void AddCustomerDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddFirstName)).sendKeys("standard_user");
        driver.findElement(AddLastName).sendKeys("TestUserLastName");
        driver.findElement(AddZipcode).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnContinue)).click();

    }

    public void GetConformationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnFinish)).click();
        String GetConformationMessage = wait.until(ExpectedConditions.elementToBeClickable(GetMessage)).getText();
        Assert.assertEquals(GetConformationMessage, "THANK YOU FOR YOU ORDER");
        System.out.printf(GetConformationMessage);
    }

}