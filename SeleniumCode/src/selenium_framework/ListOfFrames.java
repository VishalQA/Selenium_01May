package selenium_framework;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ListOfFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		

		driver.get("https://www.ndtv.com/");
		
//		driver.switchTo().frame("Fancybox-frame");
//
//		driver.findElement(By.xpath(""))).click();
//
//		driver.switchTo().defaultContent();
		
		int framesize = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The number of frames in the website ndtv are --->" +framesize);
		
		Set<String> windowhandle = driver.getWindowHandles();
		System.out.println("The name of the windowhandle is ---->"  +windowhandle);
		


		
		  //Assume driver is initialized properly. 
	    List<WebElement> ele = driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(WebElement el : ele){
	      //Returns the Id of a frame.
	        System.out.println("Frame Id :" + el.getAttribute("id"));
	      //Returns the Name of a frame.
	        System.out.println("Frame name :" + el.getAttribute("name"));
	                
	    }
	    
	    driver.switchTo().frame("t19");
	    String frametitle1 = driver.getTitle();
	    System.out.println("The frame title is - >"  + frametitle1);
	    
	    Scanner input = new Scanner( System.in);
	    System.out.println("Please enter the index no of the frame to get the title ");
	    int frameindexnumber = input.nextInt();
	    System.out.println(" The index number of the frame you entered as - "  +frameindexnumber);
	    
		String frametitle = driver.switchTo().frame(frameindexnumber).getTitle();
	    System.out.println("The title of the frame with index number --->  " +  frameindexnumber  +  " is--->  "  +frametitle);
	    
	    


}
}