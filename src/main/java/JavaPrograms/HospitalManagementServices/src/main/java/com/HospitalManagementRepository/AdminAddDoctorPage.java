package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class AdminAddDoctorPage {

	//Declaration
	
	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement DocClick;
	
	@FindBy(xpath="//span[.=' Add Doctor']")
	private WebElement AddDoc;
	
	@FindBy(name="Doctorspecialization")
	private WebElement docspe;
	
	@FindBy(name="docname")
	private WebElement dname;
	
	@FindBy(name="clinicaddress")
	private WebElement addre;
	
	@FindBy(name="docfees")
	private WebElement fes;
	
	@FindBy(name="doccontact")
	private WebElement con;
	
	@FindBy(name="docemail")
	private WebElement demail;
	
	@FindBy(name="npass")
	private WebElement pss;
	
	@FindBy(name="cfpass")
	private WebElement cnpass;
	
	@FindBy(id="submit")
	private WebElement create;
	
	//Initialization
	
		public AdminAddDoctorPage(WebDriver driver)
		{
	    PageFactory.initElements(driver,this);
		}

		
		
//Utilization
		public WebElement getDocClick() {
			return DocClick;
		}

		public WebElement getAddDoc() {
			return AddDoc;
		}

		public WebElement getDocspe() {
			return docspe;
		}

		public WebElement getDname() {
			return dname;
		}

		public WebElement getAddre() {
			return addre;
		}
		public WebElement getfes() {
			return fes;
		}

		public WebElement getCon() {
			return con;
		}

		public WebElement getDemail() {
			return demail;
		}

		public WebElement getPss() {
			return pss;
		}

		public WebElement getCnpass() {
			return cnpass;
		}

		public WebElement getCreate() {
			return create;
		}
		
	//Business Libraries
		public void AddDoc(WebDriver driver,String DocSpecial, String Docname,String Address, String fees, String phono,String email,String pass,String cpass) throws InterruptedException
		{
			DocClick.click();
			Thread.sleep(2000);
			AddDoc.click();
			
			docspe.click();
			WebDriverUtility wdU=new WebDriverUtility();
			wdU.HandleDropDown(docspe, DocSpecial);
			dname.sendKeys(Docname);
			addre.sendKeys(Address);
			fes.sendKeys(fees);
			con.sendKeys(phono);
			demail.sendKeys(email);
			pss.sendKeys(pass);
			cnpass.sendKeys(cpass);
			create.click();
			
			wdU.acceptAlert(driver);
}

}
