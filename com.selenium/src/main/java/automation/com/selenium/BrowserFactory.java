package automation.com.selenium;


import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	
	
	 static WebDriver driver;

	public BrowserFactory(WebDriver driver)
	{
		BrowserFactory.driver=driver;
	}
	
	public static WebDriver Browser(String browser, String url) throws FileNotFoundException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjit\\Downloads\\chromedriver_win32\\chromedriver.exe");
				
				DesiredCapabilities caps=new DesiredCapabilities();
				caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);  //handle SSL certificates
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");  
					
				options.merge(caps);  // merge capabilities with chromeoptions
				
				driver = new ChromeDriver(options); //starts the chrome session
				
				driver.manage().window().maximize();
				
				driver.get(url);		
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		else if (browser.equalsIgnoreCase("ie")) 
		{
			
			driver = new InternetExplorerDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ranjit\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		return driver;
	}
	
	public static void CloseApplication()
	{
		driver.quit();
	}

}
