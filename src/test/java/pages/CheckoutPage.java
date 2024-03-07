package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class CheckoutPage extends Base{
	public void user_enter_personal_details(String fname, String lname, String pcode) {
		WebElement firstName=driver.findElement(By.cssSelector("input#first-name"));
		firstName.sendKeys(fname);
		WebElement lastName=driver.findElement(By.cssSelector("input#last-name"));
		lastName.sendKeys(lname);
		WebElement postalCode=driver.findElement(By.cssSelector("input#postal-code"));
		postalCode.sendKeys(pcode);
	}
	public void clickOnContinueBtn() {
		WebElement continueBtn=driver.findElement(By.cssSelector("input#continue"));
		clickOnElement(continueBtn);
	}
	public void validate_user_navigate_to_checkout_two_page() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("step-two"));
		 
}
	public void validate_error_message() {
		WebElement errorMessage=driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertTrue(errorMessage.isDisplayed());
	}
}