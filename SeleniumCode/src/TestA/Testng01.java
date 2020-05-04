package TestA;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Testng01 {
	
	
	@ BeforeClass
	public void launchbrowser() {
		System.out.println("Launch the browser");
	}
	
	
	
	
	@BeforeTest
	public void setup() {
		System.out.println("SETUP");
	}


}
