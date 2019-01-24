package web.smartqedemo.drdemo.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Screen1 extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":7,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"https://devrabbitdev.com/\",\"report_upload_url\":\"https://192.168.1.142:8080/TAF_Automation_DR/UploadReportFile\",\"project_name\":\"SmartQEDemo\",\"project_description\":\"desc\",\"project_id\":0,\"module_name\":\"DRDemo\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":343,\"testcase_name\":\"TC1\",\"testcase_id\":406,\"testset_name\":\"Ts1\",\"testset_id\":51,\"executed_timestamp\":2124405099,\"browser_type\":\"chrome\"}";

	public static String projectName = "smartqedemo";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Screen1(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//HTML/BODY[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/UL[1]/LI[2]/A[1]")	
	private WebElement	Login_290526A;
	public String clkALogin_290526() {
		waitForExpectedElement(driver, Login_290526A);		
		String text = Login_290526A.getText();
		Login_290526A.click();
		return text;
	}

}