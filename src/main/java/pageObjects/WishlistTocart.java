package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistTocart {
    public WebDriver driver;

    @FindBy(name = "addtocart")
    public WebElement addToCartCheckbox;

    @FindBy(name = "addtocartbutton")
    public WebElement addToCartFromWishlistBtn;

    public WishlistTocart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void moveWishlistToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.elementToBeClickable(addToCartCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartCheckbox);
       
        wait.until(ExpectedConditions.elementToBeClickable(addToCartFromWishlistBtn)).click();
        
        System.out.println("Item successfully moved from Wishlist to Shopping Cart.");
    }
}