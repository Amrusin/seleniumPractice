package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDoctorSpecializationPage {

//Declaration
	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement docclick;
	
	@FindBy(xpath="//span[text()=' Doctor Specialization ']")
	private WebElement DocSpec;
	
	@FindBy(name="doctorspecilization")
	private WebElement textfeild;
	
	@FindBy(name="submit")
	private WebElement created;


//Initialization

		public CreateDoctorSpecializationPage(WebDriver driver)
			{
		PageFactory.initElements(driver,this);
			}

//Utilization
		
		public WebElement getDocclick() {
			return docclick;
		}


		public WebElement getDocSpec() {
			return DocSpec;
		}


		public WebElement getTextfeild() {
			return textfeild;
		}


		public WebElement getCreated() {
			return created;
		}
		
//Business Libraries
		public void CreateDocSpecial(String special) throws InterruptedException
		{
			docclick.click();
			Thread.sleep(1000);
			DocSpec.click();
			textfeild.sendKeys(special);
			created.click();
			
		}
		}