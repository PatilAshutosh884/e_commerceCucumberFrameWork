package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		System.out.println("Controll reach to the BasePage");
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
}
