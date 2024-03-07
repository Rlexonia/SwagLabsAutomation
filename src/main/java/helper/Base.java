package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
public static Properties prop;
public static WebDriver driver;
	static
	{
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/envTest.properties");
			prop= new Properties();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	 
	
	
	
		@Before
		public void setup() {
			String browserName= prop.getProperty("browser");
			switch(browserName) {
			
			case "chrome":		
				ChromeOptions option= new ChromeOptions();
				option.addArguments("--incognito");
				option.addArguments("--headless"); 		//if u want to not open the browser while running test
				driver=new ChromeDriver();
				break;
			
			case "ff":
				driver= new FirefoxDriver();
				break;
			
			case "edge":
				driver=new EdgeDriver();
				break;
			case "safari":
				driver = new SafariDriver();
		}
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}



		//public void selectValuesFromDropDown(WebElement ele, String value) {
		//Select s = new Select(ele);
		//s.selectByVisibleText(value);
		//}
	

//	public void selectValuesFromDropDown2(WebElement ele, String value) {
	//	Select s = new Select(ele);
		//s.selectByValue(value);
//}

	//public void selectValuesFromDropDown3(WebElement ele, int value) {
		//Select s = new Select(ele);
		//s.selectByIndex(value);
	//}
	// We can create three different select methods as above or we create a single one using Switch method.

		public void selectValuesFromDropDown(WebElement ele, String type, String value ) {
			Select s= new Select(ele);
			switch(type) {
			case "index":
				s.selectByIndex(Integer.parseInt(value));
			break;
			case "value":
				s.selectByValue(value);
				break;
			case "visibleText":
				s.selectByVisibleText(value);
				break;
			}
		}
			WebElement country;
			public void test() {
				selectValuesFromDropDown(country, "index", "4");
			}
		
	public void selectBootstrapDropDown(List<WebElement>list,String value) {
		
		//for(WebElement ele:list) {
		//	String actualValue = ele.getText();
		//if(actualValue.equals(value)) {
		//	ele.click();
		// break;
		//}
		//}
		List<WebElement>country= driver.findElements(By.xpath("")); // We made 2 line code instead of above long one.
		selectBootstrapDropDown(country, "India");
	}
	
	public void mouseHover(WebElement ele) {
		Actions a= new Actions(driver);
		a.moveToElement(ele).build().perform();
	}
	
	
	
	public void handleAlert(String action) {
		Alert a=driver.switchTo().alert();
		switch(action) {
		case "accept":
			a.accept();
			break;
		case "dismiss":
			a.dismiss();
			break;
		case "getvalue":
			a.getText();
			break;
		}
	}
	public void waitForExpectedElement(WebElement ele,long wait) {
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(wait));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElementToBeClickable(WebElement ele,long wait) {
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(wait));
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void clickOnElement(WebElement ele) {
		waitForElementToBeClickable(ele, 10);
		try{
			ele.click();
		}catch(Exception e) {
			waitForElementToBeClickable(ele, 10);
			executorClickOnElement(ele);
		}
	}
	public void executorClickOnElement(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();", ele);
	}
	public void validateText(WebElement ele,String expectedValue) {
		String actualValue= ele.getText();
		Assert.assertEquals(expectedValue, actualValue);//COntent compariosn
		Assert.assertTrue("home page logo is not present",ele.isDisplayed()); //Element Visibility
	}
	public void switchFrame(String type, String value) {
		switch(type) {
		case "name":
			driver.switchTo().frame(value);
			break;
		case "index":
			driver.switchTo().frame(Integer.parseInt(value));
			break;
		}
	}
	public void switchWindow(String title) {
		Set<String> allwindows= driver.getWindowHandles();
		for(String windowid:allwindows) {
			driver.switchTo().window(windowid);
			if(driver.getTitle().contains(title));
			break;
		}
	}
	public void clikonCheckbox(WebElement ele) {
		if(!ele.isSelected()) {
			clickOnElement(ele);
		}
	}
	
	@After
	public void tearDown(Scenario s) {
		if(s.isFailed()) {
	TakesScreenshot ts= (TakesScreenshot)driver;
	File capturedScr= ts.getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(capturedScr, new File("Screenshots/"+s.getName()+".png"));
	}catch (IOException e) {
		e.printStackTrace();
		//TODO Auto-Generated Catch Block
		
	}
}
		driver.quit();
}
	}
