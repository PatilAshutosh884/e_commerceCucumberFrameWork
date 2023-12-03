package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPageObject extends BasePage
{
	
	public Logger logger;
	

	public LoginPageObject(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	@FindBy(xpath="//ul//li[2]")
	WebElement loginLink;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailinput;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordinput;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginButton;
	
	
	@FindBy(xpath="//h2[normalize-space()='Welcome to our store']")
	WebElement welcomeMsg;
	
	
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logout;
	
	
	
	
	
	
	
	
	public void clickOn_loginLink() throws InterruptedException
	{
		logger= LogManager.getLogger(this.getClass());
	
		loginLink.click();
	
		Thread.sleep(3000);
	}
	
	
	
	public boolean checkloginButton()
	{
	
	boolean value=loginButton.isDisplayed();
			
	return value;
		
	}
	
	public void checkloginPage()
	{
	
	String title=driver.getTitle();
			
	System.out.println(title);
		
	}
	
	
	
	
	
	public void clickOn_emailinput(String mail)
	{
		emailinput.clear();
		emailinput.sendKeys(mail);
		
	}
	
	public void clickOn_passwordinput(String pass)
	{
		passwordinput.clear();
		passwordinput.sendKeys(pass);
		
	}
	
	public void clickOn_loginButton()
	{
		loginButton.click();
		
	}
	
	public String check_welcomeMsg()
	{
		String msg=welcomeMsg.getText();
		
		return msg;
		
		
	}
	

	
	public void clickOn_logout()
	{
		logout.click();
		
	}
	
	
	
	
	
}
	
	
