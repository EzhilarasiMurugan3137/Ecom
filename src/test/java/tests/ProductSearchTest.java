package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;

public class ProductSearchTest extends BaseClass
{

	@Test
	public void ProductSearch_Confirmation() 
	{
        LoginPage Lp = new LoginPage(driver);
		
		Lp.Choose_login();
		Lp.EnterUsername(prop.getProperty("EndUser_Id"));
		Lp.EnterPassword(prop.getProperty("EndUser_Password"));
		Lp.clickLogin();
		
		
		ProductSearchPage Ps = new ProductSearchPage(driver);
		Ps.EnterSearch_Criteria("Computing and internet");
		Ps.Click_SearchBoxBtn();
		Ps.SearchBtn();
		Ps.SelectProduct();
	}
}
