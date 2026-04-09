package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseClass
{
	@Test
	public void Registration() 
	{
		RegisterPage Rp = new RegisterPage(driver);
		Rp.selectRegister();
		Rp.SelectGender();
		Rp.EnterFirstName("Reena");
		Rp.EnterLastName("Vijay");
		String uniqueEmail = "reena" + System.currentTimeMillis() + "@gmail.com";
		Rp.EnterEmail(uniqueEmail);
		System.out.println(uniqueEmail);
		Rp.EnterPassword("Reena234");
		Rp.reEnterPassword("Reena234");
		Rp.ConfirmRegistration();
		
	}
}
