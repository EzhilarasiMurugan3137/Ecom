package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass 
{
	
	@Test
	public void Check_valid_Login() 
	{
		LoginPage Lp = new LoginPage(driver);
		
		Lp.Choose_login();
		Lp.EnterUsername(prop.getProperty("EndUser_Id"));
		Lp.EnterPassword(prop.getProperty("EndUser_Password"));
		
		Lp.clickLogin();
		
	}

}
