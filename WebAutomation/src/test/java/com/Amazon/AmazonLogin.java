package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Amazon.base.BaseAmazonTest;

import com.Amazon.pages.LoginAmazonPage;

public class AmazonLogin {
	WebDriver driver;

	@Test
	public void validAmazonLogin(){
		LoginAmazonPage login = new LoginAmazonPage(driver);
		
	}
	public void invalidAmazonLogin(){
			
	}
	@Test
	public void validAmazonLoginTest(){
		//LoginAmazonPage login = new LoginAmazonPage(driver);
	//	WebDriver driver = new ChromeDriver();
		//Open Amazon
		//driver.get("https://www.amazon.in/");
		//System.out.println("Amazon is opened");
		//driver.quit();
	}

}
