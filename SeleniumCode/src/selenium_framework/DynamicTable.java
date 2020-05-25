package selenium_framework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;



public class DynamicTable {
	static WebDriver driver;

	static String Firstname ;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\jaju_v\\git\\2020\\SeleniumCode\\src\\selenium_framework\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		String url = prop.getProperty("url");
		System.out.println(url);
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\jaju_v\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\jaju_v\\Downloads\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			
		}
		
		driver.get(url);
		driver.manage().window().maximize();  
		driver.findElement(By.xpath((prop.getProperty("username_xpath")))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath((prop.getProperty("password_xpath")))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath((prop.getProperty("login_xpath")))).click();
		
		System.out.println("Step 1 - DashBorad page opened ");
		driver.findElement(By.xpath((prop.getProperty("PIM_Xpath")))).click();
		System.out.println("Step 2 - PIM Page opened");
		driver.findElement(By.xpath(prop.getProperty("employeelisttab_xpath"))).click();
		System.out.println("Step 3 - Employee List page opened");
		
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[3]/a";
		
		for (int i=1;i<=10;i++) {
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
			if (name.contains("Russel")) {
//				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[1]/a")).click();
				//*[@id="ohrmList_chkSelectRecord_8"]
				driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_"+i+"\"]")).click();
//				driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_"+i+"\"]")).click();
				//*[@id="resultTable"]/tbody/tr[8]/td[3]/a
//				int j =i;
				driver.findElement(By.xpath("//a[contains(text(),'000"+i+"')]")).click();
			}
		}
		System.out.println("Step 4 - Employee List is displayed");
		System.out.println("Step 5 - Employee - Russel -checkbox  is selected");
		
		
	}

}
