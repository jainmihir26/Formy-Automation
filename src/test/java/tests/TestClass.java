package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{
	
	@Test
	public void testKeyBoardMouse() {
		driver.get("http://formy-project.herokuapp.com/keypress");
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		name.sendKeys("Mihir Jain");
		
		WebElement button = driver.findElement(By.id("button"));
		button.click();
		
		System.out.println("testKeyBoardMouse completed");
	}
	
	@Test
	public void testAutocomplete() {
		driver.get("http://formy-project.herokuapp.com/autocomplete");
		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("local bus stand road Sector 17");
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));
		option.click();
		System.out.println("testAutocomplete completed");
	}
	
	@Test
	public void testScroll() {
		driver.get("http://formy-project.herokuapp.com/scroll");
		WebElement name = driver.findElement(By.id("name"));
		Actions actions = new Actions(driver);
		actions.moveToElement(name);
		name.sendKeys("Mihir Jain");
		
		WebElement date = driver.findElement(By.id("date"));
		date.sendKeys("10.04./2020");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("testScroll Complete");
	}
	
	@Test
	public void switchToActiveWindow() {
		driver.get("http://formy-project.herokuapp.com/switch-window");
		WebElement newTab = driver.findElement(By.id("new-tab-button"));
		String orignalHandle = driver.getWindowHandle();
		newTab.click();
		
		for(String handle1 : driver.getWindowHandles())
			driver.switchTo().window(handle1);
		
		driver.switchTo().window(orignalHandle);
		System.out.println("Switch to active window Passed");
		
	}
	
	@Test
	public void switchToAlert() {
		driver.get("http://formy-project.herokuapp.com/switch-window");
		WebElement newAlert = driver.findElement(By.id("alert-button"));
		newAlert.click();		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Alert Passed");
		
	}
	
	@Test
	public void javascriptModal() {
		driver.get("http://formy-project.herokuapp.com/modal");
		WebElement modal = driver.findElement(By.id("modal-button"));
		modal.click();
		
		
		WebElement close = driver.findElement(By.id("close-button"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", close);
		System.out.println("JavascriptExecutor passed successfully");
		
	}
	
//	@Test
//	public void DragAndDrop() {
//		driver.get("http://formy-project.herokuapp.com/dragdrop");
//		
//		WebElement image = driver.findElement(By.id("image"));
//		WebElement box = driver.findElement(By.id("box"));
//		
//		Actions actions = new Actions(driver);
//		actions.dragAndDrop(image, box).build().perform();
//		System.out.println("DragandDrop success");
//		
//	}
	
	@Test
	public void AutomateRadioButton() {
		driver.get("http://formy-project.herokuapp.com/radiobutton");
		WebElement radio1 = driver.findElement(By.id("radio-button-1"));
		radio1.click();
		WebElement radio2 = driver.findElement(By.cssSelector("input[value = 'option2']"));
		radio2.click();
		WebElement radio3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
		radio3.click();
		System.out.println("Radio Button Passed");
		
	}
	
	@Test
	public void AutomateCheckBox() {
		driver.get("http://formy-project.herokuapp.com/checkbox");
		WebElement checkBox1 = driver.findElement(By.cssSelector("input[id='checkbox-1']"));
		checkBox1.click();
		WebElement checkBox2 = driver.findElement(By.cssSelector("input[id='checkbox-2']"));
		checkBox2.click();
		WebElement checkBox3 = driver.findElement(By.cssSelector("input[id='checkbox-3']"));
		checkBox3.click();
		System.out.println("Checkbox Passed");
	}
	
	
	@Test
	public void DatePicker() {
		driver.get("http://formy-project.herokuapp.com/datepicker");
		WebElement date = driver.findElement(By.id("datepicker"));
		date.sendKeys("10/04/2020");
		date.sendKeys(Keys.RETURN);
		System.out.println("DatePicker Passed");
	}
	
	
	@Test
	public void DropDown() {
		driver.get("http://formy-project.herokuapp.com/dropdown");
		WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));
		dropdownButton.click();
		
		WebElement buttons = driver.findElement(By.xpath("/html/body/div/div/div/a[2]"));
		buttons.click();
		System.out.println("DropDown Passed");
	}
	
	@Test
	public void fileUpload() {
		driver.get("http://formy-project.herokuapp.com/fileupload");
		WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
		fileUpload.sendKeys("example.png");
		WebElement button = driver.findElement(By.cssSelector("button[class = 'btn btn-warning btn-reset']"));
		button.click();
		System.out.println("File uploaded success");
	}
	
	@Test
	public void fullForm() {
		driver.get("http://formy-project.herokuapp.com/form");
		WebElement firstName = driver.findElement(By.cssSelector("input[id='first-name']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[id='last-name']"));
		WebElement jobTitle = driver.findElement(By.cssSelector("input[id='job-title']"));
		
		firstName.sendKeys("Mihir");
		lastName.sendKeys("Jain");
		jobTitle.sendKeys("SQA");
		
		
		WebElement radioButton1 = driver.findElement(By.cssSelector("input[id='radio-button-1']"));
		radioButton1.click();
		
		WebElement checkBox1 = driver.findElement(By.cssSelector("input[id='checkbox-1']"));
		checkBox1.click();
		
		WebElement dropDown = driver.findElement(By.cssSelector("select[id='select-menu']"));
		dropDown.click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value = '1']")));
		option.click();
		
		WebElement date = driver.findElement(By.cssSelector("input[id = 'datepicker']"));
		date.sendKeys("10/04/2020");
		date.sendKeys(Keys.ENTER);
		
		WebElement submit = driver.findElement(By.cssSelector("a[class = 'btn btn-lg btn-primary']"));
		submit.click();
		
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alert alert-success']")));
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "The form was successfully submitted!");
		
		System.out.println("Form completed");
	}
	
	
	
	
}
