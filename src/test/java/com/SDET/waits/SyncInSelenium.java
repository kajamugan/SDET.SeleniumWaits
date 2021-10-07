package com.SDET.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncInSelenium {
  public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\blver\\Desktop\\chromedriver_win32\\chromedriver.exe");
	WebDriver Driver = new ChromeDriver();
	
	Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	//implicitly wait is always applied globally for all web elements which is interact with Driver object
	Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
     Driver.get("https://www.facebook.com/");
     
     WebElement createAccount = Driver.findElement(By.linkText("Create New Account"));
     clickOn(Driver, createAccount, 5);
     
     WebElement FirstName = Driver.findElement(By.xpath("//input[@name='firstname']"));
     WebElement LastName = Driver.findElement(By.xpath("//input[@name='lastname']"));
     WebElement MobEmail = Driver.findElement(By.xpath("//input[@name='reg_email__']"));
     WebElement Password = Driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
	 
     sendKeys(Driver, FirstName, 10, "Steve");
     sendKeys(Driver, LastName, 5, "Jobs");
     sendKeys(Driver, MobEmail, 5, "094838484");
     sendKeys(Driver, Password, 5, "St!@#$%^123456");
     
//     Driver.findElement(By.linkText("Already have an account?")).click();
//    
//     WebElement forgotAccount = Driver.findElement(By.linkText("Forgotten account?"));
//     clickOn(Driver, forgotAccount, 5);
     
     Driver.close();
  }
  
  //Explicitly waits always apply with WebDriverWait method
  public static void sendKeys(WebDriver Driver, WebElement element, int timeout, String value) {
	  new WebDriverWait(Driver, timeout).until(ExpectedConditions.visibilityOf(element));
	  element.sendKeys(value);
  }
  
  public static void clickOn(WebDriver Driver, WebElement element, int timeout) {
	  new WebDriverWait(Driver, timeout).until(ExpectedConditions.visibilityOf(element));
	  element.click();
  }
  
 
  
  
}
