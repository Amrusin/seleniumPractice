package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class BookAppointmentPage {

//Declaration
	@FindBy(xpath="//h2[contains(.,'Book My Appointment')]/..//a")
	private WebElement bmyApp;
	
	@FindBy(name="Doctorspecialization")
	private WebElement sel1;
	
	@FindBy(name="doctor")
	private WebElement sel2;
	
	@FindBy(name="appdate")
	private WebElement dateclick;
	
	@FindBy(xpath="//table[@class=' table-condensed']//tbody//td[text()='30']")
	private WebElement datenum;
	
	@FindBy(id="timepicker1")
	private WebElement time;
	
	@FindBy(name="submit")
	private WebElement subm;
	
//Initialization
	public BookAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
//Utilization
	public WebElement getBmyApp() {
		return bmyApp;
	}


	public WebElement getSel1() {
		return sel1;
	}


	public WebElement getSel2() {
		return sel2;
	}


	public WebElement getDateclick() {
		return dateclick;
	}


	public WebElement getDatenum() {
		return datenum;
	}


	public WebElement getTime() {
		return time;
	}


	public WebElement getSubm() {
		return subm;
	}

//Business Libraries
	public void BookApponitment(WebDriver driver)
	{
		bmyApp.click();
		WebDriverUtility wdU=new WebDriverUtility();
		wdU.handleDropdown(sel1, "Pediatrician");
		wdU.HandleDropDown(sel2, "1488");
		dateclick.click();
		datenum.click();
		time.clear();
		time.sendKeys("6:00 PM");
		subm.click();
		wdU.acceptAlert(driver);
		
	}
}
