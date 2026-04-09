package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {
    public WebDriver driver;

    
    
    @FindBy(linkText = "Jewelry")
    public WebElement Clk_jewell;
    
    @FindBy(xpath = "//a[contains(text(),'Black & White Diamond Heart')]")
    public WebElement Chain;
    
    @FindBy(xpath = "//*[contains(@value,'Add to wishlist')] | //button[contains(text(),'Add to wishlist')]")
    public WebElement AddWishlist;
    
    @FindBy(xpath = "//a[@class='ico-wishlist']")
    public WebElement wishlistLink;

    @FindBy(linkText = "Black & White Diamond Heart")
    public WebElement Jewell_confirmation;


    
    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   

    public void Select_Jewell() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Clk_jewell)).click();
    }
 
    public void Select_chain() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Chain);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Chain);
    }
    
    public void AddtoWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AddWishlist)).click();
    }
    
    
    public void Select_Wishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink)).click();
    }

   
    public void verifyWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        boolean isJewelVisible = wait.until(ExpectedConditions.visibilityOf(Jewell_confirmation)).isDisplayed();
        org.testng.Assert.assertTrue(isJewelVisible, "Jewelry item not found in wishlist!");
        
        String jewelName = Jewell_confirmation.getText();
        System.out.println("Wishlist confirmation successful for item: " + jewelName);
    }
}