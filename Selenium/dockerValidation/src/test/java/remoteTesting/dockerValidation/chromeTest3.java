package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeTest3 
{
	public static void main(String[] args)throws MalformedURLException {
		//use RemoteWebDriver to use remotely instead of locally
			
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL u = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("http://bing.com");
		System.out.println(driver.getTitle());
	}
}
