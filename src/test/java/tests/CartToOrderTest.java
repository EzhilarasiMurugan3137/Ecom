package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pageObjects.CartToOrderPage;
import pageObjects.LoginPage;
import pageObjects.WishlistPage;
import pageObjects.WishlistTocart;

@Listeners(utils.MyListenerClass.class)
public class CartToOrderTest extends BaseClass {
	
    @Test
    public void ConfirmTheOrder() {
        
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
        
        CartToOrderPage Cop = new CartToOrderPage(driver);
        Cop.GoToCart(); 
        Cop.Confirm_Checkbox();
        Cop.Click_Checkout_Button(); 
        Cop.Process_Billing_Address(); 
        Cop.Select_InStore_Pickup();
        Cop.Finish_Payment_And_Confirm();
      
    }
}