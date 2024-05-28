package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientAppointmentsHistoryPage {

	
//Declaration
	@FindBy(xpath="//a[contains(.,'View Appointment History')]")
	 private WebElement appHisclick;
	
	@FindBy(xpath="//table[@id='sample-table-1']//tbody")
	 private WebElement text;
	
	 @FindBy(xpath="//span[@class='username']//i")
	 private WebElement logoutclick;
	 
	 @FindBy(xpath="//a[contains(.,'Log Out')]")
	 private WebElement logout;
	 
//Initialization
		
		public PatientAppointmentsHistoryPage(WebDriver driver)
			{
		PageFactory.initElements(driver,this);
			}

//Utilization
		
		public WebElement getAppHisclick() {
			return appHisclick;
		}

		public WebElement getText() {
			return text;
		}

		public WebElement getLogoutclick() {
			return logoutclick;
		}

		public WebElement getLogout() {
			return logout;
		}
		
//Business Libraries
		
		public void PatAppointmentsHistoryPage()
		{
			appHisclick.click();
		    String   d =text.getText();
		    System.out.println(d);
		    logoutclick.click();
		    logout.click();
		}
		
		public void PatAppointmentsHistoryPageWithoutLogout()
		{
			appHisclick.click();
		    String   d=text.getText();
		    System.out.println(d);
		}
}
