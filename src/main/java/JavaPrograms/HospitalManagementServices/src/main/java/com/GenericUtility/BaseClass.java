package com.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.HospitalManagementRepository.PatientLogoutPage;

public class BaseClass {
public DataBaseUtility dbutils=new DataBaseUtility();
public ExcelUtility exutils=new ExcelUtility();
public FileUtility futils=new FileUtility();
public JavaUtility jutils=new JavaUtility();
public WebDriverUtility wdutils=new WebDriverUtility();

public WebDriver driver;
//public static WebDriver sdriver;

 @BeforeSuite(alwaysRun = true)
 public void OpenDataBaseConnection() throws SQLException
 {
	 //dbutils.ConnectDB();
	 Reporter.log("-----DB Connected-----", true);
 }
 //@Parameters("BROWSER")
 @BeforeClass(alwaysRun = true)
 public void OpenBrowser() throws IOException
 {
	 String browser=futils.ReadDataFromPropertyFile("browser");
	 if(browser.equalsIgnoreCase("chrome"))
	 {
		 driver=new ChromeDriver();
		 Reporter.log("Launch Chrome Browser", true);
	 }
	 else if(browser.equalsIgnoreCase("firefox"))
	 {
		 driver=new FirefoxDriver();
		 Reporter.log("Launch FireFox Browser", true);
	 }
	 else if(browser.equalsIgnoreCase("edge"))
	 {
		 driver=new EdgeDriver();
		 Reporter.log("Launch Edge Browser", true );
	 }
	 else
	 {
		 Reporter.log("Invalid browsers", true);
	 }
	 //System.out.println(futils.ReadDataFromPropertyFile("url1"));
	// sdriver=driver;
	 wdutils.maximizeWindow(driver);
	 wdutils.waitForPageLoad(driver, 30);
 }
 
 @BeforeMethod(alwaysRun = true)
 public void loginToApp() throws IOException
 {
	 driver.get(futils.ReadDataFromPropertyFile("url"));
	 System.out.println(futils.ReadDataFromPropertyFile("url1"));
	 //driver.get(futils.ReadDataFromPropertyFile("url1"));
	 Reporter.log("Url is triggering",true); 
 }
 
 
 @AfterMethod(alwaysRun = true)
 
public void logoutFromApplication()
{
	 PatientLogoutPage plo=new PatientLogoutPage(driver);
	 plo.Patlogout();
	 Reporter.log("--Logged out from Application--",true);
}
 
 @AfterClass(alwaysRun = true)
 public void closeBrowser()
 {
	 driver.quit();
	 Reporter.log("--Close the Browser--", true);
 }
 
 @AfterSuite(alwaysRun = true)
 public void closeDBConnection() throws SQLException
 {
	 dbutils.closeConnection();
	 Reporter.log("--Close the DB Connection--", true);
 }
 
}
