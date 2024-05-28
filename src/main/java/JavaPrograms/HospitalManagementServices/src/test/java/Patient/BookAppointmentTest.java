package Patient;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HospitalManagementRepository.BookAppointmentPage;
import com.HospitalManagementRepository.PatientLoginPage;
//@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class BookAppointmentTest extends BaseClass {
//public static WebDriver driver;
	@Test(groups="regression")
	
	public void BookAppointment() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);
		// TODO Auto-generated method stub
        
        String URL1 = p.getProperty("url1");*/
        
        //driver=new ChromeDriver();
        
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        /*driver.get(futil.ReadDataFromPropertyFile("url1"));
        wdU.maximizeWindow(driver);
        wdU.waitForPageLoad(driver, 5);
		PatientLoginPage pl=new PatientLoginPage(driver);
		String USERNAME =futil.ReadDataFromPropertyFile("username");
		String PASSWORD=futil.ReadDataFromPropertyFile("password");
		pl.PatientLognPage(USERNAME, PASSWORD);
        */
		
		driver.get(futils.ReadDataFromPropertyFile("url1"));
   	    PatientLoginPage pl=new PatientLoginPage(driver);
   	    pl.PatientLognPage(futils.ReadDataFromPropertyFile("username"), futils.ReadDataFromPropertyFile("password"));
   	    Reporter.log("--Logged in to Application--", true);
   	    
   	    //Assert.fail();
   	    BookAppointmentPage ba=new BookAppointmentPage(driver);
        ba.BookApponitment(driver);
        
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        /*
        //String USERNAME = p.getProperty("username");
        driver.findElement(By.name("username")).sendKeys(USERNAME);
        
        //	String PASSWORD=p.getProperty("password");
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("submit")).click();*/
        
        
       /* driver.findElement(By.xpath("//h2[contains(.,\"Book My Appointment\")]/..//a")).click();
        WebElement specialization = driver.findElement(By.name("Doctorspecialization"));
        /*Select s=new Select(specialization);
        s.selectByVisibleText("Pediatrician");*/
       /* wdU.handleDropdown(specialization, "Pediatrician");
        
        WebElement name = driver.findElement(By.name("doctor"));
        /*Select se=new Select(name);
        se.selectByValue("1488");*/
       /* wdU.HandleDropDown(name,"1488");
        
        WebElement calender = driver.findElement(By.name("appdate"));
        calender.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class=' table-condensed']//tbody//td[text()='30']")).click();
        WebElement time = driver.findElement(By.id("timepicker1"));
        time.clear();
        Thread.sleep(2000);
        time.sendKeys("6:00 PM");
        driver.findElement(By.name("submit")).click();*/
        
       // wdU.acceptAlert(driver);
       /* Alert a=driver.switchTo().alert();
        a.accept();*/
       /* PatientLogoutPage pal=new PatientLogoutPage(driver);
        pal.Patlogout();*/
        
        /*driver.findElement(By.xpath("//span[@class='username']//i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();*/
        
	}

}
