package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest2
{
	@Test
	public void test2() throws MalformedURLException {
		//use RemoteWebDriver to use remotely instead of locally
			
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL u = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("http://yahoo.com");
		System.out.println(driver.getTitle());
	}
}
