package com.HospitalManagementRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginAsDoctorPage {

		@FindBy(name="username")
		private WebElement usr;
		
		@FindBy(name="password")
		private WebElement pwd;
		
		@FindBy(name="submit")
		private WebElement logn;
		
		//Initialization
		
			public LoginAsDoctorPage(WebDriver driver)
				{
			PageFactory.initElements(driver,this);
				}
			
		//Utilization
			public WebElement getUsrname() {
				return usr;
			}

			public WebElement getPwd() {
				return pwd;
			}

			public WebElement getLogin() {
				return logn;
			}
			
		// Business Libraries
			
			public void DoctorLognPage(String USERNAME,String PASSWORD)
			{
				usr.sendKeys(USERNAME);
				pwd.sendKeys(PASSWORD);
				logn.click();
			}
	}


