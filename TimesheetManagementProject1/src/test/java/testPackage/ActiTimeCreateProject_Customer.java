package testPackage;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;
import pagePackage.TasksPage;
@Listeners(CustomListener.class)
public class ActiTimeCreateProject_Customer extends BaseTest {
	
	@Test
	public void createValidCustomer_ProjectTestScript() throws IOException, EncryptedDocumentException, InterruptedException
	{
        // create instance of Random class
        Random rand = new Random();
		Flib flib = new Flib();
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		TasksPage tp = new TasksPage(driver);
		
		lp.validLogin(flib.readPropertyData(PROP_PATH1,"Username"),flib.readPropertyData(PROP_PATH1,"Password"));
		hp.click_on_Tasks_Module();
		tp.create_New_Customer_Method(flib.readExcelData(EXCEL_PATH, CUST_PRO_SHEET_NAME,1, 0));
	    tp.create_New_Project_Method(flib.readExcelData(EXCEL_PATH, CUST_PRO_SHEET_NAME,1, 0),flib.readExcelData(EXCEL_PATH, CUST_PRO_SHEET_NAME,1, 1));
	}

}