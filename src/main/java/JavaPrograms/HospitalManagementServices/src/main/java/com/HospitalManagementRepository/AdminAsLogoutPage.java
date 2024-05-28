package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAsLogoutPage {

	@FindBy(xpath="//span[@class='username']//i")
	private WebElement logbtn;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement alogout;
	
	//Initialization
	
		public AdminAsLogoutPage(WebDriver driver)
		{
	    PageFactory.initElements(driver,this);
		}
		
	//Utilization
		public WebElement getlogbtn() {
			return logbtn;
		}
		public WebElement getalogout() {
			return alogout;
		}
		
		//Business Libraries
		
		public void AdminLoPage()
		{
			logbtn.click();
			alogout.click();
		}
}
