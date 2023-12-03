package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HTCOneMiniBluePageObject extends BasePage
{
	public Logger logger;

	public HTCOneMiniBluePageObject(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//div[@class='details']//h2//a")
	WebElement HTC;
	
	@FindBy(xpath="//button [@class='button-2 add-to-wishlist-button']")
	WebElement WishList_Button;
	
	@FindBy(className="wishlist-label")
	WebElement WishList_lable;
	
	

	
	public String checkHtcOneMiniBluePage()
	{
		String text= HTC.getText();
		
		return text;
		
		
	}
	
	public void clickOnWishList_Button() throws InterruptedException
	{
		WishList_Button.click();
	
		System.out.println("Wishlist Button has clicked");
	
	}
	
	public void clickOnWishListLink_lable()
	{
		WishList_lable.click();
	
	}
	
	
			
			
			
			
}

