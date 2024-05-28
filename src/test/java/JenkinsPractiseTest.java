import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class JenkinsPractiseTest {

	@Test
	public void Test1()
	{
		WebDriver driver= null;
		String browser=System.getProperty("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		Reporter.log("********Login**********", true);
		Reporter.log("********Logout**********", true);
		//hi
	}
}
