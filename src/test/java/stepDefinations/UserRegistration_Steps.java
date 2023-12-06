package stepDefinations;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import hooks.MyHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterationPageObject;
import utilities.DataReader;


public class UserRegistration_Steps
{
	WebDriver driver;
	Logger logger;
	RegisterationPageObject rpo;
	
	List<HashMap<String,String>> datamap;
	
	
	
	
	
		   

   	@Given("User Opening URL {string}")
   	public void user_opening_url(String url)
   	{
   		
   		logger= MyHooks.logger;
   		driver=MyHooks.driver;
   	System.out.println("User Openeing URL()");
   	logger.info("Opening URl");
   		
   		driver.get(url);
   		driver.manage().window().maximize();
   	System.out.println("URL opened suscessfully");
   	}
   	
		
	@When("check for Registration Page")
	public void check_for_registration_page() 
	{
logger.info("check for Registration Page");
System.out.println("checke for registartion page()");
		 rpo = new RegisterationPageObject(driver);
		 boolean rslt=rpo.checkLogoPresence();
		 
		 if(rslt==true)
		 {
			 Assert.assertTrue(true, "Registration Page is Displaying");
                 logger.info("Displaying Registration Page"); 
		 }
		 else
		 {
			 Assert.assertTrue(false, "Registration Page is not Displaying");
			     logger.info("*****Error==>Not Displaying Registration Page*****"); 
 
		 }
		 logger.info("check for Registration Page Done"); 
	}

	
	@Then("complete registration by Filling out the Registration form Using Excel data\"{int}\"")
	public void complete_registration_by_filling_out_the_registration_form_using_excel_data(Integer int1)
	{
		datamap= DataReader.data(System.getProperty("user.dir")+"\\testData\\NOPRegistrationData.xlsx","Sheet1");
	    int index=int1-1;
	    String _gender = datamap.get(index).get("gender");
	    String f_name = datamap.get(index).get("fname");
	    String l_name = datamap.get(index).get("lname");
	    String _day = datamap.get(index).get("day");
	    String _month = datamap.get(index).get("month");
	    String _year = datamap.get(index).get("year");
	    String e_mail = datamap.get(index).get("email");
	    String _pass = datamap.get(index).get("password");
	
	    
	   try {  
		rpo = new RegisterationPageObject(driver); 
		
	    rpo.select_Gender(_gender);
	    System.out.println("Gender is:"+_gender);
		rpo.set_FirstName(f_name);
		rpo.set_LastName(l_name);
		rpo.clickOn_Day(_day);
		rpo.clickOn_Month(_month);
		rpo.clickOn_Year(_year);
		rpo.set_Email(e_mail);
		rpo.set_Password(_pass);
		rpo.set_ConfirmPassword(_pass);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	    
logger.info("Registration form completed"); 


try {
		rpo.clickOn_RegisterButton();
		String act_rslt=rpo.register_result();
		String exp_rslt="Your registration completed";
		
		
		if(act_rslt.equals(exp_rslt))
		{
		Assert.assertTrue(true);
		
		logger.info("User Registarion Successfull"); 
		
		}
		else
		{
		Assert.assertTrue(false);
		
		logger.info("****User Registation Failed****"); 
		
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		Assert.fail();
		
		logger.info("*****Something Went Wrong while Checking Registartion Confirmation msg****"); 
		
		}


	    
}
}

