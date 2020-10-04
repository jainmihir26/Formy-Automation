package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
		
		public WebDriver driver;
		
		@BeforeTest
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\mjain\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		@AfterTest
		public void teardown() {
			driver.close();
			driver.quit();
		}
}
