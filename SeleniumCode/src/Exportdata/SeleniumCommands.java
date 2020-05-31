package Exportdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com");
		Thread.sleep(4000L);
		
		WebElement a = driver.findElement(By.xpath("//*[@id='mySidenav']/div/div[1]/h4"));
		String b = a.getAttribute("class");
		System.out.println("1. The value of the attributes is --->" +b);
		a.getClass();
		System.out.println("2. The value of the class is --->"  +a);
		String c = driver.getCurrentUrl();
		System.out.println("3. The value of the current  URL is --->"  +c);
		String pagesource = driver.getPageSource();
		System.out.println("4. The value of the pagesource is --->"  +pagesource);
		
//		WebElement dropdown = driver.findElement(By.xpath(xpathExpression))
		
	
		
		

	}

}
