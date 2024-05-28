package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLogoutPage {

	//Declaration
	 @FindBy(xpath="//span[@class='username']")
	 private WebElement logoutclick;
	 
	 @FindBy(xpath="//a[contains(.,'Log Out')]")
	 private WebElement logout;
	 
	 //Initialization
	 public PatientLogoutPage(WebDriver driver)
		{
	PageFactory.initElements(driver,this);
		}
	 //Utilization
	 public WebElement getLogoutclick() {
			return logoutclick;
		}

		public WebElement getLogout() {
			return logout;
		}
		
//Business Libraries		
		public void Patlogout()
		{
			
		    logoutclick.click();
		    logout.click();
		    
		}
}
