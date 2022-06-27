package com.aequilibrium.steps;
import com.aequilibrium.pages.LoginElementMap;
import com.aequilibrium.support.Interations;
import com.aequilibrium.support.TestUtils;
import com.aequilibrium.support.Verifications;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class LoginSteps {

	LoginElementMap objLogin = new LoginElementMap(TestUtils.getDriver());

	@Given("^I have accessed SwagLabs login page$")
	public void i_have_accessed_swaglabs_login_page(){
		Verifications.wait(2);
		Verifications.verifyElementExists(objLogin.pgLoginPage);
	}
	
	@Then("^I Validate that labels and button are correct$")
	public void i_validate_that_labels_and_button_are_correct(){
		Verifications.wait(2);
		Verifications.verifyElementExists(objLogin.lbUserName);
		Verifications.verifyElementExists(objLogin.lbUserPassword);
		Verifications.verifyElementExists(objLogin.btLogin);
	}
	
	@Then("^I fill in the user '(.*)'$")
	public void i_fill_in_the_user(String username) throws Throwable {
		Verifications.wait(1);
		Interations.setTextOnElement(objLogin.lbUserName, username);
	}
	
	@And("^I fill the password '(.*)'$")
	public void i_fill_the_password_to_access_skyan_page(String password) throws Throwable {
		Verifications.wait(1);
		Interations.setTextOnElement(objLogin.lbUserPassword, password);
	}

	@When("^I click on Login button to proceed$")
	public void i_click_on_login_button_to_proceed() {
		Verifications.wait(1);
		Interations.clickOnElement(objLogin.btLogin);
	}

	@Then("^I validate list of products after login$")
	public void i_validate_list_of_products_after_login() {
		Verifications.wait(1);
		Verifications.verifyElementExists(objLogin.tbInventoryList);
	}
	
	@Then("^I validate list of products with wrong photos$")
	public void i_validate_list_of_products_with_wrong_photos() {
		Verifications.wait(1);
		Verifications.verifyElementExists(objLogin.imgProblemUser);
	}
	
	@Then("^I validate the error message '(.*)'$")
	public void i_validate_the_error_message(String type) throws Throwable {
		Verifications.wait(1);
		switch (type) {
		case "Username required":
			Verifications.verifyElementExists(objLogin.msgUsernameReq);
			break;
		case "Password required":
			Verifications.verifyElementExists(objLogin.msgPasswordReq);
			break;
		case "Not in system":
			Verifications.verifyElementExists(objLogin.msgNoMatchResult);
			break;
		case "Locked Out":
			Verifications.verifyElementExists(objLogin.msgLockedOut);
			break;
		}
	}
}