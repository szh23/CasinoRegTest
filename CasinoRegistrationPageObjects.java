package casinoRegistration;

import java.util.Base64;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CasinoRegistrationPageObjects {
		private WebDriver driver = null;
	
	public CasinoRegistrationPageObjects(WebDriver driver2) {
			this.driver=driver2;
		}

	public void username_field(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
		}
	
	public void password_field(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
		Base64.getEncoder().encode(password.getBytes());
	}
	
	public void emailAddress_field(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}
	
	public void countryCode_dropDown(String country) {
         List<WebElement> countryCode =  driver.findElements(By.tagName("option"));
         String element;
		 for(int i=0;i<countryCode.size();i++) {
			element = countryCode.get(i).getAttribute("value");
			if(element.equals(country)) {
				countryCode.get(i).click();
				break;
			}
		}
    }
	
	public void acceptConditions(){
		WebElement checkbox = driver.findElement(By.id("accept-all-checkbox"));
		checkbox.click();
	}
	
	public void nextArrow() throws InterruptedException {
		WebElement next = driver.findElement(By.xpath("//div[@class='double-block-checkboxes']//button[@type='button']"));
		Thread.sleep(1000);
		next.click();
	}
	
	public void firstName(String name) {
		driver.findElement(By.name("firstname")).sendKeys(name);

	}
	
	public void lastName(String lastname) {
		driver.findElement(By.name("lastname")).sendKeys(lastname);

	}
	
	public void zipCode(String zip) {
		driver.findElement(By.name("zip")).sendKeys(zip);

	}
	
	public void address(String adres) {
		driver.findElement(By.name("address")).sendKeys(adres);

	}
	
	public void city(String town) {
		driver.findElement(By.name("city")).sendKeys(town);

	}
	
	public void phoneNumber(String phone) {
		driver.findElement(By.name("cellphone")).sendKeys(phone);

	}
	
	public void bDay(String day ) {
		driver.findElement(By.id("day")).sendKeys(day);

	}
	
	public void bMonth(String month) {
		driver.findElement(By.id("month")).sendKeys(month);

	}
	
	public void bYear(String year) {
		driver.findElement(By.id("year")).sendKeys(year);

	}
	
	public void createAccount() {
		driver.findElement(By.id("create-account-btn")).click();

	}
	
	public void verificationCheck() {
		driver.navigate().to("https://casino.com");
		WebElement joinButton = driver.findElement(By.id("spec-header-join-btn"));
		if(joinButton.isDisplayed()) {
			System.out.println("Registration test FAILED ");
		}
		else {
			System.out.println("Registration test PASS");
		}
			
	}
}
