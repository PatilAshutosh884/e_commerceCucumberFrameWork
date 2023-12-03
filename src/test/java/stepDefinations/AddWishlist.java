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

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HTCOneMiniBluePageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterationPageObject;
import pageObjects.WishListPageObject;
import utilities.DataReader;

public class AddWishlist

{
	public WebDriver driver;
	private static Logger logger;
	public ResourceBundle rb;
	public String br;
	boolean rslt;
	public String act_rslt;
	public String exp_rslt;
    boolean value;
    public String act_msg;
    public String txt;
    public String pname;
    public String qty;
	
	RegisterationPageObject rpo;
	LoginPageObject lpo;
	HomePageObject hpo;
	WishListPageObject wpo;
	HTCOneMiniBluePageObject htcpo;
	
	List<HashMap<String,String>> datamap;
	
	
	@Before
	public void setupForA_Wishlist()
	{
				logger= LogManager.getLogger(this.getClass());
		logger.info("==========================setupFor A_Wishlist invoked=============================");
				rb= ResourceBundle.getBundle("config");
				br=rb.getString("browser");
		
	}
	
	//@Before
	public void setupForR_Wishlist()
	{
				logger= LogManager.getLogger(this.getClass());
		logger.info("==========================setupFor R_Wishlist() invoked=============================");
				rb= ResourceBundle.getBundle("config");
				br=rb.getString("browser");
		
	}
	
    @After
    public void tearDownForA_Wishlist(Scenario scenario) 
			    {
			        System.out.println("Scenario status ======>"+scenario.getStatus());
			        if(scenario.isFailed()) 
			        {
			             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			            scenario.attach(screenshot, "image/png",scenario.getName());
			            }
			logger.info("teardown for A_Wishlist invoked");
			
			       driver.quit();
    }
    
    //@After
    public void tearDownForR_Wishlist(Scenario scenario) 
			    {
			        System.out.println("Scenario status ======>"+scenario.getStatus());
			        if(scenario.isFailed()) 
			        {
			             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			            scenario.attach(screenshot, "image/png",scenario.getName());
			            }
			logger.info("teardown for R_Wishlist invoked");
			
			       driver.quit();
    }
	
	
	
