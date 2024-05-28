package Patient;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HospitalManagementRepository.PatientAppointmentsHistoryPage;
import com.HospitalManagementRepository.PatientLoginPage;
//@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class LoginAsPatientAppointmentHistoryVerifyTest extends BaseClass{
	//public static WebDriver driver;
	@Test
	
	public void LoginAsPatient() throws IOException, InterruptedException
	{
		/*JavaUtility ju=new JavaUtility();
		WebDriverUtility wdU=new WebDriverUtility();
		FileUtility futil=new FileUtility();
		ExcelUtility exU=new ExcelUtility();
		DataBaseUtility DBu=new DataBaseUtility();
		WebDriver driver=null;*/
		
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);*/
		// TODO Auto-generated method stub
        
        //String URL1 = p.getProperty("url1");
        
        //driver=new ChromeDriver();
        
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       /* driver.get(futil.ReadDataFromPropertyFile("url1"));
        wdU.maximizeWindow(driver);
        wdU.waitForPageLoad(driver, 5);
		
        PatientLoginPage pl=new PatientLoginPage(driver);
        String USERNAME=futil.ReadDataFromPropertyFile("username");
        String PASSWORD=futil.ReadDataFromPropertyFile("password");
        pl.PatientLognPage(USERNAME, PASSWORD);
        pl.getLogin();*/
        
         driver.get(futils.ReadDataFromPropertyFile("url1"));
    	 PatientLoginPage pl=new PatientLoginPage(driver);
    	 pl.PatientLognPage(futils.ReadDataFromPropertyFile("username"), futils.ReadDataFromPropertyFile("password"));
    	 Reporter.log("--Logged in to Application--", true);
       
    	
    	 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        
        //driver.findElement(By.name("username")).sendKeys(USERNAME);
        //String USERNAME = p.getProperty("username");
        
        //driver.findElement(By.name("password")).sendKeys(PASSWORD);
        //String PASSWORD=p.getProperty("password");
        //driver.findElement(By.name("submit")).click();
        
        PatientAppointmentsHistoryPage pa=new PatientAppointmentsHistoryPage(driver);
        //Assert.fail();
        pa.PatAppointmentsHistoryPageWithoutLogout();
        
        //driver.findElement(By.xpath("//a[contains(.,\"View Appointment History\")]")).click();
        //WebElement text = driver.findElement(By.xpath("//table[@id='sample-table-1']//tbody"));
        
        /*System.out.println(d+"    ");
        driver.findElement(By.xpath("//span[@class='username']//i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();*/
	}

}
