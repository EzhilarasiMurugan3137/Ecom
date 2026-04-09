package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddtoCartPage;
import pageObjects.LoginPage;

public class AddToCartTest extends BaseClass
{
	@Test
	public void Check_Cart() 

	{
		LoginPage Lp = new LoginPage(driver);

		Lp.Choose_login();
		Lp.EnterUsername(prop.getProperty("EndUser_Id"));
		Lp.EnterPassword(prop.getProperty("EndUser_Password"));

		Lp.clickLogin();
		
		AddtoCartPage  Ap = new AddtoCartPage(driver);
		Ap.Click_Computers();
		Ap.Click_Notebooks();
		Ap.Choose_Product();
		Ap.addToCart();
		Ap.goToCart();
		Ap.getProductQuantity();
	}

}
