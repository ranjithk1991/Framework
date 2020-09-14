package automation.com.selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;

import javax.print.attribute.standard.Destination;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class LoginSample {

	WebDriver driver;
	ExtentTest test;
	ExtentReports rep;
	
	@Parameters({"user","pass"})
	@Test
	public void orangeDemoLogin(String user, String pass) throws FileNotFoundException
	{
		driver = BrowserFactory.Browser("chrome", "https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(true, false);
		
	}
	@BeforeMethod
	public void Reporter()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentRep/ExtenttestRun.html");
		rep = new ExtentReports();
		rep.attachReporter(reporter);
		
		test = rep.createTest("orangeDemoLogin");

	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()== result.FAILURE)
		{
	
			test.fail("test failed");
		}
		rep.flush();
		driver.quit();
	}
}