	@Given("User Opens the Browser \\(for WISHLIST-F)")
	public void user_opens_the_browser_for_wishlist_f() 
	{
				if(br.equals("chrome"))
			        {
			           driver=new ChromeDriver();
			        System.out.println("Chrome driver invoke");
			        }
			        else if (br.equals("firefox")) {
			           driver = new FirefoxDriver();
			        }
			        else if (br.equals("edge")) {
			           driver = new EdgeDriver();
			        }
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	
	
	@Given("User Opening Home URL {string} \\(for WISHLIST-F)")
	public void user_opening_home_url_for_wishlist_f(String url) 
	{
     logger.info("STP1 Opening URl");
					   		
					   		driver.get(url);
					   		driver.manage().window().maximize();
	}
	
	
	

	@When("User Navigate to Register page by clicking on Register link option")
	public void user_navigate_to_register_page_by_clicking_on_register_link_option() 
	{
		logger.info("STP2 click on Register link");
						hpo=new HomePageObject(driver);
						hpo.clickOnRegisterLink_Icon();
	}

	@When("User check for Register Page")
	public void user_check_for_register_page() 
	{
		logger.info("Stp3 check for Registration Page");
						 rpo = new RegisterationPageObject(driver);
						 rslt=rpo.checkLogoPresence();
						 
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
	 logger.info(" Stp3 is Done"); 
	}

	@When("User Regitering the user by Filling out the Registration form Using Excel data\"{int}\" \\(for WISHLIST-F)")
	public void user_regitering_the_user_by_filling_out_the_registration_form_using_excel_data_for_wishlist_f(Integer int1)
	{
		datamap= DataReader.data(System.getProperty("user.dir")+"\\testData\\A_WishlistData.xlsx","Sheet1");
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
 logger.info("Stp4 Registration Started");
				    rpo.select_Gender(_gender);
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
	    



			try {
					rpo.clickOn_RegisterButton();
					act_rslt=rpo.register_result();
					exp_rslt="Your registration completed";
					
					
					if(act_rslt.equals(exp_rslt))
					{
					Assert.assertTrue(true);
					
logger.info("User Registarion Successfull"); 
logger.info("Stp4 Done");

					
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
					logger.info("*****Something Went Wrong while Checking Registartion Confirmation msg****");
					Assert.fail();
					
 
					
				}
	}
	
	

	@When("User Navigate to Login Page by clicking on log in link  \\(for WISHLIST-F)")
	public void user_navigate_to_login_page_by_clicking_on_log_in_link_for_wishlist_f() 
	{
logger.info("Step5 Clicked on Login link ");
			try {
						
				    lpo=new LoginPageObject(this.driver);
					lpo.clickOn_loginLink();

logger.info("Step5 Done ");

						
				} 
			    catch (InterruptedException e) 
				  {
logger.info("Step5 Failed to click on Login-link");
						e.printStackTrace();
						
				  }
			       
	}
			
				

	@When("User check for log in Page  \\(for WISHLIST-F)")
	public void user_check_for_log_in_page_for_wishlist_f() 
	{
		
logger.info("Step6 checking Login Page");
	     
	     
		     value=lpo.checkloginButton();
		    if(value==true)
		    {
		    	
		    	Assert.assertTrue(true, "Displaying Login Page");
                logger.info("Step6 Done: Displaying Login Page");
		    
		    
		    }
		    else
		    {
		    	  logger.info("****Error-Not Displaying Login Page");	
		    	Assert.assertTrue(false, "****Error-Not Displaying Login Page");
              
		    }
	}


@When("User check the Login Confirmation by Passing the Email & Password with Excel row \"{int}\" \\(for WISHLIST-F)")
public void user_check_the_login_confirmation_by_passing_the_email_password_with_excel_row_for_wishlist_f(Integer int1)
	{
	
logger.info(" Step 7 login started");
		try {
				   datamap= DataReader.data(System.getProperty("user.dir")+"\\testData\\R_WishlistData.xlsx","Sheet1");
				    int index=int1-1;
				    String mail=datamap.get(index).get("email");
				    String pass=datamap.get(index).get("password");
				    
				    lpo.clickOn_emailinput(mail);
				    lpo.clickOn_passwordinput(pass);
				    
				    
				    lpo.clickOn_loginButton();
				   act_msg= lpo.check_welcomeMsg();
				   
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
				   
logger.info(" Step7 Done: Login finished");
			}
			catch(Exception e)
			{
		        logger.info("Login Not Finished Sucessfully");
				e.printStackTrace();
			}
		  }	
	
	    

	@When("User Search the product in search box by passing {string}")
	public void user_search_the_product_in_search_box_by_passing(String string) throws InterruptedException
	{
logger.info("Step8: Search the Product");	
					hpo= new HomePageObject(driver);
					hpo.clickOnSearchBox(string);
					
					hpo.clickOnSearchButton();
		
logger.info("Step8 Done: HTC One Mini Blue product is Searching");
						Thread.sleep(6000);
	}
	
	    
		

	@When("User Adding product to Wishlist by clicking on Add to wishlist option")
	public void user_adding_product_to_wishlist_by_clicking_on_add_to_wishlist_option() throws InterruptedException 
	{
 logger.info("Step9 Adding Product to Wishlist");	
		                    htcpo= new HTCOneMiniBluePageObject(driver);
					        String txt=htcpo.checkHtcOneMiniBluePage();
					        System.out.println("product is:"+txt);
					        if(txt.equals("HTC One Mini Blue"))
					        {

					        	try {
					        	    
									htcpo.clickOnWishList_Button();
									Thread.sleep(6000);
								    } 
					        	    catch (InterruptedException e) 
					        	     {
											System.out.println("Something went wrong while clicking wishlist button");
											    e.printStackTrace();
								      }
					        	     Assert.assertTrue(true);
logger.info("Step9 Done: Product is Added to Wishlist ");


					        }
					        else
					        {
					        	Assert.assertTrue(false);
logger.info("Step9 ****Error==>Product is Not Displaying");
					        }
	}
	
	
	
	

	@When("User Navigate to Wishlist Page by clicking on Wishlist link option")
	public void user_navigate_to_wishlist_page_by_clicking_on_wishlist_link_option() 
	{
logger.info("Step10 Clicked on Wishlist iconlink option");
				hpo= new HomePageObject(driver);
				hpo.clickOnWishList_iconlink();
	    
logger.info("Step10 Done ");
	    
	}

	@When("User checking for Wishlist Page")
	public void user_checking_for_wishlist_page() 
	{
		            wpo=new WishListPageObject(driver);
						   txt=wpo.checkWishlistPage();
						   if (txt.equals("Wishlist"))
						   {
								Assert.assertTrue(true);
logger.info("Step11 Done: Wishlist Page Opened");
				                 
						   }
	}

	@Then("checking HTC One Mini Blue product is in the Product column of Wishlist Table")
	public void checking_htc_one_mini_blue_product_is_in_the_product_column_of_wishlist_table()
	{
logger.info("Step12 Check Product is Added in Wishlist Table "); 
				  pname= wpo.checkHtcMiniblue();
				  System.out.println("Product Name is:"+pname);
				  if(pname.equals("HTC One Mini Blue"))
				  {
					 
logger.info("Step12 Done: Product added & displaying in the WishList Table Successfully");
					 wpo.clickOnlogout_icon();
					 Assert.assertTrue(true);
				  }
				  else
				  {
					  
logger.info("Step12 failed: Product is not Showing in the WishList Table"); 
                        Assert.assertTrue(false);
				  }
				  
				 
	}
	
	
	@When("checking HTC One Mini Blue product is in the Product column of Wishlist Table \\(for R-Wishlist-F)")
	public void checking_htc_one_mini_blue_product_is_in_the_product_column_of_wishlist_table_for_r_wishlist_f() 
	{
	    
logger.info("Step12 Check Product is Added in Wishlist Table "); 
					  pname= wpo.checkHtcMiniblue();
					  System.out.println("Product Name is:"+pname);
					  if(pname.equals("HTC One Mini Blue"))
					  {
			 
logger.info("Step12 Done: Product added & displaying in the WishList Table Successfully");
			 
						 Assert.assertTrue(true);
					  }
					  else
					  {
			  
logger.info("Step12 failed: Product is not Showing in the WishList Table"); 
			              Assert.assertTrue(false);
					  }
	}
	
	
	

	@Then("Remove the Product from Wishlist Table by clicking on remove button")
	public void remove_the_product_from_wishlist_table_by_clicking_on_remove_button() throws InterruptedException
	{		
logger.info("--------Removing the product from Wishlist----------"); 
					wpo.clickOnRemove_Button();
					Thread.sleep(2000);
					qty=wpo.checkWishlist_qty();
					System.out.println("Quantity is:"+qty);
					
					if(qty.equals("(0)"))
					{
						 //wpo.clickOnlogout_icon();
						 Assert.assertTrue(true);
logger.info("Removed the product from Wishlist"); 
					}
					else
					  {
						  
logger.info("Failed to Remove Product"); 
	                        Assert.assertTrue(false);
					  }
	   
	}
}

