package selenium_framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementCordinates {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		

		driver.get("https://www.google.com/");
 }
 
 @Test
 public  void getCoordinates() throws Exception {
  //Locate element for which you wants to retrieve x y coordinates.
        WebElement Image = driver.findElement(By.xpath("//img[@id='hplogo']"));
        
        //Used points class to get x and y coordinates of element.
        Point point = Image.getLocation();
        int xcord = point.getX();
        System.out.println("Element's Position from left side Is "+xcord +" pixels.");
        int ycord = point.getY();
        System.out.println("Element's Position from top side Is "+ycord +" pixels.");
 }
}