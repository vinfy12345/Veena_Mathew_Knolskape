package TestScripts;
import static org.testng.AssertJUnit.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Utils.CommonMethods;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TS_TodoTest {
	
	 public static WebDriver driver;
	 CommonMethods cm=new CommonMethods();
	
	 
	 String path;
	
	  @BeforeClass
	  public void beforeClass() throws FileNotFoundException {
		  
		  cm.chromeDriverSetUp();
		  driver=cm.launchURL();
		
		  System.out.println("Title is "+driver.getTitle());
			Assert.assertEquals(driver.getTitle(),"React • TodoMVC" );

	  }
  @Test
  public void addingToDo() {
	
	  WebElement e=driver.findElement(By.xpath("//input[contains(@class,'new-todo')]"));
	  path="C:\\Users\\veena\\workspace\\Veena Mathew_Assignment\\src\\TestData\\ToDoList.properties";
	  try {
		cm.createPropertyFile(path);
	} catch (FileNotFoundException e1) {
		
		e1.printStackTrace();
	}
	  e.sendKeys(cm.readFromPropertyFile("Element1"));
	  e.sendKeys(Keys.ENTER);
	  e.sendKeys(cm.readFromPropertyFile("Element2"));
	  e.sendKeys(Keys.ENTER);
	  e.sendKeys(cm.readFromPropertyFile("Element3"));
	  e.sendKeys(Keys.ENTER);
	  e.sendKeys(cm.readFromPropertyFile("Element4"));
	  e.sendKeys(Keys.ENTER);
  }
  @Test
  
  public void completingToDo()
  {
	  
	  WebElement firstCheckBox=driver.findElement(By.xpath("//ul[contains(@class,todo-list) and contains(@data-reactid,'.0.1.1')]/li/div/label[contains(text(),'One')]/preceding-sibling::input[@type='checkbox']"));
	  WebElement secondCheckBox=driver.findElement(By.xpath("//ul[contains(@class,todo-list) and contains(@data-reactid,'.0.1.1')]/li/div/label[contains(text(),'Two')]/preceding-sibling::input[@type='checkbox']"));
	  firstCheckBox.click();
	  secondCheckBox.click();
  }
  
  
  @Test
  
  public void filteringActiveToDo() throws InterruptedException
  {
	  System.out.println("Inside filtering active Todos");
	  Thread.sleep(3000);
	  WebElement activeBtn=driver.findElement(By.xpath("//a[contains(text(),'Active')]"));
	  activeBtn.click();
  }
  
  @Test
  public void filteringAllToDo() throws InterruptedException
  {
	  System.out.println("Inside filtering All Todos");
	  Thread.sleep(3000);
	  WebElement allBtn=driver.findElement(By.xpath("//a[contains(text(),'All')]"));
	  allBtn.click();
  }
  
  @Test
  public void filteringCompletedToDo() throws InterruptedException
  {
	  System.out.println("Inside filtering Completed Todos");
	  Thread.sleep(3000);
	  WebElement completedBtn=driver.findElement(By.xpath("//a[contains(text(),'Completed')]"));
	  completedBtn.click();
  }
  @Test(dependsOnMethods={"completingToDo"})
  public void clearingCompletedToDo() throws InterruptedException
  {
	 System.out.println("Inside clearing completed");
	 Thread.sleep(3000);
	 WebElement allBtn=driver.findElement(By.xpath("//a[contains(text(),'All')]"));
	  allBtn.click();
	  Thread.sleep(3000);
	  WebElement clearCompletebtn=driver.findElement(By.xpath("//section//div[contains(@data-reactid,'.0')]//footer[contains(@class,'footer') and contains(@data-reactid,'.0.2')]//button[contains(@class,'clear-completed') and contains(text(),'Clear completed')]"));
	  clearCompletebtn.click();
	  
  }


  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }



}
