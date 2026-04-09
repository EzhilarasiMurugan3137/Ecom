package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage 
{
	public WebDriver driver;
	  
	  @FindBy(linkText = "Books")
	  public WebElement SelectBook;
	  
	  @FindBy(xpath="//a[text()='Fiction']")
	  public WebElement SelectProduct;
	  
	  public CategoryPage(WebDriver driver) 
	  	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}

	  public void Choose_Category() 
	  {
		  SelectBook.click();  
	  }
	  
	  public void Confirm_selectionCategory() 
	  {
		  if(SelectProduct.isDisplayed()) 
		  {
			  System.out.println("Category selection is completed!!");
		  }
		  
	  }

}
