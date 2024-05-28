package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutAsDoctorPage {
	@FindBy(xpath="//span[@class='username']//i")
	private WebElement logbtn;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement alogout;
	
//Initialization
	
	public LogoutAsDoctorPage(WebDriver driver)
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
	
	public void DocLogout()
	{
	
		logbtn.click();
		alogout.click();
}
}
