package com.HospitalManagementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class SignUpAsPatientPage {

//Declaration
	
	@FindBy(xpath="//a[contains(.,'Create an account')]")
	private WebElement createAcc;
	
	@FindBys(@FindBy(name="full_name"))
	private WebElement Firstname;
	
	@FindAll({@FindBy(name="address"),@FindBy(xpath="//input[@placeholder='Address']")})
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="password_again")
	private WebElement confirmpwd;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(xpath="//a[contains(.,'Log-in')]")
	private WebElement LoginLink;
	
//Initialization
	public SignUpAsPatientPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}

	
//Utilization
	
	public WebElement getCreateAcc() {
		return createAcc;
	}

	public WebElement getName() {
		return Firstname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmpwd() {
		return confirmpwd;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}
	
//Business Libraries
	public void SignUpPatientPage(WebDriver driver,String data,String data1,String data2,String data3, String data4, String data5)
	{
		createAcc.click();
		WebDriverUtility wdU= new WebDriverUtility();
		wdU.switchToWindow(driver, "User Registration");
		
		Firstname.sendKeys(data);
		address.sendKeys(data1);
		city.sendKeys(data2);
		email.sendKeys(data3);
		password.sendKeys(data4);
		confirmpwd.sendKeys(data5);
		submit.click();
		wdU.acceptAlert(driver);
		LoginLink.click();
		
	}
}
