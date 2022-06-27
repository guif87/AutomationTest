package com.aequilibrium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElementMap {

	WebDriver driver;

	public LoginElementMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/* Elements from Login Page */
	
	@FindBy(xpath = "/html//div[@id='root']//div[@class='login_wrapper-inner']")
	public WebElement pgLoginPage;
	
	@FindBy(id = "user-name")
	public WebElement lbUserName;
	
	@FindBy(id = "password")
	public WebElement lbUserPassword;
	
	@FindBy(id = "login-button")
	public WebElement btLogin;
	
	/* Messages from Login Page */
	
	@FindBy(xpath = "//h3[@innertext='Epic sadface: Username is required']")
	public WebElement msgUsernameReq;
	
	@FindBy(xpath = "//h3[@innertext='Epic sadface: Password is required']")
	public WebElement msgPasswordReq;
	
	@FindBy(xpath = "//h3[@innertext='Epic sadface: Username and password do not match any user in this service']")
	public WebElement msgNoMatchResult;
	
	@FindBy(xpath = "//h3[@innertext='Epic sadface: Sorry, this user has been locked out.']")
	public WebElement msgLockedOut;
	
	/* Elements after Login Page */
	
	@FindBy(xpath = "/html//div[@id='inventory_container']/div/div[@id='inventory_container']/div[@class='inventory_list']")
	public WebElement tbInventoryList;
	
	@FindBy(xpath = "//img[contains(@src, '/static/media/sl-404.168b1cce.jpg')]")
	public WebElement imgProblemUser;
}