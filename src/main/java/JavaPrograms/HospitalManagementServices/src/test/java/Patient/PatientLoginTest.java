package Patient;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HospitalManagementRepository.PatientLoginPage;
//@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class PatientLoginTest extends BaseClass{
@Test(groups="regression")
public void loginToApp() throws IOException
{	 
	driver.get(futils.ReadDataFromPropertyFile("url1"));
	 PatientLoginPage pl=new PatientLoginPage(driver);
	 //Assert.fail();
	 pl.PatientLognPage(futils.ReadDataFromPropertyFile("username"), futils.ReadDataFromPropertyFile("password"));
	 Reporter.log("--Logged in to Application--", true);
}
}
