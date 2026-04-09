package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPage {
	public WebDriver driver;

	@FindBy(linkText = "Computers")
	public WebElement SelectComputer;

	@FindBy(linkText = "Notebooks")
	public WebElement SelectNotebook;

	@FindBy(xpath = "//div[@class='product-item']//a[contains(text(),'14.1-inch Laptop')]")
	public WebElement laptopProduct;

	// Change this at the top of your AddtoCartPage class
	@FindBy(xpath = "//input[@value='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCartLink;

	@FindBy(className = "qty-input") // Standard class for quantity in this shop
	WebElement quantityInput;
	
	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Click_Computers() {
		SelectComputer.click();
	}

	public void Click_Notebooks() {
		SelectNotebook.click();

	}

	public void Choose_Product() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(laptopProduct));
		laptopProduct.click();
	}

	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn)).click();
	}

	public void goToCart() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
	    System.out.println("You're on the cart!!!");
	}

	public String getProductQuantity() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    String actualQty = wait.until(ExpectedConditions.visibilityOf(quantityInput)).getAttribute("value");
	    org.testng.Assert.assertEquals(actualQty, "1", "Quantity confirmation failed!");
	    
	    // 3. Print success message
	    System.out.println("Quantity confirmation successful: " + actualQty);
	    
	    return actualQty;
	}
	
}
