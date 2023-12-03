package pageObjects;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPageObject extends BasePage
{
	public Logger logger;
	String text;
	String text1;
	String wmsg;
	String wqty;
	public WishListPageObject(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//div[@class=\"page-title\"]")
	WebElement Wishlist;
	

	@FindBy(xpath="//table[@class='cart']//tbody//tr[1]//td[4]")
	WebElement pName;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
	WebElement Remove_Button;
	
	@FindBy(xpath="//div[@class='no-data']")
	WebElement Wishlist_Msg;
	
	@FindBy(xpath="//div[@class='header-links']//ul//li[3]/a/span[2]")
	WebElement Wishlist_qty;
	

	@FindBy(className="ico-logout")
	WebElement logout_icon;
	
	
	
	
	
	public String checkWishlistPage()
	{
		text = Wishlist.getText();
		return text;
		
	}
	
	public String checkHtcMiniblue()
	{
		       text1= pName.getText();
		return text1;
		
	}
	
	public void clickOnRemove_Button()
	{
		Remove_Button.click();
	
	}
	
	public String checkWishlistMsg()
	{
	        wmsg=Wishlist_Msg.getText();
		return wmsg;
	}
	
	public String checkWishlist_qty()
	{
		wqty=Wishlist_qty.getText();
		return wqty;
	}
	
	public void clickOnlogout_icon()
	{
		logout_icon.click();
	
	}
	
}
