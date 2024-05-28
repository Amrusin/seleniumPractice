package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {

//Declaration
	@FindBy(name="username")
	private WebElement usrname;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(name="submit")
	private WebElement login;
	
//Initialization
	
	public PatientLoginPage(WebDriver driver)
		{
	PageFactory.initElements(driver,this);
		}
	
//Utilization
	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLogin() {
		return login;
	}
	
//Business Libraries
	
	public void PatientLognPage(String username,String password)
	{
		usrname.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}
}
