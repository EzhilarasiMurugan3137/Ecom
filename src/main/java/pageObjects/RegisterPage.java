package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage 
{
	public static WebDriver driver;
	
	@FindBy(linkText = "Register")
	public WebElement Clk_Register;
	
	@FindBy(id="gender-female")
	public WebElement Gender;
	
	@FindBy(id="FirstName")
	public WebElement Firstname;
	
	
	@FindBy(id="LastName")
	public WebElement Lastname;
	
	@FindBy(id="Email")
	public WebElement txt_Email;
	
	
	@FindBy(id="Password")
	public WebElement txtPassword;
	
	
	@FindBy(id="ConfirmPassword")
	public WebElement Reconfirm_Password;
	

	@FindBy(id="register-button")
	public WebElement RegisterBtn;
	
	@FindBy(linkText = "Log out")
	public WebElement Logout;
	
	public  RegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectRegister() 
	{
		Clk_Register.click();
	}
	
	public void SelectGender() 
	{
		Gender.click();
	}
	public void EnterFirstName(String Fname) 
	{
		Firstname.sendKeys(Fname);
	}
	
	public void EnterLastName(String Lname) 
	{
		Lastname.sendKeys(Lname);
	}
	
	public void EnterEmail(String TxtEmail) 
	{
		txt_Email.sendKeys(TxtEmail);
	}
	
	public void EnterPassword(String Pword) 
	{
		txtPassword.sendKeys(Pword);
	}
	
	public void reEnterPassword(String RePWord) 
	{
		Reconfirm_Password.sendKeys(RePWord);
	}
	
	public void ConfirmRegistration() 
	{
		RegisterBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Logout));
		
		if(Logout.isDisplayed()) {
		System.out.println("Hurray!!! Registration is completed");
		}
		
	}

}
