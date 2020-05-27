package selenium_framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GoogleSerach {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
//		WebDriver driver = new HtmlUnitDriver();
		
		WebDriver mydriver = new ChromeDriver();
		
		
		
		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get("https://www.google.com/");
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class ='sbtc']"));
//		
//		System.out.println("The number of the search options are --->" +list.size());
//		for (int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			if (list.get(i).getText().contains("testing tools")) {
//				list.get(i).click();
//				System.out.println("The serach result selected as - > testing tools");
//				break;
//			}
//		}
//		
//		
//		
//		
//		
//		
//
//	}

}
}