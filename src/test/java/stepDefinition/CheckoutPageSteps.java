package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckoutPage;

public class CheckoutPageSteps {
CheckoutPage checkout= new CheckoutPage();
	@Then("user enter personal details {string} {string} {string}")
	public void user_enter_personal_details(String fname, String lname, String pcode) {
		checkout.user_enter_personal_details(fname, lname, pcode);
	
		}
	@And ("user click on Continue button")
	public void user_click_on_Continue_button() {
		checkout.clickOnContinueBtn();
	}

	@Then ("validate user navigate to checkout two page")
	public void validate_user_navigate_to_checkout_two_page() {
			
}
	@Then("checkout validate error message")
	public void validate_error_message() {
		checkout.validate_error_message();
	}
}
