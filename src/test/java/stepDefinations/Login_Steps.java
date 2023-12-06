package stepDefinations;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hooks.MyHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObject;
import utilities.DataReader;



public class Login_Steps 
{
	
	WebDriver driver;
	Logger logger;
	
	LoginPageObject lpo;
	
	List<HashMap<String,String>> datamap;
	
	
	
	
    
    
    @Given("Opening URL {string}")
	public void opening_url(String url)
	{
    logger= MyHooks.logger;
    driver=MyHooks.driver;
		

	try {
		driver.get(url);
		driver.manage().window().maximize();
logger.info("URl Opened");
		}
		catch(Exception e)
		{
logger.info("URl failed to Opened");
			e.printStackTrace();
			
		}
	    
	}
   


	@When("Navigate to Login Page by clicking on log in link")
	public void navigate_to_login_page_by_clicking_on_log_in_link() 
	{
		
try {
			
	    lpo=new LoginPageObject(this.driver);
		lpo.clickOn_loginLink();
			
	} 
    catch (InterruptedException e) 
	  {
    	logger.info("Failed to click on Login-link");
			e.printStackTrace();
			
	  }
        logger.info("Clicked on Login link ");
	}

	
	@When("check for log in Page")
	public void check_for_log_in_page()
	{
		
		 logger.info("checking Login Page");
	     
	     
		    boolean value=lpo.checkloginButton();
		    if(value==true)
		    {
		    	
		    	Assert.assertTrue("Displaying Log-in Page", true);
		        logger.info("Displaying Login Page");
		    
		    
		    }
		    else
		    {
		    	Assert.assertTrue("Not Displaying Log-in Page", false);
		       logger.info("****Error-Not Displaying Login Page");	
		    }
	}

	
	@Then("check the Login Confirmation by Passing the Email & Password with Excel row {string}")
	public void check_the_login_confirmation_by_passing_the_email_password_with_excel_row(String rows)
	{
		
	logger.info("login started");
try {
		   datamap= DataReader.data(System.getProperty("user.dir")+"\\testData\\NOPLoginData.xlsx","Sheet1");
		    int index=Integer.parseInt(rows)-1;
		    String mail=datamap.get(index).get("email");
		    String pass=datamap.get(index).get("password");
		    
		    lpo.clickOn_emailinput(mail);
		    lpo.clickOn_passwordinput(pass);
		    
		    
		    lpo.clickOn_loginButton();
		   String act_msg= lpo.check_welcomeMsg();
		   
		   if(act_msg.equals("Welcome to our store"))
		   {
			   
			   Assert.assertTrue(true);
               logger.info("login successfull");
		   }
		  
		   else
		   {
			   Assert.assertTrue(false);
	           logger.info("login failed"); 
		   }
		   
           logger.info("Login finished");
	}
	catch(Exception e)
	{
logger.info("Login Not Finished Sucessfully");
		e.printStackTrace();
	}
  }	

}
