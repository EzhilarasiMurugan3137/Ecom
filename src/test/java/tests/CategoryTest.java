package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.CategoryPage;
import pageObjects.LoginPage;

public class CategoryTest extends BaseClass {

	@Test
	public void Category_Confirmation() 
	{
		LoginPage Lp = new LoginPage(driver);

		Lp.Choose_login();
		Lp.EnterUsername(prop.getProperty("EndUser_Id"));
		Lp.EnterPassword(prop.getProperty("EndUser_Password"));

		Lp.clickLogin();

		CategoryPage Cp = new CategoryPage(driver);
		Cp.Choose_Category();
		Cp.Confirm_selectionCategory();

	}

}
