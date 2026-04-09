package pageObjects;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartToOrderPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "ico-cart")
    public WebElement shoppingCartLink;

    @FindBy(id="termsofservice")
    public WebElement Select_Checkbox;
    
    @FindBy(id="checkout")
    public WebElement CheckoutBtn;

    // Checkout Steps
    @FindBy(xpath = "//div[@id='billing-buttons-container']//input[@value='Continue']")
    public WebElement BillingContinue;

    @FindBy(id="PickUpInStore")
    public WebElement InstorePickup;

    @FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@value='Continue']")
    public WebElement ShippingContinue;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']//input[@value='Continue']")
    public WebElement PaymentMethodContinue;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//input[@value='Continue']")
    public WebElement PaymentInfoContinue;

    @FindBy(xpath = "//input[@value='Confirm']")
    public WebElement ConfirmOrderBtn;

    public CartToOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void GoToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public void Confirm_Checkbox() {
        wait.until(ExpectedConditions.elementToBeClickable(Select_Checkbox)).click();
    }
    
    public void Click_Checkout_Button() {
        CheckoutBtn.click();
    }

    public void Process_Billing_Address() {
        wait.until(ExpectedConditions.elementToBeClickable(BillingContinue)).click();
    }

    public void Select_InStore_Pickup() {
      
        WebElement pickUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PickUpInStore")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pickUp);
        driver.findElement(By.xpath("//div[@id='shipping-buttons-container']//input[@value='Continue']")).click();
    }

    public void Finish_Payment_And_Confirm() {
      
        wait.until(ExpectedConditions.elementToBeClickable(PaymentMethodContinue)).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(PaymentInfoContinue)).click();

        wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrderBtn)).click();
        System.out.println("Hurray!!! Order Placed Successfully.");
    }
}