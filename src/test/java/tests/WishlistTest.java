package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.WishlistPage;

public class WishlistTest extends BaseClass
{

	@Test
	public void Wishlist_check() 
	{
		LoginPage Lp = new LoginPage(driver);

		Lp.Choose_login();
		Lp.EnterUsername(prop.getProperty("EndUser_Id"));
		Lp.EnterPassword(prop.getProperty("EndUser_Password"));

		Lp.clickLogin();
		
		WishlistPage Wp = new WishlistPage(driver);
		Wp.Select_Jewell();
		Wp.Select_chain();
		Wp.AddtoWishlist();
		Wp.Select_Wishlist();
		Wp.verifyWishlist();
	}
}
