package com.HospitalManagementRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

	public class DocAppointHistoryPage {

//Declaration
		@FindBy(xpath="//h2[contains(.,'My Appointments')]/..//a")
		private WebElement myappclick;
		
		@FindBy(xpath="//td[text()='sindhu']/..//div/a")
		private WebElement canc;
		
		@FindBy(xpath="//table[@class='table table-hover']//tbody")
		private WebElement tex;
		
		@FindBy(xpath="//span[@class='username']//i")
		private WebElement clik;
		
		@FindBy(xpath="//a[contains(.,'Log Out')]")
		private WebElement logou;
		
//Initialization
		public DocAppointHistoryPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

//Utilization
		public WebElement getMyappclick() {
			return myappclick;
		}

		public WebElement getCanc() {
			return canc;
		}

		public WebElement getTex() {
			return tex;
		}

		public WebElement getClik() {
			return clik;
		}

		public WebElement getLogou() {
			return logou;
		}
		
	public void DocAppointmntHisPage(WebDriver driver)
	{
		WebDriverUtility wdU=new WebDriverUtility();
		myappclick.click();
		canc.click();
		wdU.CancelAlert(driver);
		String da=tex.getText();
		System.out.println(da);
		clik.click();
		logou.click();
		
	}
		
	}


