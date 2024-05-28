package Admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.HospitalManagementRepository.AdminAddDoctorPage;
import com.HospitalManagementRepository.AdminAsLogoutPage;
import com.HospitalManagementRepository.AdminLoginPage;
import com.HospitalManagementRepository.CreateDoctorSpecializationPage;
import com.HospitalManagementRepository.HomePage;

public class CreateDoctorSpecializationAndAddDoctorsTest{
	//public static WebDriver driver;
	@Test
	
	public void CreateDoctorSpeciaAnsAddDoc() throws IOException, InterruptedException {
		//changes
		// TODO Auto-generated method stub
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);
		// TODO Auto-generated method stub
        
        String URL2 = p.getProperty("url2");*/
		//JavaUtility ju=new JavaUtility();
		WebDriverUtility wdU=new WebDriverUtility();
		FileUtility futil=new FileUtility();
		ExcelUtility exU=new ExcelUtility();
		//DataBaseUtility DBu=new DataBaseUtility();
		
		WebDriver driver=null;
        
        driver=new ChromeDriver();
        /*driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
        driver.get(futil.ReadDataFromPropertyFile("url2"));
        wdU.maximizeWindow(driver);
        wdU.waitForPageLoad(driver, 5);
		
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        // driver.findElement(By.xpath("//h3[text()='Admin Login']/..//a[text()='Click Here']")).click();
        
        HomePage ho=new HomePage(driver);
        ho.AdminClick();
        Thread.sleep(1000);
        AdminLoginPage al=new AdminLoginPage(driver);
        String USERNAME = futil.ReadDataFromPropertyFile("Adminname");
        String PASSWORD=futil.ReadDataFromPropertyFile("Admpwd");
        al.AdmLonPage(USERNAME, PASSWORD);
        
        /*driver.findElement(By.name("username")).sendKeys(USERNAME);
        //String USERNAME = p.getProperty("Adminname");
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        //String PASSWORD=p.getProperty("Admpwd");
        driver.findElement(By.name("submit")).click();*/
        String special="GeneralDoctor";
        CreateDoctorSpecializationPage cd=new CreateDoctorSpecializationPage(driver);
        Thread.sleep(1000);
        cd.CreateDocSpecial(special);
        /*driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("doctorspecilization")).sendKeys("GeneralDoctor");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();*/
        Thread.sleep(1000);
        JavaUtility ju=new JavaUtility();
        int emails=ju.getRandomNo();
        AdminAddDoctorPage ap=new AdminAddDoctorPage(driver);
        
        String DocSpecial="General Doctor";
       
        String Docname =  exU.ReadDataFromExcel("AddDoctor", 0, 1);
        String Address= exU.ReadDataFromExcel("AddDoctor", 1, 1);
        String fees= exU.ReadDataFromExcel("AddDoctor", 2, 1);
        String phono = exU.ReadDataFromExcel("AddDoctor", 3, 1);
        String email = exU.ReadDataFromExcel("AddDoctor", 4, 1);
        String pass = exU.ReadDataFromExcel("AddDoctor", 5, 1);
        String cpass = exU.ReadDataFromExcel("AddDoctor", 6, 1);
        ap.AddDoc(driver, DocSpecial, Docname, Address, fees, phono,emails+email,pass, cpass);
       
        
        /*driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
        Thread.sleep(2000);
        WebElement docspe = driver.findElement(By.name("Doctorspecialization"));
        wdU.HandleDropDown(docspe, "GeneralDoctor");*/
        /*Select s =new Select(docspe);
        s.selectByValue("General Doctor");*/
        /*FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\InsideDataInProject.xlsx");
        Workbook wb= WorkbookFactory.create(fis2);
          Sheet sh = wb.getSheet("AddDoctor");
          String data = sh.getRow(0).getCell(1).getStringCellValue();*/
         /* System.out.println(data);
        driver.findElement(By.name("docname")).sendKeys(data);
        //String data1 = sh.getRow(1).getCell(1).getStringCellValue();
        System.out.println(data1);
        driver.findElement(By.name("clinicaddress")).sendKeys(data1);
        //String data2 = sh.getRow(2).getCell(1).getStringCellValue();
        System.out.println(data2);
        driver.findElement(By.name("docfees")).sendKeys(data2);
        //String data3 = sh.getRow(3).getCell(1).getStringCellValue();
        System.out.println(data3);
        driver.findElement(By.name("doccontact")).sendKeys(data3);
        //String data4 = sh.getRow(4).getCell(1).getStringCellValue();
        System.out.println(data4);
        driver.findElement(By.name("docemail")).sendKeys(data4);
        //String data5 = sh.getRow(5).getCell(1).getStringCellValue();
        System.out.println(data5);
        driver.findElement(By.name("npass")).sendKeys(data5);
        //String data6 = sh.getRow(6).getCell(1).getStringCellValue();
        System.out.println(data6);
        driver.findElement(By.name("cfpass")).sendKeys(data6);
        driver.findElement(By.id("submit")).click();*/
        //wdU.acceptAlert(driver);
        /*Alert a=driver.switchTo().alert();
        a.accept();*/
        Thread.sleep(1000);
        AdminAsLogoutPage alo=new AdminAsLogoutPage(driver);
        alo.AdminLoPage();
        /*driver.findElement(By.xpath("//span[@class='username']//i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();  
        */
	}

}
