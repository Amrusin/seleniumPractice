package Doctor;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriverUtility;
import com.HospitalManagementRepository.DocAppointHistoryPage;
import com.HospitalManagementRepository.HomePage;
import com.HospitalManagementRepository.LoginAsDoctorPage;

public class LoginDoctorViewAppointmentHistoryAndVerifyTest{
	
	public static WebDriver driver;
   @Test
	public void LoginDocotorviewAppoihisAndVerifyTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//JavaUtility ju=new JavaUtility();
		WebDriverUtility wdU=new WebDriverUtility();
		FileUtility futil=new FileUtility();
		//ExcelUtility exU=new ExcelUtility();
		//DataBaseUtility DBu=new DataBaseUtility();
		WebDriver driver=null;
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);
		// TODO Auto-generated method stub
        
        String URL2 = p.getProperty("url2");*/
        
        driver=new ChromeDriver();
        /*driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
        driver.get(futil.ReadDataFromPropertyFile("url2"));
		wdU.maximizeWindow(driver);
		wdU.waitForPageLoad(driver, 5);
		String expTitle="Hospital Management System";
        String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle,"Both should get satisfy");
		System.out.println("Title-->"+actualTitle);
		
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		HomePage hp=new HomePage(driver);
        hp.DoctorsClick();
        
		
       // driver.findElement(By.xpath("//h3[text()='Doctors Login']/..//a[text()='Click Here']")).click();
				LoginAsDoctorPage ld= new LoginAsDoctorPage(driver);
				String USERNAME =futil.ReadDataFromPropertyFile("Usrname");
				String PASSWORD=futil.ReadDataFromPropertyFile("Pwd");
				ld.DoctorLognPage(USERNAME, PASSWORD);
				
                //String USERNAME = p.getProperty("Usrname");
       //driver.findElement(By.name("username")).sendKeys(USERNAME);
        //String PASSWORD=p.getProperty("Pwd");
        //driver.findElement(By.name("password")).sendKeys(PASSWORD);
        //driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);
        DocAppointHistoryPage da= new DocAppointHistoryPage(driver);
        da.DocAppointmntHisPage(driver);
        
        /*driver.findElement(By.xpath("//h2[contains(.,'My Appointments')]/..//a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[text()='sindhu']/..//div/a")).click();
        Thread.sleep(1000);
        wdU.CancelAlert(driver);*/
        /*Alert a=driver.switchTo().alert();
        a.dismiss();
        Thread.sleep(2000);*/
       /* WebElement history = driver.findElement(By.xpath("//table[@class='table table-hover']//tbody"));
        String appoin = history.getText();
        System.out.println(appoin);*/
        
       /* driver.findElement(By.xpath("//span[@class='username']//i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();*/
        
        //driver.quit();  
	}
   

}
