package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

//Declaration
	@FindBy(xpath="//h3[text()='Patients']/following-sibling::div//a")
	private WebElement patientClick;
	@FindBy(xpath="//h3[text()='Doctors Login']/..//a[text()='Click Here']")
	private WebElement doctorsClick;
	@FindBy(xpath="//h3[text()='Admin Login']/..//a[text()='Click Here']")
	private WebElement adminClick;
	
//Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
//Utilization

	public void getPatientClick() {
	 patientClick.click();;
	}


	public WebElement getDoctorsClick() {
		return doctorsClick;
	}

	public WebElement getAdminClick() {
		return adminClick;
	}

	
//Business Libraries
	
	public void PatientClick()
	{
		patientClick.click();
	}
	public void DoctorsClick()
	{
		doctorsClick.click();
	}
	public void AdminClick()
	{
		adminClick.click();
	}
}
