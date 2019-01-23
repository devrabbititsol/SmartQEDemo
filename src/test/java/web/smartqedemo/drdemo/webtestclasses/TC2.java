package web.smartqedemo.drdemo.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import web.smartqedemo.drdemo.webpageclasses.Screen1;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC2 extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;	public static final int datasetsLength = 1;

	public TC2() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC2.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc2.properties");
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Screen1.projectName);
		test = reports.startTest("TC2");
	}
	
	public void setUP() throws Exception {
		String primaryInfo = Screen1.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(new JSONObject(primaryInfo).optString("browser_type"), configFileObj);
	}

	public void Screen1Test(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Screen1 objScreen1 = PageFactory.initElements(driver, Screen1.class);
		testLogHeader(test, "Verify Screen1 page");
		objScreen1.clkALogin_290526();
		printSuccessLogAndReport(test, logger,  "Text is displayed as : LoginLink");

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		isElementDispalyed = true;
		for(int datasets = 1; datasets <= Screen1.datasetsLength; datasets++) {
			if(!isElementDispalyed) return;			
			setUP();
			if(isElementDispalyed) { Screen1Test(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}