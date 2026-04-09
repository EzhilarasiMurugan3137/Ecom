package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.WishlistPage;
import pageObjects.WishlistTocart;

public class WishlistTocartTest extends BaseClass
{
	
	@Test
	public void Validate_WishlistTocart() 
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
		
		WishlistTocart Wc = new WishlistTocart(driver);
		Wc.moveWishlistToCart();
	}

}
