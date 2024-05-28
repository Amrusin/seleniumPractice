package com.HospitalManagementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDoctorDetailsPage {

//Declaration
	
	@FindBy(xpath="//h2[text()='Manage Doctors']/..//a")
	private WebElement mdocclick;
	
	@FindBy(name="docfees")
	private WebElement fees;
	
	@FindBy(name="submit")
	private WebElement done;
	
	@FindBy(xpath="//h5[contains(.,'Doctor Details updated Successfully')]")
	private WebElement tex;
	
	@FindBy(xpath="//span[@class='username']//i")
	private WebElement logbtn;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	private WebElement alogout;
	
//Initialization
	
	public EditDoctorDetailsPage(WebDriver driver)
	{
    PageFactory.initElements(driver,this);
	}


//Utilization
	
	public WebElement getMdocclick() {
		return mdocclick;
	}

	
	public WebElement getFees() {
		return fees;
	}

	public WebElement getDone() {
		return done;
	}
	public WebElement gettex() {
		return tex;
	}
	public WebElement getlogbtn() {
		return logbtn;
	}
	public WebElement getalogout() {
		return alogout;
	}
	
//Business Libraries
	
	public void EditDocPage(WebDriver driver, String fee, String DocNam)
	{
		mdocclick.click();
		driver.findElement(By.xpath("//td[contains(text(),'"+DocNam+"')]/..//a[@tooltip='Edit']")).click();
		fees.sendKeys(fee);
		done.click();
		String t=tex.getText();
		System.out.println(t);
		logbtn.click();
		alogout.click();
	}
}
