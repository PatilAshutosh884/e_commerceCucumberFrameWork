package pageObjects;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePageObject extends BasePage
{
public Logger logger;
	public HomePageObject(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	
	@FindBy(className="ico-register")
	WebElement RegisterLink_Icon;
	
	@FindBy(xpath="//input[@id='small-searchterms']")
	WebElement SearchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SearchButton;
	
	@FindBy(xpath="//div[@class=\"header-links\"]//li[3]/a")
	WebElement Wishlist_iconLink;
	
	
	
	
	

	public void clickOnRegisterLink_Icon()
	{
		RegisterLink_Icon.click();
	
	}
	
	public void clickOnSearchBox(String productName)
	{
		SearchBox.clear();
		SearchBox.sendKeys(productName);
	
	}
	
	public void clickOnSearchButton()
	{
		SearchButton.click();
	
	}
	
	public void clickOnWishList_iconlink()
	{
		Wishlist_iconLink.click();
	
	}
	

}


