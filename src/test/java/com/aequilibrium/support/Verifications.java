package com.aequilibrium.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verifications {

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestUtils.getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestUtils.getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void verifyElementExists(WebElement element) {
		org.junit.Assert.assertTrue("Element is not available on UI when it should be.", element.isDisplayed());
	}
}