package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchPage {
	public WebDriver driver;

	@FindBy(id = "small-searchterms")
	public WebElement SearchBx;

	@FindBy(xpath = "//input[@class=\'button-1 search-box-button\']")
	public WebElement SearchBx_btn;

	@FindBy(xpath = "//input[@class=\'button-1 search-button\']")
	public WebElement Searchbtn;
	
	@FindBy(xpath="//a[text()='Computing and Internet']")
	public WebElement SelectProduct;

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterSearch_Criteria(String searchCategory) {
		SearchBx.sendKeys(searchCategory);
	}

	public void Click_SearchBoxBtn() 
	{
		SearchBx_btn.click();

	}

	public void SearchBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Searchbtn));
		Searchbtn.click();
	}
	
	public void SelectProduct() 
	{
        if(SelectProduct.isDisplayed()) 
        {
        System.out.println("Search result is completed!!!");	
        }
	}

}
