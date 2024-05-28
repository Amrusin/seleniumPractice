package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

//Declaration
	@FindBy(name="username")
	private WebElement loginame;
	
	@FindBy(name="password")
	private WebElement pswd;
	
	@FindBy(name="submit")
	private WebElement logn;


//Initialization

		public AdminLoginPage (WebDriver driver)
			{
		PageFactory.initElements(driver,this);
			}


//Utilization
		public WebElement getLoginame() {
			return loginame;
		}

		public WebElement getPswd() {
			return pswd;
		}

		public WebElement getLogn() {
			return logn;
		}
		
//Business Libraries
		
		public void AdmLonPage(String USERNAME,String PASSWORD)
		{
			loginame.sendKeys(USERNAME);
			pswd.sendKeys(PASSWORD);
			logn.click();
}
}