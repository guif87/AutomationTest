package com.aequilibrium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTasksElementMap {

	WebDriver driver;

	public MyTasksElementMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/* Elements from Study Hub */	

	@FindBy(xpath = "//h1[@innertext='        Hey Guilherme, this is your todo list for today:      ']")
	public WebElement msgHeader;

	@FindBy(xpath = "/html/body//form[@name='task_form']/div[@class='input-group']")
	public WebElement txtNewTask;
	
	@FindBy(xpath = "new_task")
	public WebElement txtInputNewTask;
	
	@FindBy(xpath = "/html/body//form[@name='task_form']//span")
	public WebElement btnAddTask;
	
	@FindBy(xpath = "//*[contains(@class, 'ng-scope ng-binding editable editable-click')][text()='TestQA - 1']")
	public WebElement taskCreated;	
	
	/* Notifications */
	
	//Simulate an error
	@FindBy(xpath = "//*[contains(@class, 'editable-error help-block ng-binding')][text()='Task need to have at least 3 characters']")
	public WebElement msgTaskLessThan3;
	
	//Simulate an error
	@FindBy(xpath = "//*[contains(@class, 'editable-error help-block ng-binding')][text()='Task need to have a maximum of 250 characters']")
	public WebElement msgTaskMoreThan250;	
}