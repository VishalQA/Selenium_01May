package selenium_framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProperty {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\jaju_v\\git\\2020\\SeleniumCode\\src\\TestA\\config.properties");
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
		
		System.out.println("have a good day123");
			
		}
		
		
	}


