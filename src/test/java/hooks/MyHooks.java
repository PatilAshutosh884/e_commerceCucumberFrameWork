package hooks;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPageObject;

public class MyHooks
{
	public static WebDriver driver;
	
	public static  Logger logger;
	public ResourceBundle rb;
	public String br;

	
	
	
	
	
	
	
	@Before
	public void setup(Scenario scenario)
	{
        System.out.println("Scenario Opened:"+scenario.getName());

				logger= LogManager.getLogger(this.getClass());
		logger.info("==========================setup() Invoked=============================");
				rb= ResourceBundle.getBundle("config");
				br=rb.getString("browser");
				
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
	
	
	
    @After
    public void tearDown(Scenario scenario) 
			    {
			        System.out.println("Scenario status ======>"+scenario.getStatus());
			        if(scenario.isFailed()) 
			        {
			             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			            scenario.attach(screenshot, "image/png",scenario.getName());
			            }
			logger.info("Diver got tearDown");
			 System.out.println("Scenario Closed:"+scenario.getName());
			
			       driver.quit();
			    }
    
    
    
}
