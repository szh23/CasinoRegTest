package casinoRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		//Use this to enable VPN manually
		driver.get("opera://settings/privacy");
		Thread.sleep(5000);
		
		CasinoRegistrationPageObjects regPageObj = new CasinoRegistrationPageObjects(driver);
		
		driver.get("https://casino.com");
		driver.manage().window().maximize();

		driver.findElement(By.id("spec-header-join-btn")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		
		regPageObj.username_field("Testern233");
		regPageObj.password_field("Test23$^");
		regPageObj.emailAddress_field("Registration.tester@qa.com");
		regPageObj.countryCode_dropDown("MK");
		regPageObj.acceptConditions();
		regPageObj.nextArrow();
		
		Thread.sleep(1000);
		
		regPageObj.firstName("Munio");
		regPageObj.lastName("Testoviq");
		regPageObj.zipCode("1000");
		regPageObj.address("Opulchenska 23");
		regPageObj.city("Skopie");
		regPageObj.phoneNumber("2323232");
		regPageObj.bDay("05");
		regPageObj.bMonth("07");
		regPageObj.bYear("1900");
		regPageObj.createAccount();
		
		Thread.sleep(3000);
		
		driver.navigate().to("https://casino.com");
		regPageObj.verificationCheck();
		driver.quit();
		
		
        
	}

}
