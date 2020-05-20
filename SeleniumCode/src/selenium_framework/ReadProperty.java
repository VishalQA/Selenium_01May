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


public class ReadProperty {
	static WebDriver driver;

	static String Firstname ;
	
	public static void main(String[] args) throws IOException {
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
		
		System.out.println("have a good day123");
		
//		comment below from 
//		
//		driver.findElement(By.xpath((prop.getProperty("Admin_xpath")))).click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath((prop.getProperty("About_xpath")))).click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//		driver.findElement(By.xpath((prop.getProperty("About_close_xpath")))).click();
////		
//		driver.findElement(By.xpath((prop.getProperty("PIM_Xpath")))).click();
//		driver.findElement(By.xpath((prop.getProperty("AddEmployee_xpath")))).click();
//		
//			comment till
//		
//		driver.findElement(By.xpath((prop.getProperty("FirstName_xpath")))).sendKeys(prop.getProperty("FirstName"));
//		driver.findElement(By.xpath((prop.getProperty("LastName_xpath")))).sendKeys(prop.getProperty("LastName"));
//		driver.findElement(By.xpath((prop.getProperty("ChooseFile_xpath")))).sendKeys(prop.getProperty("Filename"));
//		
//		  System.out.println(driver.findElement(By.xpath((prop.getProperty("createlogincheckbox_xpath")))).isSelected());  
//		  driver.findElement(By.xpath((prop.getProperty("createlogincheckbox_xpath")))).click();
//		  
//		  driver.findElement(By.xpath((prop.getProperty("newusername_xpath")))).sendKeys(prop.getProperty("FirstName"));
//		  driver.findElement(By.xpath((prop.getProperty("newpassword_xpath")))).sendKeys(prop.getProperty("newpassword"));
//		  driver.findElement(By.xpath((prop.getProperty("confirmpassword_xpath")))).sendKeys(prop.getProperty("confirmpassword"));
//		  
//		  comment from 
//		  Select dropdown = new Select(driver.findElement(By.xpath("status_xpath")));  
//		    dropdown.selectByVisibleText("Enabled");  
//		  comment till
//		  
//		driver.findElement(By.xpath((prop.getProperty("save_xpath")))).click();
//		System.out.println("The user is created with FirstName as ---->   FisrtName");
//		
//		
//		driver.findElement(By.xpath((prop.getProperty("AddEmployee_xpath")))).click();
//		System.out.println("Correct");
//	
		
//		driver.findElement(By.xpath(prop.getProperty("employeelisttab_xpath"))).click();
//		driver.findElement(By.xpath(prop.getProperty("searchemployeename_xpath"))).clear();
//		driver.findElement(By.xpath(prop.getProperty("searchemployeeid_xpath"))).sendKeys(prop.getProperty("searchemployeeidvalue"));
////		driver.findElement(By.xpath(prop.getProperty("searchemployeename_xpath"))).sendKeys(prop.getProperty("Searchname"));
//		driver.findElement(By.xpath(prop.getProperty("serachbutton_xpath"))).click();
//		driver.findElement(By.xpath("//a[contains(text(),'0011')]")).click();
//		driver.findElement(By.xpath(prop.getProperty("Employeeeditbutton_xpath"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Myinfotab_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("Myinfoedit_xpath"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("Myinfocalender_xpath"))).click();
//    	driver.findElement(By.xpath(prop.getProperty("Myinfoyeardropdwon_xpath"))).click();
//		driver.findElement(By.xpath(prop.getProperty("Myinfomonthdropdown_xpath"))).click();
    	
		
		
		String date = "13-May-2030";
		String dateArr[]= date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select  = new Select (driver.findElement(By.xpath(prop.getProperty("Myinfomonthdropdown_xpath"))));
				select.selectByVisibleText(month);
				
				Select select1  = new Select (driver.findElement(By.xpath(prop.getProperty("Myinfoyeardropdwon_xpath"))));
				select1.selectByVisibleText(year);
				
				String beforexpath = "//tr[";
				String afterxpath	= "]//td[";
				
				final int totalweekdays = 7;
				boolean flag = false;
				String dayvalue = null;
				for (int rownum = 1;rownum<= 5; rownum++) {
					for (int columnnum = 1 ; columnnum <=7 ; columnnum++) {
						
						
					try {
					 dayvalue = 	driver.findElement(By.xpath(beforexpath+rownum+afterxpath+columnnum+"]")).getText();
					}catch(NoSuchElementException e) {
						System.out.println("Please enete correct date");
						flag = false;
						break;
					}
					System.out.println(dayvalue);
					
					if (dayvalue.equals(day)) {
						driver.findElement(By.xpath(beforexpath+rownum+afterxpath+columnnum+"]")).click();
						flag = true;
						break;
					}
					}
					if (flag)
					{
						break;
					}
//				}
//		
				
				//tr[1]//td[1]
				//tr[1]//td[2]
				//tr[1]//td[3]
				//tr[1]//td[4]
				//tr[1]//td[5]
				//tr[1]//td[6]
				//tr[1]//td[7]
				
				
				
//		WebElement select = driver.findElement(By.xpath("//a[contains(text(),'Id')]"));
//		List<WebElement> options = select.findElements(By.linkText("0011"));
//		for (WebElement option : options) {
//		if("0011".equals(option.getText()))
//		option.click();
//		}
//		
//		comment from 
		
//		driver.findElement(By.xpath(prop.getProperty("searchemployeename_xpath"))).click();
		
		
//		driver.findElement(By.xpath((prop.getProperty("Admin_xpath")))).click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath((prop.getProperty("logout_xpath")))).click();
//		
//		driver.findElement(By.xpath((prop.getProperty("username_xpath")))).sendKeys(prop.getProperty("username"));
//		driver.findElement(By.xpath((prop.getProperty("password_xpath")))).sendKeys(prop.getProperty("password"));
//		driver.findElement(By.xpath((prop.getProperty("login_xpath")))).click();
//		
//		comment till
		}
	

				driver.findElement(By.xpath(prop.getProperty("Myinfogenderradiobutton_xpath"))).click();
				Select maritalstatus = new Select(driver.findElement(By.xpath(prop.getProperty("Myinfomaritaldrpdn_xpath"))));
				maritalstatus.selectByVisibleText("Married");
				
				
				Select Nationality = new Select(driver.findElement(By.xpath(prop.getProperty("Nationality_xpath"))));
				Nationality.selectByVisibleText("Indian");
				
				driver.findElement(By.xpath(prop.getProperty("Myinfosave_xpath"))).click();
				
	}
}


