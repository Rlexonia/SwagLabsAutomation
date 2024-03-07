package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

	public class BasketPage extends Base {
	public void clickonAddToCart() {
	WebElement addToCartBtn=driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")); //	#add-to-cart-sauce-labs-backpack
	clickOnElement(addToCartBtn);
}
	public void validateCartCount(String count) {
		WebElement cartCount=driver.findElement(By.cssSelector("span.shopping_cart_badge")); 	//a.shopping_cart_link
		String cartvalue=cartCount.getText();
		Assert.assertEquals(count, cartvalue);

	
}
	public void user_navigate_to_checkout_page() {
		WebElement cartLink= driver.findElement(By.cssSelector("a.shopping_cart_link"));
		clickOnElement(cartLink);
		WebElement checkoutBtn= driver.findElement(By.xpath("//button[@id='checkout']"));
		clickOnElement(checkoutBtn);
}

	}