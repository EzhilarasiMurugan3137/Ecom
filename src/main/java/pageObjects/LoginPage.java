package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	public WebDriver driver;
	
	
	@FindBy(linkText = "Log in")
	public WebElement loginbtn;
	
	@FindBy(id="Email")
	public WebElement TxtEmail;
	
	@FindBy(id="Password")
	public WebElement Password;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	public WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	public WebElement Logout;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Choose_login() 
	{
		loginbtn.click();
	}
	public void EnterUsername(String Email) 
	{
		TxtEmail.sendKeys(Email);
	}
	
	public void EnterPassword(String Pword) 
	{
		Password.sendKeys(Pword);
}

	public void clickLogin() {
	    loginBtn.click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Logout));
		
		if(Logout.isDisplayed()) {
		System.out.println("Hurray!!! Login is completed");
		}
	}
}
