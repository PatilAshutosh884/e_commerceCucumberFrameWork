package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	//features= {"C:\\Users\\ashut\\eclipse-workspace\\e_commerceCucumberFrameWork\\feature\\UserRegistrationDDT.feature"},
	//features= {"C:\\Users\\ashut\\eclipse-workspace\\e_commerceCucumberFrameWork\\feature\\LoginDDT.feature"},
	features= {"C:\\Users\\ashut\\eclipse-workspace\\e_commerceCucumberFrameWork\\feature\\Wishlist.feature"},
	//features= {""},
	//features= "@target/rerun.txt",
	
	glue="stepDefinations",
  //glue="",
	plugin={"pretty",
					//"html:report/LoginDDT_report.html",
				    //"html:report/UR_report.html",
			      "html:report/A-Wishlist_report.html",
				    //"html:report/R-Wishlist_report.html",
				    //"json:report/myreport1.json",
					   "rerun:target/rerun.txt",
	 	    },
	dryRun=false,
	monochrome=true,
	
	//tags="@UR_DDT"
	//tags="@LoginDDT"
	//tags="@UR_DDT and @LoginDDT"
	tags="@A-Wishlist"
	//tags="@R-Wishlist"
	//tags="@A-Wishlist and @R-Wishlist"
	//tags="@A-Wishlist  or @R-Wishlist"
	//tags="@A-Wishlist and not @R-Wishlist"	
		
)
public class TestRunner 
{

}
