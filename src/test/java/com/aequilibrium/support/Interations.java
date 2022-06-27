package com.aequilibrium.support;

import org.openqa.selenium.WebElement;

public class Interations {

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void setTextOnElement(WebElement element, String elementContent) {
		element.sendKeys(elementContent);
	}

	public static void clearField(WebElement element) {
		element.clear();
	}
}