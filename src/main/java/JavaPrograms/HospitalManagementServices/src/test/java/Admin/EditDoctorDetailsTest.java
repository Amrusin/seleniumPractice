package Admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriverUtility;
import com.HospitalManagementRepository.AdminLoginPage;
import com.HospitalManagementRepository.EditDoctorDetailsPage;
import com.HospitalManagementRepository.HomePage;

public class EditDoctorDetailsTest {

	public static WebDriver driver;
	@Test
	public void EditDoctorDetails() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//JavaUtility ju=new JavaUtility();
		WebDriverUtility wdU=new WebDriverUtility();
		FileUtility futil=new FileUtility();
		ExcelUtility exU=new ExcelUtility();
		//DataBaseUtility DBu=new DataBaseUtility();
		WebDriver driver=null;
		
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);
		// TODO Auto-generated method stub
        
        String URL2 = p.getProperty("url2");*/
        String dname="Vasundhara";
        driver=new ChromeDriver();
       /* driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
        driver.get(futil.ReadDataFromPropertyFile("url2"));
        wdU.maximizeWindow(driver);
        wdU.waitForPageLoad(driver, 5);
		
        HomePage hp= new HomePage(driver);
        hp.AdminClick();
        Thread.sleep(1000);
        AdminLoginPage al= new AdminLoginPage(driver);
        String USERNAME = futil.ReadDataFromPropertyFile("Adminname");
        String PASSWORD=futil.ReadDataFromPropertyFile("Admpwd");
        al.AdmLonPage(USERNAME, PASSWORD);
        
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        //driver.findElement(By.xpath("//h3[text()='Admin Login']/..//a[text()='Click Here']")).click();
        // driver.findElement(By.name("username")).sendKeys(USERNAME);
        //String USERNAME = p.getProperty("Adminname");
        //String PASSWORD=p.getProperty("Admpwd");
        //driver.findElement(By.name("password")).sendKeys(PASSWORD);
        //driver.findElement(By.name("submit")).click();
        EditDoctorDetailsPage ed= new EditDoctorDetailsPage(driver);
        String data2=exU.ReadDataFromExcel("AddDoctor", 2, 1);
        ed.EditDocPage(driver,data2,dname);
        /*driver.findElement(By.xpath("//h2[text()='Manage Doctors']/..//a")).click();
        driver.findElement(By.xpath("//td[contains(text(),"+DocNam+")]/..//a[@tooltip='Edit']")).click();*/
        

       /* FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\InsideDataInProject.xlsx");
        Workbook wb= WorkbookFactory.create(fis2);
          Sheet sh = wb.getSheet("AddDoctor");
        */
        System.out.println(data2);
        //driver.findElement(By.name("docfees")).sendKeys(data2);
        //driver.findElement(By.name("submit")).click();
        
        Thread.sleep(2000);
       /* WebElement text = driver.findElement(By.xpath("//h5[contains(.,'Doctor Details updated Successfully')]"));
        String update = text.getText();
        System.out.println(update);*/
        
        /*driver.findElement(By.xpath("//span[@class='username']//i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();  
        */
           
      // driver.quit();

	}

}
