package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
	Properties prop=new Properties();
	InputStream fpr=null;
	String pathfile;
	
	public void chromeDriverSetUp()
	{
		String driverPath = "C:\\";
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	}

	public WebDriver launchURL()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://todomvc.com/examples/react/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public void createPropertyFile(String path) throws FileNotFoundException
	{
		pathfile=path;
		fpr=new FileInputStream(path);
		
		try {
			prop.load(fpr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readFromPropertyFile(String key) 
	{
		//String value;
		//try {
			//createPropertyFile(pathfile);
			
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		return prop.getProperty(key);
	}
	
}
