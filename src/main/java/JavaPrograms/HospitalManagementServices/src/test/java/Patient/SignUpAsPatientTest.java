package Patient;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Reporter;
import com.GenericUtility.BaseClass;
import com.GenericUtility.JavaUtility;
import com.HospitalManagementRepository.HomePage;
import com.HospitalManagementRepository.PatientLoginPage;
import com.HospitalManagementRepository.SignUpAsPatientPage;

public class SignUpAsPatientTest extends BaseClass {
	//public static WebDriver driver;

	@Test
		public void SignUp() throws IOException, InterruptedException
		{
			
//		JavaUtility ju=new JavaUtility();
//		WebDriverUtility wdU=new WebDriverUtility();
//		FileUtility futil=new FileUtility();
//		ExcelUtility exU=new ExcelUtility();
//		DataBaseUtility DBu=new DataBaseUtility();
		
		//WebDriver driver=null;
		// TODO Auto-generated method stub
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties p = new Properties();
        p.load(fis);*/
		String BROWSER=futils.ReadDataFromPropertyFile("browser");
        //String BROWSER = p.getProperty("browser");
        System.out.println(BROWSER);
        //String URL = p.getProperty("url");
        driver.get(futils.ReadDataFromPropertyFile("url"));
        /*String expTitle="Hospital Management System";
        String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle);
		System.out.println(actualTitle);*/
		
        //System.out.println(URL);
        //driver=new ChromeDriver();
        //driver.manage().window().maximize();
        //wdU.maximizeWindow(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //driver.get( futils.ReadDataFromPropertyFile("url"));
        //driver.get(URL);
       /* driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/..//a[text()='Click Here']")).click();
        driver.findElement(By.xpath("//a[contains(.,'Create an account')]")).click();
        wdU.switchToWindow(driver, "User Registration");*/
        
        JavaUtility ju=new JavaUtility();
        int em = ju.getRandomNo();
        HomePage hp=new HomePage(driver);
        hp.PatientClick();
        SignUpAsPatientPage sp=new SignUpAsPatientPage(driver);
        sp.getCreateAcc();
        String Fullname=exutils.ReadDataFromExcel("Patient", 0, 1);
        String Address=exutils.ReadDataFromExcel("Patient", 1, 1); 
        String City=exutils.ReadDataFromExcel("Patient", 2, 1);
        String Email=exutils.ReadDataFromExcel("Patient", 3, 1);
        String Password=exutils.ReadDataFromExcel("Patient", 4, 1);
        String cPass=exutils.ReadDataFromExcel("Patient", 5, 1);
        sp.SignUpPatientPage(driver, Fullname, Address, City,em+Email, Password, cPass);
        //driver.quit();
        
        //driver.get(futils.ReadDataFromPropertyFile("url1"));
   	 PatientLoginPage pl=new PatientLoginPage(driver);
   	 pl.PatientLognPage(futils.ReadDataFromPropertyFile("username"), futils.ReadDataFromPropertyFile("password"));
   	 Reporter.log("--Logged in to Application--", true);
        
        
        /*Set<String> sign = driver.getWindowHandles();
        Iterator<String> iterator=sign.iterator();
        String childwin = iterator.next();
        System.out.println(childwin);
        driver.switchTo().window(childwin);
        */
        
        /*FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\InsideDataInProject.xlsx");
        Workbook wb= WorkbookFactory.create(fis1);*/
          //Sheet sh = wb.getSheet("Patient");
        
       /* driver.findElement(By.name("full_name")).sendKeys(data);
        //String data1=exU.ReadDataFromExcel("Patient", 1, 1);
        driver.findElement(By.name("address")).sendKeys(data1);
       
        driver.findElement(By.name("city")).sendKeys(data2);
        driver.findElement(By.xpath("//label[contains(.,\"Female\")]")).click();
        
        driver.findElement(By.id("password_again")).sendKeys(data5);
        driver.findElement(By.id("submit")).click();*/
          /*String data = sh.getRow(0).getCell(1).getStringCellValue();
          System.out.println(data);*/
         /* String data1 = sh.getRow(1).getCell(1).getStringCellValue();
          System.out.println(data1);*/
         /*String data2 = sh.getRow(2).getCell(1).getStringCellValue();
          System.out.println(data1);*/
         /*String data3 = sh.getRow(3).getCell(1).getStringCellValue();
          System.out.println(data3);*/
         /* String data4 = sh.getRow(4).getCell(1).getStringCellValue();
          System.out.println(data4);*/
          /*String data5 = sh.getRow(5).getCell(1).getStringCellValue();
          System.out.println(data5);*/
          
          /*Alert a=driver.switchTo().alert();
          a.accept();
        wdU.acceptAlert(driver);
        driver.findElement(By.xpath("//a[contains(.,'Log-in')]")).click();*/
          
          
	}

}
