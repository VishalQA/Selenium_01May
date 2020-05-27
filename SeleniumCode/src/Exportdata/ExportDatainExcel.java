package Exportdata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExportDatainExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforexpath_comapny = "//*[@id='customers']/tbody/tr[";
		String afterxpath_comapny = "]/td[1]";
		
		String beforxpath_contact = "//*[@id='customers']/tbody/tr[";
		String afterxpath_contact = "]/td[2]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total number of rows ---> "   + (rows.size()-1));
		int rowcount = rows.size();
				
		Xls_Reader reader = new Xls_Reader ("C:\\Users\\jaju_v\\git\\2020\\SeleniumCode\\src\\testnew\\Testdata1.xlsx");
		reader.
		
		
		for (int i = 2; i<=7; i++) {
			String actualxpath_comapny = beforexpath_comapny+i+afterxpath_comapny;
			String companyname = driver.findElement(By.xpath(actualxpath_comapny)).getText();
			System.out.println(companyname);
			
			String actualxpath_contact = beforxpath_contact+i+afterxpath_contact;
			String contactname = driver.findElement(By.xpath(actualxpath_contact)).getText();
			System.out.println(contactname);
			
		}
			
		

	}

}
